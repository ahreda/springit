package com.vega.springit.bootstrap;


import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.domain.Role;
import com.vega.springit.domain.User;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import com.vega.springit.repository.RoleRepository;
import com.vega.springit.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DatabaseLoader implements CommandLineRunner {

    LinkRepository linkRepository;
    CommentRepository commentRepository;
    UserRepository userRepository;
    RoleRepository roleRepository;

    public DatabaseLoader(LinkRepository linkRepository, CommentRepository commentRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.linkRepository = linkRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        Map<String,String> links = new HashMap<>();
        links.put("Securing Spring Boot APIs and SPAs with OAuth 2.0","https://auth0.com/blog/securing-spring-boot-apis-and-spas-with-oauth2/?utm_source=reddit&utm_medium=sc&utm_campaign=springboot_spa_securing");
        links.put("Easy way to detect Device in Java Web Application using Spring Mobile - Source code to download from GitHub","https://www.opencodez.com/java/device-detection-using-spring-mobile.htm");
        links.put("Tutorial series about building microservices with SpringBoot (with Netflix OSS)","https://medium.com/@marcus.eisele/implementing-a-microservice-architecture-with-spring-boot-intro-cdb6ad16806c");
        links.put("Detailed steps to send encrypted email using Java / Spring Boot - Source code to download from GitHub","https://www.opencodez.com/java/send-encrypted-email-using-java.htm");
        links.put("Build a Secure Progressive Web App With Spring Boot and React","https://dzone.com/articles/build-a-secure-progressive-web-app-with-spring-boo");
        links.put("Building Your First Spring Boot Web Application - DZone Java","https://dzone.com/articles/building-your-first-spring-boot-web-application-ex");
        links.put("Building Microservices with Spring Boot Fat (Uber) Jar","https://jelastic.com/blog/building-microservices-with-spring-boot-fat-uber-jar/");
        links.put("Spring Cloud GCP 1.0 Released","https://cloud.google.com/blog/products/gcp/calling-java-developers-spring-cloud-gcp-1-0-is-now-generally-available");
        links.put("Simplest way to Upload and Download Files in Java with Spring Boot - Code to download from Github","https://www.opencodez.com/uncategorized/file-upload-and-download-in-java-spring-boot.htm");
        links.put("Add Social Login to Your Spring Boot 2.0 app","https://developer.okta.com/blog/2018/07/24/social-spring-boot");
        links.put("File download example using Spring REST Controller","https://www.jeejava.com/file-download-example-using-spring-rest-controller/");
        links.put("New new new new new new new new new new new new new ","https://www.jeejava.com/file-download-example-using-spring-rest-controller/");

        links.forEach((k,v) -> {
            Link link = new Link(k,v);
            linkRepository.save(link);

            Comment spring = new Comment("Thank you for this link related to Spring Boot. I love it, great post!",link);
            Comment security = new Comment("I love that you're talking about Spring Security",link);
            Comment pwa = new Comment("What is this Progressive Web App thing all about? PWAs sound really cool.",link);

            Comment comments[] = {spring,security,pwa};
            Arrays.stream(comments).forEach(comment -> {commentRepository.save(comment);

            link.addComment(comment);});

          /*  for (Comment comment : comments){
                commentRepository.save(comment);
                link.addComment(comment);
            }*/
        });

        long linkCount = linkRepository.count();
        System.out.println("The number of links in our database is" + "\n" +linkCount);

        addUsersAndRoles();

        }

        private void addUsersAndRoles(){
            // password Encoding
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String userpass = "{bcrypt}" + encoder.encode("User.147");
            String adminpass ="{bcrypt}" + encoder.encode("Admin.147");
            String masterPass = "{bcrypt}" + encoder.encode("Master.147");


            // Create Roles & Add to the Role Repository
            Role userRole = new Role("ROLE_USER");
            Role adminRole = new Role("ROLE_ADMIN");
            roleRepository.save(userRole);
            roleRepository.save(adminRole);


            //Create Users
            User user = new User("user@gmail.com", userpass, true);
            User admin = new User("admin@gmail.com", adminpass, true);
            User master = new User("master@gmail.com", masterPass, true);


            // Add the roles to the users by addRole method ( single role)
            user.addRole(userRole);
            userRepository.save(user);
            admin.addRole(adminRole);
            userRepository.save(admin);

            //addRoles ( adding set of roles directly).
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(userRole);
            roleSet.add(adminRole);

            master.addRoles(roleSet);
            userRepository.save(master);







        }

    }
