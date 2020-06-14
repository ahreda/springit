package com.vega.springit.domain;

import lombok.*;

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
@RequiredArgsConstructor
@Getter @Setter
@ToString

public class Link extends Auditable {
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

   public void addComment(Comment comment){

       comments.add(comment);
   }



}



