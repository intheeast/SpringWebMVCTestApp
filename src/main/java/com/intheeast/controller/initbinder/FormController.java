package com.intheeast.controller.initbinder;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;

@Controller
@RequestMapping("/initbinder")
public class FormController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);  // 엄격한 날짜 형식 사용
        binder.registerCustomEditor(Date.class, 
        		new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("/submitForm")
    public String submitForm(@RequestParam("date") Date date, Model model) {
        // Date 객체를 모델에 추가
        model.addAttribute("submittedDate", date);
        return "initbinder/success";  // success.jsp로 이동
    }
}