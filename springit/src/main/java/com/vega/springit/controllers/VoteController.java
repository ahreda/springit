package com.vega.springit.controllers;

import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.domain.Vote;
import com.vega.springit.repository.LinkRepository;
import com.vega.springit.repository.VoteRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VoteController {

    private LinkRepository linkRepository;
    private VoteRepository voteRepository;

    // http://localhost:8080/vote/link/5/direction/-1/votecounter/5
    @Secured({"ROLE_USER"})
    @GetMapping("/vote/link/{linkId}/direction/{direction}/voteCount/{voteCount}")
    public int vote(@PathVariable Long linkId, @PathVariable Short direction, @PathVariable int voteCount){
       Optional<Link>optionalLink = linkRepository.findById(linkId);
       if(optionalLink.isPresent()){
           Link link = optionalLink.get();
           Vote vote = new Vote(direction,link);
           voteRepository.save(vote);

           int updatedVoteCount = voteCount + direction;
           link.setVoteCount(updatedVoteCount);
           linkRepository.save(link);
           return updatedVoteCount;
       }
    return voteCount;

    }

}
