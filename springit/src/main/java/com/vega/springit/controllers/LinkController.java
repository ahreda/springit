package com.vega.springit.controllers;

import com.vega.springit.domain.Link;
import com.vega.springit.repository.LinkRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class LinkController {

    LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


   @GetMapping("/links")
    public Optional<Link> getAllTopics() {
        Optional<Link> myLinks = linkRepository.findById((long) 2);
        return myLinks;

        }


    @PostMapping("/create/{title}")
    public void create(@PathVariable String title){
        Link link = new Link(title,"https://therealdanvega.com/spring-boot-2");
        linkRepository.save(link);


    }

   /* @GetMapping("/{id}")
    public Optional<Link> read(@PathVariable Long id) {
        return linkRepository.findById(id);

    }*/

/*
    @PutMapping("/{id}")
    public Link update(@PathVariable Long id, @ModelAttribute Link link){
        return linkRepository.save(link);
    }*/
  /*  @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        linkRepository.deleteById(id);

    }*/

}
