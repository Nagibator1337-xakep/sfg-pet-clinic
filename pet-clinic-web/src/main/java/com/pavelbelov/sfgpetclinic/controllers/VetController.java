package com.pavelbelov.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pavel Belov on 05.09.2021
 */
@RequestMapping("/vets")
@Controller
public class VetController {

    @RequestMapping({"","/","/index","/index.html"})
    public String listVets() {

        return "vets/index";
    }

}
