package com.intheeast.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.intheeast.model.Client;

public class ClientFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Client client = new Client(1L, "John Doe");  // 가상의 Client 객체 생성
        httpRequest.setAttribute("client", client);  // 요청 속성에 Client 객체 저장

        chain.doFilter(request, response);  // 필터 체인 실행
    }

    @Override
    public void destroy() {}
}