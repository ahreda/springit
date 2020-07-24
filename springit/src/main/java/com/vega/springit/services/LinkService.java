package com.vega.springit.services;

import com.vega.springit.domain.Link;
import com.vega.springit.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService {

    LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Iterable<Link> findAll() {

        return  linkRepository.findAll();
    }

    public Optional findById (Long id){

        return linkRepository.findById(id);
    }

    public  Link save(Link link){

        return linkRepository.save(link);
    }

}
