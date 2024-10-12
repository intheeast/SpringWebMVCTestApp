package com.intheeast.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.intheeast.model.Pet;

@RestController
@RequestMapping("/pets")
public class PetController {
	private List<Pet> pets = Arrays.asList(
	        new Pet("1", "Max", "Dog", 5),
	        new Pet("2", "Bella", "Cat", 3),
	        new Pet("3", "Charlie", "Bird", 2)
	    );
	
//	@PostMapping(consumes = "application/json")
//    public ResponseEntity<Void> addPet(@RequestBody Pet pet) {
//        // Pet 객체 처리 로직 (예: 데이터베이스 저장 등)
//        System.out.println("Received Pet: " + pet);
//
//        // 리다이렉트 처리
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Location", "/");
//        return new ResponseEntity<>(headers, HttpStatus.FOUND);  // 302 리다이렉트
//    }
	
	@PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        // 데이터베이스 저장 등의 로직이 들어갈 수 있음
        System.out.println("Received Pet: " + pet);

        // 저장 후, 해당 pet 객체를 다시 반환
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
	
	// For HEAD Test
	@GetMapping("/{petId}")
    public Pet getPet(@PathVariable String petId) {
        // Pet 객체를 찾음
        return pets.stream()
                   .filter(pet -> pet.getPetId().equals(petId))
                   .findFirst()
                   .orElseThrow(() -> new RuntimeException("Pet not found with id: " + petId));
    }
}