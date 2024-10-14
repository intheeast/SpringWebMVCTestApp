package com.intheeast.controller.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tests")
public class GetModelTestPageController {	
	
	@GetMapping("/usingmodelAttributeonmethodparameter")
    public String getTestUsingModelAttributeOnMethodParameter() {
        System.out.println("getTestUsingModelAttributeOnMethodParameter");
        return "model/accountForm"; // JSP 파일 반환
    }
	
	@GetMapping("/addreturnvalueasmodelproperty")
    public String getTestAddReturnValueAsModel() {
        System.out.println("getTestAddReturnValueAsModel");
        return "model/accountFormOnlyName"; // JSP 파일 반환
    }
}
