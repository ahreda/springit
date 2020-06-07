package com.vega.springit;
import com.vega.springit.config.SprinitProperties;
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
		System.out.println("I am here with you today ");

	}

	@Bean
	CommandLineRunner runner(){
		return args -> {

			System.out.println("Our message is that for this khj   :" + sprinitProperties.getWelcomeMG() );
		};
	}

}
