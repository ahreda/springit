package com.vega.springit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Create a Link Entity with No Arguments constructor and sitter and getter methods using annotations.
 */
@Entity
@NoArgsConstructor
@Data
public class Link {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private String title;
    @NonNull
    private String url;

    /**
     * Associate the Link Entity with Comment Entity with One to Many Relationship. 
     */
    //Comment
    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();
}



