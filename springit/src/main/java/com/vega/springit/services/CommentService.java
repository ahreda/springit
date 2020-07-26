package com.vega.springit.services;

import com.vega.springit.domain.Comment;
import com.vega.springit.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
