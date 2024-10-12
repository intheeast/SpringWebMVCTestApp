package com.intheeast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.intheeast.model.User;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
public class SessionAttributeController {

    // 세션에 값 추가
    @GetMapping("/add")
    public String addToSession(HttpSession session) {
        User user = new User("John Doe");
        session.setAttribute("user", user);  // 세션에 "user" 저장
        return "User added to session.";
    }

    // 세션에서 값 가져오기
    @GetMapping("/get")
    public String getSessionValue(@SessionAttribute("user") User user) {
        return "User from session: " + user.getName();
    }

    // 세션에서 값 삭제
    @GetMapping("/remove")
    public String removeFromSession(HttpSession session) {
        session.removeAttribute("user");  // 세션에서 "user" 삭제
        return "User removed from session.";
    }
}