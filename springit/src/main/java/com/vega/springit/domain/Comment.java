package com.vega.springit.domain;

import com.vega.springit.services.BeanUtil;
import lombok.*;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 *Create a Comment Entity , NoArgument constructor and getter and sitter methods using annotations.
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Comment extends Auditable {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    @NotEmpty (message = "Please Comment")
    private String body;

    /**
     * Associate the Comment Entity with the Link Entity, with Many to one relationship.
     */
    //Link
    @ManyToOne
    @NonNull
    private Link link;


    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }

    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", link=" + link +
                '}';
    }
}
