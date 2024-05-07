package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.service.JoinMembershipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class JoinMembershipController {
    @Autowired
    private JoinMembershipService joinMembershipService;



    @GetMapping("/joinMembership")
    public String showJoinMembership(){
        return "public/accountManagement/joinMembership";
    }

    @PostMapping("/joinMembership")
    @ResponseBody
    public String createJoinMembership(@RequestBody JoinMembershipForm joinMembershipForm, Model model){
        log.info("======joinMembershipForm=11{}", joinMembershipForm);
        if(joinMembershipForm.getGaP_Image() == null)
        {
            User user = new User();
            user.setGaP_Image("/img/profile.png");
        }
        boolean success = joinMembershipService.joinPutData(joinMembershipForm);
        log.info(success ? "success" : "fail");
        if(success){
            return "redirect:/login";

        } else {
            log.info("회원가입 성공 여부 : " + success);
            model.addAttribute("error", "중복된 아이디가 있습니다. 다른 아이디를 입력해주세요.");
            return "redirect:/joinMembership";
        }
    }

    @GetMapping("/joinMembership/checkId")
    @ResponseBody
    public boolean checkIdDuplication(@RequestParam("userId") String userId) {
        log.info("======checkIdDuplication={}", userId);
        return joinMembershipService.checkId(userId);
    }
}