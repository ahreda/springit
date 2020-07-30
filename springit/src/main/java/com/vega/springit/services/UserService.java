package com.vega.springit.services;

import com.vega.springit.domain.User;
import com.vega.springit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;
    private final MailService mailService;

    public UserService(UserRepository userRepository, RoleService roleService, MailService mailService) {

        this.userRepository = userRepository;
        encoder = new BCryptPasswordEncoder();
        this.mailService = mailService;
        this.roleService = roleService;

    }

    public User register( User user){

        // Get the password from the form and encode
        String password = user.getPassword();
        String secret = "{bcrypt}" + encoder.encode(password);
        user.setPassword(secret);

        // Confirm the password
        user.setConfirmPassword(secret);
        // add role to the user

        user.addRole(roleService.findByName("ROLE_USER"));

        // disable the user

        user.setEnabled(false);

        // set activation code

        user.setActivationCode(UUID.randomUUID().toString());

        // send Activation code
        sendActivationCode(user);

        // save the user
        save(user);
        //return the user

        return user;
    }

    public User save(User user){

        return userRepository.save(user);
    }

    @Transactional
    public void saveUsers(User... users) {

        for (User user : users) {
            logger.info("saving a user:" + user.getEmail());
            userRepository.save(user);
        }
    }

    public  void sendActivationCode(User user) {

    mailService.sendActivationEmail(user);

    }

    public void sendWelcomeEmail (User user){

        mailService.sendWelcomeEmail(user);
    }

    public Optional<User> findByEmail (String email){

        return userRepository.findByEmail(email);

    }

   public Optional<User> findByEmailAndActivationCode(String email, String activationCode){

        return userRepository.findByEmailAndActivationCode(email, activationCode);

    }

}



