package com.intheeast.controller.annotatedcontrollers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController {

	// "/requestparam?name=" + encodeURIComponent(name)
    @GetMapping("/requestparam")
    public String handleRequestParam(@RequestParam(value = "name", required = true) String name) {
        return "Hello, " + name + "!";
    }
    
    // "/search?type=...&type=...&type=..."
    @GetMapping("/search")
    public List<String> searchPets(@RequestParam("type") String[] types) {
        // 요청된 type 배열을 리스트로 변환하여 반환
        return Arrays.asList(types);
    }
    
    @PostMapping(path = "/process", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Map<String, String> processForm(@RequestParam MultiValueMap<String, String> params) {
        Map<String, String> response = new HashMap<>();

        for (String key : params.keySet()) {
            response.put(key, String.join(", ", params.get(key)));
        }

        return response; // JSON 형식으로 반환
    }
}