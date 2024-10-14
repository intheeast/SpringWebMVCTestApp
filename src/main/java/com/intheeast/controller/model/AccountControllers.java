package com.intheeast.controller.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intheeast.model.Account;

@Controller
@RequestMapping("/model")
public class AccountControllers {

    @PostMapping("/accounts")
    public String handleAccount(@ModelAttribute Account account, Model model) {
        // 요청에서 전달된 폼 데이터를 Account 객체로 바인딩
    	
        System.out.println("Account Name: " + account.getName());
        System.out.println("Account Email: " + account.getEmail());
        return "model/accountView";
    }
    
    @GetMapping("/accounts/{name}")
    @ModelAttribute("myAccount")
    public Account getAccount(@PathVariable("name") String name) {
        // 요청된 name를 통해 Account 객체를 생성하여 반환
        Account account = new Account(name, "swseokitec@gmail.com");
        return account;
    }    
}