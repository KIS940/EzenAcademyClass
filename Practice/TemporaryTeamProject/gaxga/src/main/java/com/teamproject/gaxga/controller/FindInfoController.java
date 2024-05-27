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


    @PostMapping("/findInfo/ID")
    @ResponseBody
    public String findId(@RequestBody User user){

        return "public/accountManagement/findInfo";
    }
}