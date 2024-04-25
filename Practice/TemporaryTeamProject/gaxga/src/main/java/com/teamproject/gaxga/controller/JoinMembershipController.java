package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.repository.UserRepository;
import com.teamproject.gaxga.service.JoinMembershipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class JoinMembershipController {
    @Autowired
    private JoinMembershipService joinMembershipService;

    @GetMapping("/joinMembership")
    public String showJoinMembership(){
        return "accountManagement/joinMembership";
    }

    @PostMapping("/joinMembership/create")
    public String createJoinMembership(JoinMembershipForm joinMembershipForm, Model model){
        log.info("======joinMembershipForm={}", joinMembershipForm);
        joinMembershipService.joinPutData(joinMembershipForm);
        return "redirect:accountManagement/login";
    }

    @GetMapping("/joinMembership/create/result")
    public String resultCreate(@PathVariable Long id, Model model){
        log.info("==========id: " + id);
        log.info("==========model: " + model.toString());

        return "";
    }
}
