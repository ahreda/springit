package com.vega.springit.repository;

import com.vega.springit.domain.Link;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.List;

public interface LinkRepository extends PagingAndSortingRepository<Link, Long> {

    Link findByTitle(String title);



}
