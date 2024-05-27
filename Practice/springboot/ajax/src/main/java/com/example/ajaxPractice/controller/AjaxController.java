package com.example.ajaxPractice.controller;

import com.example.ajaxPractice.dto.AjaxDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/ex05")
    @ResponseBody
    public AjaxDTO ex05(@ModelAttribute AjaxDTO ajaxDTO){
        System.out.println("ajaxDTO : " + ajaxDTO);
        return ajaxDTO;
    }

    @PostMapping("/ex06")
    @ResponseBody
    public AjaxDTO ex06(@ModelAttribute AjaxDTO ajaxDTO){
        System.out.println("ajaxDTO : " + ajaxDTO);
        return ajaxDTO;
    }

    @PostMapping("/ex07")
    @ResponseBody
    public  AjaxDTO ex07(@RequestBody AjaxDTO ajaxDTO){
        System.out.println("ajaxDTO : " + ajaxDTO);
        return ajaxDTO;
    }

    private List<AjaxDTO> DTOList(){
        List<AjaxDTO> dtoList = new ArrayList<>();
        dtoList.add(new AjaxDTO("data1", "data11"));
        dtoList.add(new AjaxDTO("data2", "data22"));
        return dtoList;
    }

    @PostMapping("/ex08")
    @ResponseBody
    public List<AjaxDTO> ex08(@RequestBody AjaxDTO ajaxDTO){
        System.out.println("ajaxDTO : " + ajaxDTO);
        List<AjaxDTO> dtoList = DTOList();
        dtoList.add(ajaxDTO);
        return dtoList;
    }

    @PostMapping("/ex09")
    // ResponseEntity :body정보뿐만 아니라 header,status 메세지도 같이 넘길수있다. @ResponseBody보다 포괄적이라고 보면됨
    public ResponseEntity ex09(@RequestBody AjaxDTO ajaxDTO){
        System.out.println("ajaxDTO : " + ajaxDTO);
        // 클라이언트에 success,error 중 하나로 제어가능
        //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ajaxDTO, HttpStatus.OK);
    }

    @PostMapping("/ex10")
    public ResponseEntity ex10(@RequestBody AjaxDTO ajaxDTO){
        System.out.println("ajaxDTO : " + ajaxDTO);
        List<AjaxDTO> dtoList = DTOList();
        dtoList.add(ajaxDTO);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
