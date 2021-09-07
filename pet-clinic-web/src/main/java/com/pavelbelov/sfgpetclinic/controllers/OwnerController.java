package com.pavelbelov.sfgpetclinic.controllers;

import com.pavelbelov.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pavel Belov on 05.09.2021
 */
@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(Model model) {

        model.addAttribute("owners",ownerService.findAll());

        return "owners/index";
    }

}
