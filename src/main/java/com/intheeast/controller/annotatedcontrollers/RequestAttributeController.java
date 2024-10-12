package com.intheeast.controller.annotatedcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.intheeast.model.Client;

@RestController
public class RequestAttributeController {

    @GetMapping("/client")
    public String handle(@RequestAttribute(value = "client", required = false) Client client) {
        if (client == null) {
            return "Error: Client attribute is missing";  // 요청에 client 속성이 없으면 에러 메시지 반환
        }

        // 요청 속성으로 전달된 client 객체의 세부 정보를 문자열로 반환 (JSON 대신 간단한 텍스트 예시)
        return "Client details: " + client.toString();
    }
}
