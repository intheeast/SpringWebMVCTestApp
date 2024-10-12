package com.intheeast.controller.annotatedcontrollers;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intheeast.model.Account;

@Controller
@RequestMapping("/accounts")
public class ResponseBodyController {
	
	@GetMapping("/{id}")
    @ResponseBody
    public Account handle() {
        // 가상의 Account 객체 반환
        return new Account("John Doe", "swseokitec@gmail.com");
    }
	
	@GetMapping("/download")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile() throws IOException {
        // 파일을 리소스로 가져오기
        ClassPathResource resource = new ClassPathResource("files/example.txt");

        // 파일이 존재하는지 확인
        if (!resource.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // 파일 다운로드 응답 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=example.txt");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)  // 바이너리 파일 처리
                .body(new InputStreamResource(resource.getInputStream()));
    }

}
