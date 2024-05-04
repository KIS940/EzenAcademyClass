//package com.teamproject.gaxga.controller;
//
//import com.teamproject.gaxga.dto.LikeDto;
//import com.teamproject.gaxga.service.LikeService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/gobowatdago/like")
//public class LikeController {
//    private final LikeService likeService;
//
//    @PostMapping
//    public ResponseEntity<?> insertLike(@RequestBody LikeDto likeDto) {
//        likeService.insert(likeDto);
//        return success(null);
//    }
//
//    @DeleteMapping
//    public ResponseEntity<?> deleteLike(@RequestBody LikeDto likeDto) {
//        likeService.delete(likeDto);
//        return success(null);
//    }
//}
