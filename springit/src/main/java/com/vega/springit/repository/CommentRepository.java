package com.vega.springit.repository;

import com.vega.springit.domain.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    Comment findByBody(String body);

}
