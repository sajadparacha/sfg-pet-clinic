package com.spring5.sfgpetclinic.controllers;

import com.spring5.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("vets")
@Controller
public class VetsController {
    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vet/index.html","vetList","showVets"})
    public String showVetList(Model model){
        model.addAttribute("vets",vetService.findAll());
        return "/vet/index.html";

    }
}
