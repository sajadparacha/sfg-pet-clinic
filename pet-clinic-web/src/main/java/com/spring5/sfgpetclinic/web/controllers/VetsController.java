package com.spring5.sfgpetclinic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController {
    @RequestMapping({"/vet/index.html","vetList","showVets"})
    public String showVetList(){
        return "/vet/index.html";

    }
}
