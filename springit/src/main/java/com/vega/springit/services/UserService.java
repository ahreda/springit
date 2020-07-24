package com.vega.springit.services;

import com.vega.springit.domain.User;
import com.vega.springit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register( User user){
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
}


