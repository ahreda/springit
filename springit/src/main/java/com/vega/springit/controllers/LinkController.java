package com.vega.springit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LinkController {

    @GetMapping("/foo")
    public String home(Model model) {
        model.addAttribute("title","Hello, Thymeleaf!");
        return "foo";
    }
}