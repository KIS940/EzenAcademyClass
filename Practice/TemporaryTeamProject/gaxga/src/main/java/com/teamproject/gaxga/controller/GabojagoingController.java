package com.teamproject.gaxga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GabojagoingController {
    @GetMapping("/gabojagoing")
    public String Gabojagoing(){
        return "gabojagoing/gabojagoing";
    }
}
