package com.vega.springit.repository;

import com.vega.springit.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Long>{

    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String userName);

    Optional<User> findByEmailAndActivationCode(String email, String activationCode);

}
