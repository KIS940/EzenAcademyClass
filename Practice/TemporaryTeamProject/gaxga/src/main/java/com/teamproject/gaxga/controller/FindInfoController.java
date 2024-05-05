package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.service.FindInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class FindInfoController {

    @Autowired
    private FindInfoService findInfoService;

    @GetMapping("/findInfo")
    public String showFindInfo() {
        return "public/accountManagement/findInfo";
    }

//    @PostMapping("/findInfo")
//    public String findId(@RequestParam("user_Name") String nick, @RequestParam("userId_PhoneNumber") String phoneNum, Model model) {
//        log.info("=======nick: {}, phoneNum: {}", nick, phoneNum);
//        User user = findInfoService.findUserInfo(nick, phoneNum);
//
//        if (user != null) {
//            log.info("=======찾은 정보 userId: {}", user.getGaId());
//            model.addAttribute("userId","찾은 아이디: " + user.getGaId());
//            return "redirect:/login";
//        } else {
//            log.info("사용자를 찾을 수 없습니다.");
//            model.addAttribute("userId", "사용자를 찾을 수 없음");
//            return "redirect:/findInfo";
//        }
//    }

    @PostMapping("/findInfo/ID")
    @ResponseBody
    public String findId(@RequestBody User user){
        return "public/accountManagement/findInfo";
    }
}