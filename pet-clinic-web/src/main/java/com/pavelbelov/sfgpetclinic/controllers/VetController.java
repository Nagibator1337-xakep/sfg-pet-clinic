package com.pavelbelov.sfgpetclinic.controllers;

import com.pavelbelov.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pavel Belov on 05.09.2021
 */
@RequestMapping("/vets")
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listVets(Model model) {
        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }

}
