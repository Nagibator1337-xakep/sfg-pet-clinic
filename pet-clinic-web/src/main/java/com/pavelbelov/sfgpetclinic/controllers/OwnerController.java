package com.pavelbelov.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pavel Belov on 05.09.2021
 */
@Controller
public class OwnerController {

    @RequestMapping({"owners","owners/index","owners/index.html"})
    public String listOwners() {

        return "owners/index";
    }

}
