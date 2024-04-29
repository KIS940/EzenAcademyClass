package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.LoginForm;
import com.teamproject.gaxga.entity.Login;
import com.teamproject.gaxga.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginPage(){
        return "accountManagement/login";
    }

//    @PostMapping("/login")
//    public String postLoginForm(LoginForm loginForm, Model model){
//        return "";
//    }
}
