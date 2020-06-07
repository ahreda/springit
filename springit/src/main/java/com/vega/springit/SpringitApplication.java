package com.vega.springit;
import ch.qos.logback.core.CoreConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(SprinitProperties.class)
public class SpringitApplication {

	@Autowired
	private SprinitProperties sprinitProperties;

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);

	}

	@Bean
	CommandLineRunner runner(){
		return args -> {

			System.out.println("Our  message is :" + sprinitProperties.getWelcomeMG() );
		};
	}

}
