package com.practice.springbootdemo.services;

import com.practice.springbootdemo.models.Role;
import com.practice.springbootdemo.models.RoleEnum;
import com.practice.springbootdemo.models.User;
import com.practice.springbootdemo.repositories.RoleRepository;
import com.practice.springbootdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class to maintain users.
 * Created by debanikd on 7/20/2018.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    protected RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User saveUser(User user) throws DuplicateKeyException{
        if (repository.existsById(user.getEmailId())){
            throw new DuplicateKeyException("Sorry, the username already exists");
        }

        Optional userRole = roleRepository.getRoleByName(RoleEnum.ROLE_USER);
        Role role;

        if (userRole.isPresent()){
            role = (Role) userRole.get();
        }else{
            role = new Role(RoleEnum.ROLE_USER);
        }

        user.addRole(role);
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }



    public String getLoggedInUserEmailId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            return ((UserDetails)principal).getUsername();
        }else{
            return principal.toString();
        }
    }
}
