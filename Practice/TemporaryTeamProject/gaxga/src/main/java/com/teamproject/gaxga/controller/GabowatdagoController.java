package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.GabowatdagoForm;
import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.repository.GabowatdagoRepository;
import com.teamproject.gaxga.service.GabowatdagoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class GabowatdagoController {
    @Autowired
    private GabowatdagoRepository gabowatdagoRepository;
    @Autowired
    private GabowatdagoService gabowatdagoService;
    @GetMapping("/gabowatdagoing_p")
    public String newForm(){
        return "/gabowatdago/gabowatdagoing_p";
    }

    @PostMapping("/gabowatdago/create")
    public String create(GabowatdagoForm form) {
        return gabowatdagoService.create(form);
    }

    @GetMapping("/gabowatdago/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        return gabowatdagoService.show(id, model);
    }

    @GetMapping("/gabowatdago")
    public String index(Model model){
        return gabowatdagoService.index(model);
    }

    @GetMapping("/gabowatdago/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        return gabowatdagoService.edit(id, model);
    }

    @PostMapping("/gabowatdago/update")
    public String update(GabowatdagoForm form){
        return gabowatdagoService.update(form);
    }

    @GetMapping("gabowatdago/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        return gabowatdagoService.delete(id);
    }


}
