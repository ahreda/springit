package com.vega.springit.Security;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {


    private UserDetailsServiceImpl userDetailsService;

    public SecurityConfigurations(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/link/submit").hasRole("USER")
                    .antMatchers("/h2-console/**").permitAll()
                    .antMatchers("/actuator").hasRole("ADMIN")
                    .antMatchers("/newlink").permitAll()
                .requestMatchers(EndpointRequest.to("info")).hasRole("USER")
                //.requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")

        .and()
        .formLogin()
              .loginPage("/login").permitAll()
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .and()

         .logout()
                .logoutSuccessUrl("/login?logout")
         .and()
         .rememberMe()

        .and()
        .csrf().disable()
        .headers().frameOptions().disable();
    }

   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
