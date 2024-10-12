package com.intheeast.controller.annotatedcontrollers;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    // 세션에 클라이언트에서 받은 username 값을 POST 요청으로 설정하는 엔드포인트
    @PostMapping("/session-set")
    public String setSessionAttribute(@RequestParam("username") String username, 
    		HttpSession session,
    		HttpMethod httpMethod) {
        session.setAttribute("username", username);
        System.out.println("setSessionAttribute: HTTP METHOD : " + httpMethod);
        return "Session attribute set: " + session.getAttribute("username");
    }

    // 세션에서 username 값을 가져오는 엔드포인트
    @GetMapping("/session-get")
    public String getSessionAttribute(HttpSession session, HttpMethod httpMethod) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "No session attribute found for username.";
        }
        
        System.out.println("getSessionAttribute: HTTP METHOD : " + httpMethod);

        return "Session attribute retrieved: " + username;
    }
}