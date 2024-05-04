//package com.teamproject.gaxga.service;
//
//import com.teamproject.gaxga.dto.LikeDto;
//import com.teamproject.gaxga.entity.Gabowatdago;
//import com.teamproject.gaxga.repository.GabowatdagoRepository;
//import com.teamproject.gaxga.repository.LikeRepository;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class LikeService {
//    private final LikeRepository likeRepository;
//    private final GabowatdagoRepository GabowatdagoRepository;
//    private final GabowatdagoRepository gabowatdagoRepository;
//
//    @Transactional
//    public void insert(LikeDto likeDto) throws Exception {
//        Gabowatdago gabowatdago = gabowatdagoRepository.findById(likeDto.getGabowatdagoId())
//                .orElseThrow(() -> new Exception("Gabowatdago not found: " + likeDto.getGabowatdagoId()));
//        //이미 좋아요 있으면 에러 반환
//        if(likeRepository.findAll(gabowatdago).is)
//    }
//}
