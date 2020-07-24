package com.vega.springit;
import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import lombok.NonNull;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@EnableTransactionManagement
public class SpringitApplication {



	public static void main(String[] args) {

		SpringApplication.run(SpringitApplication.class, args);
	}

	@Bean
	PrettyTime prettyTime(){
		return new PrettyTime();
	}

	// TODO * Configuring this bean should not be needed once Spring Boot's Thymeleaf starter includes configuration
	// TODO   for thymeleaf-extras-springsecurity5 (instead of thymeleaf-extras-springsecurity4
	@Bean
	public SpringSecurityDialect securityDialect()
	{
		return new SpringSecurityDialect();
	}
}









