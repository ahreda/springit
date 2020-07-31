package com.vega.springit.Security;

import com.vega.springit.domain.User;
import com.vega.springit.repository.UserRepository;
import com.vega.springit.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    UserRepository userRepository;
    UserService userService;

    public UserDetailsServiceImpl(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByEmail(email);
        //Optional<User> user = userService.findByUserName(userName);
        if (!user.isPresent()) {
           throw new UsernameNotFoundException(email);
           //throw new UsernameNotFoundException(userName);

        }

        return user.get();
    }
}
