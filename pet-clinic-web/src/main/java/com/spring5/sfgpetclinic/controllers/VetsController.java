package com.spring5.sfgpetclinic.controllers;

import com.spring5.sfgpetclinic.model.Vet;
import com.spring5.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@RequestMapping("vets")
@Controller
public class VetsController {
    private final VetService vetService;


    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vet/index.html","vetList","showVets","/vets.html"})
    public String showVetList(Model model){
        model.addAttribute("vets",vetService.findAll());
        return "/vet/index.html";

    }
    @GetMapping("api/vets")
    public @ResponseBody   Set<Vet> getVetsAsJSON(){
        return vetService.findAll();
    }
}
