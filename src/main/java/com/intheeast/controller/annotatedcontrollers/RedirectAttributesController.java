package com.intheeast.controller.annotatedcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectAttributesController {
	
	// 폼 데이터 처리 및 리다이렉트
    @PostMapping("/submitForm")
    public String submitForm(String name, int age, RedirectAttributes redirectAttributes) {
        // 리다이렉트 시 URL에 추가될 속성 지정
        redirectAttributes.addAttribute("name", name);  // 쿼리 파라미터로 전달
        redirectAttributes.addAttribute("age", age);    // 쿼리 파라미터로 전달
        
        // 플래시 속성: URL에 나타나지 않으며, 리다이렉트 이후 사용 가능
        //          success 메서드에서 아래 속성을 사용 가능함.
        redirectAttributes.addFlashAttribute("successMessage", 
        		"Form submitted successfully!");

        return "redirect:/success";
    }

    // 리다이렉트 이후 처리 (쿼리 파라미터와 플래시 속성 사용)
    @GetMapping("/success")
    public String success(@RequestParam String name, @RequestParam int age, Model model) {
        // name과 age는 URL 쿼리 파라미터로 전달됨
        // 플래시 속성은 Model에 자동으로 추가됨
        return "handlermethod/successPage";  // 해당 페이지로 이동
    }

}
