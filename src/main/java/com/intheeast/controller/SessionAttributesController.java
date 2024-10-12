package com.intheeast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.intheeast.model.Pet;

import org.springframework.validation.BindingResult;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.logging.Logger;

@Controller
@RequestMapping("/pet")
@SessionAttributes("petList")  // "petList"를 세션에 저장하여 관리
public class SessionAttributesController {

    private static final Logger logger = 
    		Logger.getLogger(SessionAttributesController.class.getName());

    // 세션에 petList가 없으면 새로운 petList를 추가하여 세션에 저장
    @ModelAttribute("petList")
    public List<Pet> setUpPetList(HttpSession session) {
        @SuppressWarnings("unchecked")
		List<Pet> petList = (List<Pet>) session.getAttribute("petList");
        
        // 세션에 "petList"가 없으면 새로운 ArrayList 생성
        if (petList == null) {
            petList = new ArrayList<>();
            session.setAttribute("petList", petList);  // 세션에 저장
            logger.info("Created new petList as it was null and saved in session.");
        } else {
            logger.info("Loaded existing petList from session.");
        }
        
        return petList;  // 세션에 있던 기존 petList 반환 또는 새로운 petList 반환
    }

    // 새로운 Pet 추가 폼으로 이동하는 핸들러
    @GetMapping("/new")
    public String showNewPetForm(Model model) {
        model.addAttribute("pet", new Pet());  // 새로운 Pet 객체를 모델에 추가
        return "handlermethod/newPetForm";  // 새로운 Pet 추가를 위한 폼 페이지로 이동
    }

    // 새로운 Pet을 추가하는 POST 요청 핸들러 메서드
    @PostMapping("/new")
    public String addNewPet(@Valid Pet pet, 
                            @ModelAttribute("petList") List<Pet> petList,
                            BindingResult result,
                            SessionStatus status) {
        if (result.hasErrors()) {
            return "handlermethod/newPetForm";  // 유효성 검사 실패 시 다시 폼으로 이동
        }
        // 기존 Pet 목록에서 가장 큰 petId 찾기
        OptionalInt maxPetId = petList.stream()
                .mapToInt(p -> Integer.parseInt(p.getPetId()))
                .max();        
        // 새로 추가될 Pet의 petId 설정 (가장 큰 petId + 1)
        int newPetId = maxPetId.orElse(0) + 1;
        pet.setPetId(String.valueOf(newPetId));
        
        // 새로운 Pet 객체를 목록에 추가
        petList.add(pet);
        logger.info("Added new Pet to petList: " + pet);
        
        return "redirect:/pet/list";  // Pet 목록 페이지로 리다이렉트
    }

    // Pet 목록을 보여주는 페이지로 이동
    @GetMapping("/list")
    public String showPetList(@ModelAttribute("petList") List<Pet> petList, Model model) {
        // 세션에서 Pet 목록을 가져옴
        if (petList != null && !petList.isEmpty()) {
            logger.info("Loaded petList from session: " + petList);
            model.addAttribute("petList", petList);  // 모델에 Pet 목록 추가
        } else {
            logger.warning("No pets found in session.");
            model.addAttribute("message", "No pets found in session.");
        }

        return "handlermethod/petList";  // 목록 페이지로 이동
    }
}
