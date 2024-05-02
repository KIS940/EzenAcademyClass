package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/myPage")
public class MyPageApiController {

    @PutMapping("/api/myPage")
    public String updateUserInfo(@RequestBody JoinMembershipForm form){

        return "";
    }
}