package com.vega.springit.controllers;

import com.vega.springit.domain.Link;
import com.vega.springit.repository.LinkRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class NewCont {

    private LinkRepository linkRepository;

    public NewCont(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/lin")
    public List<Link> linkList (){
        Link link1 = linkRepository.findByTitle("Build a Secure Progressive Web App With Spring Boot and React");

        return Arrays.asList(link1);


    }
}
