package com.teamproject.gaxga.service;

import com.teamproject.gaxga.dto.CmtDto;
import com.teamproject.gaxga.entity.Cmt;
import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.repository.CmtRepository;
import com.teamproject.gaxga.repository.GabowatdagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CmtService {
    @Autowired
    private CmtRepository cmtRepository;
    @Autowired
    private GabowatdagoRepository GabowatdagoRepository;


    public List<CmtDto> comments(Long gabowatdagoId) {
        //댓글 조회
        List<Cmt> cmts = cmtRepository.findByGabowatdagoId(gabowatdagoId);
        //엔티티 -> dto 변환
        //빈 ArrayList 만들기
        List<CmtDto> dtos = new ArrayList<CmtDto>();
        for(int i=0; i<cmts.size(); i++){ //조회한 엔티티 댓글 수 만큼 반복
            Cmt cmt = cmts.get(i); // 조회한 댓글 엔티티 하나씩 가져와서
            CmtDto dto = CmtDto.createCommentDto(cmt); //엔티티를 dto로 변환
            dtos.add(dto); //변환한 dto를 dtos 리스트 변수에 삽입
        }
        //결과 반환
        return dtos;
    }

    @Transactional
    public CmtDto create(Long gabowatdagoId, CmtDto cmtDto) {
        //게시글 조회 및 예외 발생
        Gabowatdago gabowatdago = GabowatdagoRepository.findById(gabowatdagoId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패"+ "대상 게시글이 없습니다."));
        // 댓글 엔티티 생성
        Cmt cmt = Cmt.createComment(cmtDto, gabowatdago);
        // 댓글 엔티티를 db에 저장
        Cmt created = cmtRepository.save(cmt);
        // DTO로 변환해 반환
        return CmtDto.createCommentDto(created);

    }
    @Transactional
    public CmtDto update(Long id, CmtDto cmtDto) {
        //댓글 조회 및 예외 발생
        Cmt target = cmtRepository.findById(id) // 수정할 댓글 가져오기
                .orElseThrow(()->new IllegalArgumentException("댓글 수정 실패, 해당 댓글이 없습니다."));
        // 댓글 수정
        target.patch(cmtDto);
        // db로 갱신
        Cmt updated = cmtRepository.save(target);
        // 댓글 엔티티를 dto로 변환해 반환
        return CmtDto.createCommentDto(updated);
    }

    public CmtDto delete(Long id) {
        //댓글 조회 및 예외 발생
        Cmt target = cmtRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("댓글 삭제 실패, 해당 댓글이 없습니다."));
        //댓글 삭제
        cmtRepository.delete(target);
        //삭제 댓글을 dto로 변환 및 반환
        return CmtDto.createCommentDto(target);
    }
}
