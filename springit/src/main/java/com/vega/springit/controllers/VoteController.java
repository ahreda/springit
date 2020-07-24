package com.vega.springit.controllers;

import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.domain.Vote;
import com.vega.springit.repository.LinkRepository;
import com.vega.springit.repository.VoteRepository;
import com.vega.springit.services.LinkService;
import com.vega.springit.services.VoteService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VoteController {

    private LinkService linkService;
    private VoteService voteService;

    // http://localhost:8080/vote/link/5/direction/-1/votecounter/5
    @Secured({"ROLE_USER"})
    @GetMapping("/vote/link/{linkId}/direction/{direction}/voteCount/{voteCount}")
    public int vote(@PathVariable Long linkId, @PathVariable Short direction, @PathVariable int voteCount){
       Optional<Link>optionalLink = linkService.findById(linkId);
       if(optionalLink.isPresent()){
           Link link = optionalLink.get();
           Vote vote = new Vote(direction,link);
           voteService.save(vote);

           int updatedVoteCount = voteCount + direction;
           link.setVoteCount(updatedVoteCount);
           linkService.save(link);
           return updatedVoteCount;
       }
    return voteCount;

    }

}
