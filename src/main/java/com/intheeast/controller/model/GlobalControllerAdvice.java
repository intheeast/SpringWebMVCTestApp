package com.intheeast.controller.model;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(basePackages = "com.intheeast.controller.model")
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        // 모든 뷰에 추가될 공통 데이터
        System.out.println("called addGlobalAttributes");

        model.addAttribute("globalMessage", "Welcome to our website!");
    }
}