package com.intheeast.handlerfn;

import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.stereotype.Component;

import static org.springframework.web.servlet.function.ServerResponse.ok;

@Component
public class PersonFormHandler {

    // JSP 페이지를 렌더링하는 핸들러
    public ServerResponse renderPersonForm(ServerRequest request) {
        return ok().render("handlerfn/person"); // "person.jsp"를 렌더링
    }
}