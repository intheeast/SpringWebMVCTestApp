package com.intheeast.controller.annotatedcontrollers;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServletController {

    @PostMapping("/servlet")
    public String handleServletRequest(ServletRequest request, HttpServletResponse response) {
        String remoteAddr = request.getRemoteAddr();
        return "Remote address: " + remoteAddr;
    }
}