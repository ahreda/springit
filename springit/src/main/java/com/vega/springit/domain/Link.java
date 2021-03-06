package com.vega.springit.domain;

import com.vega.springit.services.BeanUtil;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * Create a Link Entity with No Arguments constructor and sitter and getter methods using annotations.
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter


public class Link extends Auditable {
    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @NotEmpty(message = "Please enter a title")
    private String title;

    @NonNull
    @NotEmpty(message = "Please enter a URL")
    @URL(message = "Please enter a valid URL")
    private String url;


    /**
     * Associate the Link Entity with Comment Entity with One to Many Relationship.
     */
    //Comment
   @OneToMany(mappedBy = "link")
   private List<Comment> comments = new ArrayList<>();

   @OneToMany(mappedBy = "link")
   private List<Vote> votes = new ArrayList<>();

   @ManyToOne
   private User user;

   private int voteCount = 0;

   public void addComment(Comment comment){
       comments.add(comment);

   }
    public String getDomainName() throws URISyntaxException {
        URI uri = new URI(this.url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }

    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

}



