package com.intheeast.controller.initbinder;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intheeast.model.ChangeEmailForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/initbinder")
public class MyControllers {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
    	binder.setAllowedFields("oldEmailAddress", "newEmailAddress");
        binder.setDeclarativeBinding(true);  // 생성자 바인딩 사용
    }

    // 생성자 바인딩을 통해 특정 필드만 처리하는 메서드
    @PostMapping("/changeEmailWithConstructorBinding")
    public String changeEmail(@ModelAttribute ChangeEmailForm form, Model model) {
        // 이메일 변경 로직
        if (form.getOldEmailAddress().equals(form.getNewEmailAddress())) {
            model.addAttribute("message", "The new email address must be different from the old one.");
        } else {
            model.addAttribute("message", "Email successfully changed from " + form.getOldEmailAddress() + " to " + form.getNewEmailAddress());
        }
        return "initbinder/changeEmailSuccessWithCB";
    }
}