package com.vega.springit.controllers;

import com.vega.springit.repository.LinkRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LinkController {

    private LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("links",linkRepository.findAll());
        return "link/list";

    }
}
