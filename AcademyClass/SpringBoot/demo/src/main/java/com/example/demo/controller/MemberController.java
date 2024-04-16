//package com.example.demo.controller;
//
//import com.example.demo.Repository.MemberRepository;
//import com.example.demo.dto.MemberForm;
//import com.example.demo.entity.Member;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class MemberController {
//
//    @Autowired
//    private MemberRepository memberRepository;
//    @GetMapping("/signup")
//    private String newSignupForm(){
//        return "members/new";
//    }
//
//    @PostMapping("/join")
//    private String createSignupForm(MemberForm memberForm){
//        Member member = memberForm.toEntity();
//        Member saved = memberRepository.save(member);
//        return "";
//    }
//
//    @GetMapping("/members/{id}")
//    public String show(@PathVariable Long id, Model model)
//    {
//        Member member = memberRepository.findById(id).orElse(null);
//        model.addAttribute("member",member);
//        return "members/show";
//    }
//
//    @GetMapping("/members")
//    public String index(Model model){
//        Iterable<Member> members = memberRepository.findAll();
//        model.addAttribute("members", members);
//        return "members/index";
//    }
//}
