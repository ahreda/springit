package com.vega.springit.repository;

import com.vega.springit.domain.Link;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LinkRepository extends PagingAndSortingRepository<Link, Long> {

}
