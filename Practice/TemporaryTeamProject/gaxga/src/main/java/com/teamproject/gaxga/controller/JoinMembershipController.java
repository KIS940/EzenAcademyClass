package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.service.JoinMembershipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        if(joinMembershipForm.getGaP_Image() == null)
        {
            User user = new User();
            user.setGaP_Image("/img/profile.png");

        }
        boolean success = joinMembershipService.joinPutData(joinMembershipForm);
        if(success){
            return "redirect:/login";

        } else {
            log.info("회원가입 성공 여부 : " + success);
            model.addAttribute("error", "중복된 아이디가 있습니다. 다른 아이디를 입력해주세요.");
            return "redirect:/joinMembership";
        }

    }
}
