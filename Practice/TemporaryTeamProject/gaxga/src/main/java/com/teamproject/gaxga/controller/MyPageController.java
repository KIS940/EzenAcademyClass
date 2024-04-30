package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.service.JoinMembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {

    @Autowired
    JoinMembershipService joinMembershipService;

    @GetMapping("/myPage")
    public String showMyPage(Model model){
//        JoinMembershipForm userInfo = joinMembershipService.findUserInfo();
//        model.addAttribute("userInfo", userInfo);
        return "accountManagement/myPage";
    }
}
