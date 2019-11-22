package com.spring5.sfgpetclinic.controllers;

import com.spring5.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping({"","/","/index","ownerList","showOwners"})
    public String showListOfOwners(Model model){

        model.addAttribute("owners",this.ownerService.findAll());

        return "/owner/index";
    }
    @RequestMapping("/find")
    public String find(){
        return "notimplemented";
    }
}
