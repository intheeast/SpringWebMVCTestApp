package com.intheeast.controller.annotatedcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class GetPetController {
	
	@GetMapping
    public String getPet() {
        System.out.println("getPet");
        return "pet/addpet"; // JSP 파일 반환
    }
	
	@GetMapping("/test-pet")
    public String getTestPet() {
        System.out.println("getTestPet");
        return "pet/testPet"; // JSP 파일 반환
    }
	
	@GetMapping("/test-headreq")
    public String getTestHeadRequest() {
        System.out.println("getTestHeadRequest");
        return "pet/headRequest"; // JSP 파일 반환
    }
	
	@GetMapping("/test-optionsreq")
    public String getTestOptionsRequest() {
        System.out.println("getTestOptionsRequest");
        return "pet/optionsRequest"; // JSP 파일 반환
    }
	
//	@GetMapping(path = "/{petId}", headers = "myHeader=myValue")
//    public ResponseEntity<String> findPet(@PathVariable String petId, 
//    		@RequestHeader("myHeader") String myHeaderValue) {
//        // petId와 myHeader의 값을 확인하는 로직
//        System.out.println("Received Pet ID: " + petId);
//        System.out.println("Received Header myHeader: " + myHeaderValue);
//
//        // 여기서 petId로 데이터베이스에서 Pet 객체를 찾을 수 있음 (샘플 코드에서는 생략)
//        // 임의로 Pet 정보를 반환
//        String petInfo = "Pet ID: " + petId + ", Pet Name: Example Pet";
//
//        // 응답으로 Pet 정보를 반환
//        return ResponseEntity.ok(petInfo);
//    }

}
