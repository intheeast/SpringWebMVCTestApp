package com.intheeast.controller.annotatedcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tests")
public class GetAnnotatedHandlerMethodTestPageController {
	
	@GetMapping("/requestparam")
    public String getTestRequestParam() {
        System.out.println("getTestRequestParam");
        return "handlermethod/requestparamTest"; // JSP 파일 반환
    }
	
	@GetMapping("/webrequest")
    public String getTestWebRequest() {
        System.out.println("getTestWebRequest");
        return "handlermethod/webRequestTest"; // JSP 파일 반환
    }
	
	@GetMapping("/servlet")
    public String getTestServlet() {
        System.out.println("getTestServlet");
        return "handlermethod/servletTest"; // JSP 파일 반환
    }
	
	@GetMapping("/session")
    public String getTestSession() {
        System.out.println("getTestServlet");
        return "handlermethod/sessionTest"; // JSP 파일 반환
    }
	
	@GetMapping("/pathvariable")
    public String getTestPathVariable() {
        System.out.println("getTestPathVariable");
        return "handlermethod/pathvariableTest"; // JSP 파일 반환
    }
	
	
	
	@GetMapping("/requestheader")
    public String getTestRequestHeader() {
        System.out.println("getTestRequestHeader");
        return "handlermethod/requestheaderTest"; // JSP 파일 반환
    }
	
	@GetMapping("/modelattr")
    public String getTestModelAttribute() {
        System.out.println("getTestModelAttribute");
        return "handlermethod/modelAttributeTest"; // JSP 파일 반환
    }
	
	//sessionattributesTest
	@GetMapping("/sessionattributes")
    public String getTestSessionAttributes() {
        System.out.println("getTestModelAttribute");
        return "handlermethod/newPetForm"; // JSP 파일 반환
    }
	
	@GetMapping("/sessionattribute")
    public String getTestSessionAttribute() {
        System.out.println("getTestSessionAttribute");
        return "handlermethod/sessionattributeTest"; // JSP 파일 반환
    }
	
	@GetMapping("/redirectattributes")
    public String getTestRedirectAttributes() {
        System.out.println("getTestRedirectAttributes");
        return "handlermethod/redirectattributesTest"; // JSP 파일 반환
    }
	
	
	@GetMapping("/requestattribute")
    public String getTestRequestAttribute() {
        System.out.println("getTestRequestAttribute");
        return "handlermethod/requestattributeTest"; // JSP 파일 반환
    }
	
	
	@GetMapping("/requestbody")
    public String getTestRequestBody() {
        System.out.println("getTestRequestBody");
        return "handlermethod/requestbodyTest"; // JSP 파일 반환
    }
	
	@GetMapping("/responsebody")
    public String getTestResponseBody() {
        System.out.println("getTestResponseBody");
        return "handlermethod/responsebodyTest"; // JSP 파일 반환
    }
}
