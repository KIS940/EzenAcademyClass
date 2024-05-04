package com.example.ajaxPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

    @GetMapping("/ex01")
    public String ex01(){
        System.out.println("AjaxController.ex01");
        // return ""; 에러난 이유는 비어있는 .html을 찾으려했기때문
        return "index"; // @ResponseBody가 없을시 index.html에 작성된 내용이 출력됨
    }

    @PostMapping("/ex02")
    //ResponseBody : body는 http프로토콜의 바디
    @ResponseBody
    public String ex02(){
        System.out.println("AjaxController.ex02");
        return "안녕하세요"; // @ResponseBody가 있을시 리턴값이 그대로 출력됨
    }
    
    @GetMapping("/ex03")
    @ResponseBody
    public String ex03(@RequestParam("param1") String param1,
                       @RequestParam("param2") String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        return "ex03메서드 호출 완료";
    }

    @PostMapping("/ex04")
    @ResponseBody
    public String ex04(@RequestParam("param1") String param1,
                       @RequestParam("param2") String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        return "ex04메서드 호출 완료";
    }
}
