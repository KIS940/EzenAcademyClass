package com.teamproject.gaxga.controller.gabojago;

import com.teamproject.gaxga.entity.gabojago.GP;
import com.teamproject.gaxga.repository.gabojago.GpRepository;
import com.teamproject.gaxga.repository.gabojago.GrRepository;
import com.teamproject.gaxga.repository.gabojago.GtRepository;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@ToString
@Slf4j
@Controller
public class GabojagoController {

    @Autowired
    private GrRepository grRepository;

    @Autowired
    private GtRepository gtRepository;

    @Autowired
    private GpRepository gpRepository;

    @GetMapping("/gabojago")
    public String loc(Model model){
        List<String> location = grRepository.findAllNames();
        List<String> thema = gtRepository.findAllNames();
        List<String> AllArea = gpRepository.findAllNames();
        List<String> Gangwon = gpRepository.findAllNamesByGangwon();
        List<String> Gyeonggi = gpRepository.findAllNamesByGyeonggi();
        List<String> Gyeongnam = gpRepository.findAllNamesByGyeongnam();
        List<String> Gyeongbuk = gpRepository.findAllNamesByGyeongbuk();
        List<String> Gwangju = gpRepository.findAllNamesByGwangju();
        List<String> Daegu = gpRepository.findAllNamesByDaegu();
        List<String> Daejeon = gpRepository.findAllNamesByDaejeon();
        List<String> Busan = gpRepository.findAllNamesByBusan();
        List<String> Seoul = gpRepository.findAllNamesBySeoul();
        List<String> Sejong = gpRepository.findAllNamesBySejong();
        List<String> Ulsan = gpRepository.findAllNamesByUlsan();
        List<String> Incheon = gpRepository.findAllNamesByIncheon();
        List<String> Jeonnam = gpRepository.findAllNamesByJeonnam();
        List<String> Jeonbuk = gpRepository.findAllNamesByJeonbuk();
        List<String> Jeju = gpRepository.findAllNamesByJeju();
        List<String> Chungnam = gpRepository.findAllNamesByChungnam();
        List<String> Chungbuk = gpRepository.findAllNamesByChungbuk();
        model.addAttribute("locations", location);
        model.addAttribute("themas", thema);
        model.addAttribute("AllArea", AllArea);
        model.addAttribute("Gangwon", Gangwon);
        model.addAttribute("Gyeonggi", Gyeonggi);
        model.addAttribute("Gyeongnam", Gyeongnam);
        model.addAttribute("Gyeongbuk", Gyeongbuk);
        model.addAttribute("Gwangju", Gwangju);
        model.addAttribute("Daegu", Daegu);
        model.addAttribute("Daejeon", Daejeon);
        model.addAttribute("Busan", Busan);
        model.addAttribute("Seoul", Seoul);
        model.addAttribute("Sejong", Sejong);
        model.addAttribute("Ulsan", Ulsan);
        model.addAttribute("Incheon", Incheon);
        model.addAttribute("Jeonnam", Jeonnam);
        model.addAttribute("Jeonbuk", Jeonbuk);
        model.addAttribute("Jeju", Jeju);
        model.addAttribute("Chungnam", Chungnam);
        model.addAttribute("Chungbuk", Chungbuk);
        return "public/gabojago/gabojago";
    }
}




