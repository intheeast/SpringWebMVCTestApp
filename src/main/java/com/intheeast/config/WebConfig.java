package com.intheeast.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import static org.springframework.web.servlet.function.RouterFunctions.route; // 정적 임포트

import com.intheeast.handlerfn.PersonFormHandler;
import com.intheeast.handlerfn.PersonHandler;


@Configuration
@EnableWebMvc  // 웹 관련 설정 활성화
@ComponentScan(basePackages = {"com.intheeast.controller", "com.intheeast.handlerfn"})  // 컨트롤러 스캔
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }  
    
    @Bean
    public RouterFunction<ServerResponse> personRoutes(PersonHandler handler) {
        return route()
                .GET("/person/{id}", handler::getPerson)
                .GET("/people", handler::listPeople)
                .POST("/person", handler::createPerson)
                .build();
    }
    
    @Bean
    public RouterFunction<ServerResponse> routerFunction(
    		PersonFormHandler personFormHandler) {
        return route()
                .GET("/person-form", personFormHandler::renderPersonForm) // JSP 페이지를 렌더링
                .build();
    }    
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("extras/home");  // 빈 경로 매핑
        registry.addViewController("/about").setViewName("extras/about");  // "/about" 경로 매핑
        registry.addViewController("/pets").setViewName("pet/addpet");
    }

    // 추가적인 설정: Default Servlet Handler
    @Override
    public void configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer configurer) {
        configurer.enable();  // 기본 서블릿 핸들링 활성화
    }
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // JSON 메시지 컨버터 추가
        converters.add(new MappingJackson2HttpMessageConverter());
        
        converters.add(new ResourceHttpMessageConverter());        

    }
}