package com.intheeast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable String id) {
        return "User ID: " + id;
    }
}