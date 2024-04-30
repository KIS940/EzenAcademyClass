package com.teamproject.gaxga.controller.main;

import com.teamproject.gaxga.entity.UserDetail;
import com.teamproject.gaxga.service.UserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class mainController {

    @Autowired
    UserDetailService userDetailService;

    @GetMapping("main")
    public String main(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal();
        model.addAttribute("userDetail", userDetail);

        return "main/main2";
    }
}
