package com.teamproject.gaxga.service;

import com.teamproject.gaxga.dto.CmtDto;
import com.teamproject.gaxga.dto.GabowatdagoForm;
import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.repository.GabowatdagoRepository;
import com.teamproject.gaxga.repository.gabojago.GrRepository;
import com.teamproject.gaxga.repository.gabojago.GtRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class GabowatdagoService {
    @Autowired
    private GabowatdagoRepository gabowatdagoRepository;
    @Autowired
    private CmtService cmtService;
    @Autowired
    private GrRepository grRepository;
    @Autowired
    private GtRepository gtRepository;

    public String newForm(Model model){
        List<String> locList = grRepository.findAllNames();
        List<String> themaList = gtRepository.findAllNames();
        model.addAttribute("locList", locList);
        model.addAttribute("themaList", themaList);
        return "private/gabowatdago/gabowatdagoing_p";
    }

    @Transactional
    public String create(GabowatdagoForm form) {
        //1. DTO를 엔티티로
        Gabowatdago gabowatdago = form.toEntity();
        //2. 레퍼지토리로 엔티티를 DB에 저장
        Gabowatdago saved = gabowatdagoRepository.save(gabowatdago);
        return "redirect:/gabowatdago/" + saved.getId();
    }

    public String show(Long id, Model model) {
        //1. id를 조회해 데이터 가져오기
        Gabowatdago gabowatdagoEntity = gabowatdagoRepository.findById(id).orElse(null);
        List<CmtDto> cmtDtos = cmtService.comments(id);
        //2. 가져온 데이터를 모델에 등록하기
        model.addAttribute("gabowatdago", gabowatdagoEntity);
        model.addAttribute("cmtDtos", cmtDtos);
        //3. 조회한 데이터를 사용자에게 보여주기 위한 뷰 페이지 만들고 반환하기
        return "private/gabowatdago/gabowatdagoing";
    }

    public String index(Model model){
        //1. 모든 데이터 가져오기
        List<Gabowatdago> gabowatdagoEntityList = gabowatdagoRepository.findAll();
        //2. 모델에 데이터 등록하기
        model.addAttribute("gabowatdagoList", gabowatdagoEntityList);
        //3. 뷰 페이지 등록하기
        return "private/gabowatdago/gabowatdago";
    }
    public String edit(@PathVariable("id") Long id, Model model){
        //수정할 데이터 가져오기
        Gabowatdago gabowatdagoEntity = gabowatdagoRepository.findById(id).orElse(null);
        //모델에 데이터 등록하기
        model.addAttribute("gabowatdago", gabowatdagoEntity);
        //뷰 페이지 설정하기
        return "private/gabowatdago/gabowatdago_edit";
    }

    @Transactional
    public String update(GabowatdagoForm form){
        //1. dto를 엔티티로 변환하기
        Gabowatdago gabowatdagoEntity = form.toEntity();
        //2. 엔티티 db 저장하기
        //2-1 . db에서 기존 데이터 가져오기
        Gabowatdago target = gabowatdagoRepository.findById(gabowatdagoEntity.getId()).orElse(null);
        //2-2 . 기존 데이터 값 갱신하기
        if(target != null){
            gabowatdagoRepository.save(gabowatdagoEntity); //엔티티를 db에 저장(갱신)
        }
        //3. 수정 결과 페이지로 리다이렉트하기
        return "redirect:/gabowatdago/"+gabowatdagoEntity.getId();
    }
    @Transactional
    public String delete(@PathVariable("id") Long id){
        //1. 삭제 대상 가져오기
        Gabowatdago target = gabowatdagoRepository.findById(id).orElse(null);
        //2. 대상 엔티티 삭제하기
        if(target != null){
            gabowatdagoRepository.delete(target);
        }
        return "redirect:/gabowatdago";
    }

}