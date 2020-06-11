package com.vega.springit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 *Create a Comment Entity , NoArgument constructor and getter and sitter methods using annotations.
 */
@Entity
@NoArgsConstructor
@Data
public class Comment extends Auditable {
    @Id
    @GeneratedValue
    private long id;
    private String body;

    /**
     * Associate the Comment Entity with the Link Entity, with Many to one relationship.
     */
    //Link
    @ManyToOne
    private Link link;
}
