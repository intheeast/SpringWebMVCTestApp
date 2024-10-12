package com.intheeast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class WebRequestController {

	// var url = "/webrequest?paramName=" + encodeURIComponent(paramValue);
    @GetMapping("/webrequest")
    public String handleWebRequest(WebRequest request) {
        String paramValue = request.getParameter("paramName");
        return "Received parameter: " + paramValue;
    }
}