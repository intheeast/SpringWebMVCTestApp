package com.intheeast.controller.initbinder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tests")
public class GetInitBinderTestPageController {     
	
	@GetMapping("/initbinder")
    public String getTestInitBinder() {
        System.out.println("getTestInitBinder");
        return "initbinder/form"; // JSP 파일 반환
    }
	
	@RequestMapping("/initbinderonlyfields")
    public String getTestInitBinderOnlyFields() {
        return "initbinder/changeEmailForm"; 
    }
	
	@RequestMapping("/initbinderwithcb")
    public String getTestInitBinderWithContructorBinding() {
        return "initbinder/changeEmailFormWithCB"; 
    }
}
