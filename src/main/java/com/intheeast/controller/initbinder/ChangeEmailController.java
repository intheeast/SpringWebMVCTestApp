package com.intheeast.controller.initbinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/initbinder")
public class ChangeEmailController {
	
	private static final Logger log = 
			LoggerFactory.getLogger(ChangeEmailController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // oldEmailAddress와 newEmailAddress 필드만 허용
        binder.setAllowedFields("oldEmailAddress", "newEmailAddress");
    }

    // 이메일 변경 요청 처리
    // @InitBinder에서 특정 필드를 허용하는 것은 객체 바인딩에만 영향을 미치고, 
    // @RequestParam과 같은 방식으로 직접 필드를 받는 경우에는 적용되지 않음
    @PostMapping("/changeEmail")
    public String changeEmail(@RequestParam("oldEmailAddress") String oldEmail,
                              @RequestParam("newEmailAddress") String newEmail, 
                              //@RequestParam(value = "unauthorizedField", required = false) String unauthorizedField,
                              Model model) {
        // 이메일 변경 로직
        if (oldEmail.equalsIgnoreCase(newEmail)) {
            model.addAttribute("message", 
            		"The new email address must be different from the old one.");
        } else {
            model.addAttribute("message", 
            		"Email successfully changed from " + oldEmail + " to " + newEmail);
        }

        // 허용되지 않은 필드가 전달된 경우 처리
//        if (unauthorizedField != null) {
//        	log.info("Unauthorized field was ignored.");
//
//         	model.addAttribute("unauthorizedMessage", "Unauthorized field was ignored.");
//        }
        
        return "initbinder/changeEmailSuccess";  // 결과 페이지로 이동
    }
}
