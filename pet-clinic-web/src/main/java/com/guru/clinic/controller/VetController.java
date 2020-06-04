package com.guru.clinic.controller;

import com.guru.clinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"vets", "index/vets", "index/vets.html"})
    public String vetsIndex(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
