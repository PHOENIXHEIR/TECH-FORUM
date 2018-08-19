package com.practice.springbootdemo.services;


import com.practice.springbootdemo.models.User;
import com.practice.springbootdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class implementing User Details Service to provide custom details to Spring which is used for authentication
 * based on roles.
 */
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    public MyUserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional optionalUser = userRepository.findById(username);

        if (optionalUser.isPresent()){
            User myUser = (User) optionalUser.get();

            return new org.springframework.security.core.userdetails.User(
                    myUser.getEmailId(),
                    myUser.getPassword(),
                    myUser.getAuthorities()
            );
        }else {
            throw new UsernameNotFoundException("Sorry, the requested user was not found.");
        }
    }
}
