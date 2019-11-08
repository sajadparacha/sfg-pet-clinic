package com.spring5.sfgpetclinic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("owners")
@Controller
public class OwnerController {
    @RequestMapping({"","/","/index","ownerList","showOwners"})
    public String showListOfOwners(){
        return "/owner/index";
    }
}
