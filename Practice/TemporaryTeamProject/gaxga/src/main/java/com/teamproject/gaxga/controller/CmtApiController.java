package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.CmtDto;
import com.teamproject.gaxga.entity.Cmt;
import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.service.CmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CmtApiController {
    @Autowired
    private CmtService cmtService;
    //1. 댓글 조회
    @GetMapping("/api/gabowatdago/{gabowatdagoId}/cmts")
    public ResponseEntity<List<CmtDto>> cmts(@PathVariable("gabowatdagoId") Long gabowatdagoId){
        //서비스에 위임
        List<CmtDto> dtos = cmtService.comments(gabowatdagoId);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
    //2. 댓글 생성
    @PostMapping("/api/gabowatdago/{gabowatdagoId}/cmts")
    public ResponseEntity<CmtDto> createCmt(@PathVariable("gabowatdagoId")Long gabowatdagoId,
                                            @RequestBody CmtDto cmtDto){
        //서비스에 위임
        CmtDto createdDto = cmtService.create(gabowatdagoId, cmtDto);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
    //3. 댓글 수정
    @PatchMapping("/api/cmts/{id}")
    public ResponseEntity<CmtDto> updateCmt(@PathVariable("id") Long id, @RequestBody CmtDto cmtDto){
        //서비스 위임
        CmtDto updatedDto = cmtService.update(id, cmtDto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);

    }
    //4. 댓글 삭제
    @DeleteMapping("/api/cmts/{id}")
    public ResponseEntity<CmtDto> deleteCmt(@PathVariable("id") Long id){
        //서비스 위임
        CmtDto deletedDto = cmtService.delete(id);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }



}
