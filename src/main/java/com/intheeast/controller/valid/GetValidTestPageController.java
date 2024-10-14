package com.intheeast.controller.valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tests")
public class GetValidTestPageController {
	
	@GetMapping("/valid")
    public String getTestValid() {
        System.out.println("getTestValid");
        return "valid/accountForm"; // JSP 파일 반환
    }
	
	@GetMapping("/validwithjson")
    public String getTestValidWithJSON() {
        System.out.println("getTestValidWithJSON");
        return "valid/accountFormWithJSON"; // JSP 파일 반환
    }

}
