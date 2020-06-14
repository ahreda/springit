package com.vega.springit;
import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}

@Bean
CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
return args -> {

Link link = new Link("Getting started with Spring Boot","https://therealdanvega.com/spring-boot-2");
linkRepository.save(link);
Link link2 = new Link("My second title", "https://mysecond.com/spring-boot-2");
linkRepository.save(link2);

Link link3 = new Link("My third Link", "https://my third.com/spring-boot-2");
linkRepository.save(link3);


Comment comment = new Comment("This is Spring Boot with Link comment",link);
commentRepository.save(comment);
Comment comment2 = new Comment("Another comment",link2);
commentRepository.save(comment2);

Comment comment3 = new Comment("This is the comment for the third link", link3);
commentRepository.save(comment3);

link.addComment(comment);
link.addComment(comment2);
link.addComment(comment3);

    Link myLink= linkRepository.findByTitle("Getting started with Spring Boot");
    System.out.println(myLink.getTitle());

	Comment com1 = commentRepository.findByBody("This is the comment for the third link");
	System.out.println("he");
	String stt= com1.getBody();
	System.out.println(stt);


};


	}
}








