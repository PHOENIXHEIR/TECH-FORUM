package com.practice.springbootdemo.services;

import com.practice.springbootdemo.exceptions.PermissionDeniedException;
import com.practice.springbootdemo.models.Role;
import com.practice.springbootdemo.models.RoleEnum;
import com.practice.springbootdemo.models.User;
import com.practice.springbootdemo.repositories.RoleRepository;
import com.practice.springbootdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private @Autowired UserService userService;
    private @Autowired UserRepository repository;
    private @Autowired RoleRepository roleRepository;
    private @Autowired PasswordEncoder encoder;
    private @Autowired MyUserDetailsServiceImpl userDetailsService;


    public User addAdmin(User user) throws PermissionDeniedException{

        if (user.hasRole(new Role(RoleEnum.ROLE_ADMIN)))
            return user;


        Optional optionalAdmin = repository.findById(user.getEmailId());
        Optional optionalRole = roleRepository.getRoleByName(RoleEnum.ROLE_ADMIN);

        Role role;

        if (optionalRole.isPresent()){
            role = (Role) optionalRole.get();
        }else{
            role = new Role(RoleEnum.ROLE_ADMIN);
        }

        if (!optionalAdmin.isPresent()) {
            user.setPassword(encoder.encode(user.getPassword()));
        }

        user.addRole(role);

        return repository.save(user);
    }
}
