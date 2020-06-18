package com.vega.springit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LinkController {

    @GetMapping("/foo")
    public String foo(Model model){

        model.addAttribute("pageTitle","This page is foo");
        return "foo";
    }

}
