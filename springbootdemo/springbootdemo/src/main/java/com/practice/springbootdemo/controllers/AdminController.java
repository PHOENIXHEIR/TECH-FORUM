package com.practice.springbootdemo.controllers;

import com.practice.springbootdemo.exceptions.PermissionDeniedException;
import com.practice.springbootdemo.models.User;
import com.practice.springbootdemo.services.AdminService;
import com.practice.springbootdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private @Autowired UserService userService;
    private @Autowired AdminService adminService;

    /**
     * End point to check whether any admin is logged in.
     * @param admin Principal filled by Spring containing details of the user logged in.
     * @return the same principal.
     */
    @GetMapping
    public Principal admin(Principal admin){
        return admin;
    }

    @GetMapping("viewusers")
    public List viewCustomers(){
        return userService.getAllUsers();
    }

    @PostMapping("/addadmin")
    public User addAdmin(@ModelAttribute User user) throws PermissionDeniedException{
        return adminService.addAdmin(user);
    }
}
