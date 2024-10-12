package com.intheeast.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestHeaderController {

//    @GetMapping("/requestheader")
//    public String handleRequestHeader(@RequestHeader("User-Agent") String userAgent) {
//        return "User-Agent: " + userAgent;
//    }
    
    @GetMapping("/requestheader")
    public String handleRequestHeader(@RequestHeader Map<String, String> headers) {
        StringBuilder result = new StringBuilder("Request Headers: <br>");
        
        headers.forEach((key, value) -> {
            result.append(key).append(": ").append(value).append("<br>");
        });

        return result.toString();
    }
    
    @GetMapping("/demo")
    public void handle(
            @RequestHeader("Accept-Encoding") String encoding, 
            @RequestHeader(name = "Keep-Alive", required = false) String keepAlive,
            @CookieValue("JSESSIONID") String cookie) {
        System.out.println("Accept-Encoding: " + encoding);
        System.out.println("Keep-Alive: " + keepAlive);
        System.out.println("JSESSIONID: " + cookie);
    }
}