package com.intheeast.controller.annotatedcontrollers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intheeast.model.Pet;

import jakarta.validation.Valid;

@RestController
public class ModelAttributeController {
	
	@PostMapping("/owners/{ownerId}/pets/{petId}/edit")
    public Pet processSubmit(@Valid @RequestBody Pet pet) {
        // 서버에 출력할 데이터
        System.out.println("Pet Name: " + pet.getName());
        System.out.println("Pet Age: " + pet.getAge());
        System.out.println("Pet Type: " + pet.getType());

        // 요청한 Pet 객체를 그대로 반환
        return pet;
    }

}
