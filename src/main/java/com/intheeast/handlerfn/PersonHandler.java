package com.intheeast.handlerfn;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import com.intheeast.model.Person;

import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonHandler {

    private final List<Person> people = new ArrayList<>();

    public ServerResponse listPeople(ServerRequest request) {
        return ServerResponse.ok().
        		contentType(MediaType.APPLICATION_JSON).body(people);
    }

    public ServerResponse createPerson(ServerRequest request) 
    		throws ServletException, IOException {
        Person person = request.body(Person.class);
        people.add(person);
        return ServerResponse.ok().body("Person created successfully!");
    }

    public ServerResponse getPerson(ServerRequest request) {
        String personId = request.pathVariable("id");
        return people.stream()
                .filter(p -> p.getId().equals(personId))
                .findFirst()
                .map(person -> ServerResponse.ok()
                		.contentType(MediaType.APPLICATION_JSON).body(person))
                .orElse(ServerResponse.notFound().build());
    }
}