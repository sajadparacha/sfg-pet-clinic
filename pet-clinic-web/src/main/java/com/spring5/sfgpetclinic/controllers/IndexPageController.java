package com.spring5.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageController {
    @RequestMapping({"/","index","index.html",""})
    public String shoeIndexPage(){
        return "index";
    }

    @RequestMapping("oups")
    public String errorPageMotImplemented(){
        return "notimplemented";
    }
}
