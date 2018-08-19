package com.practice.springbootdemo.controllers;

import java.security.Principal;
import java.util.List;

import com.practice.springbootdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.practice.springbootdemo.models.User;

@Controller
public class MainController{

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView root(){
		ModelAndView mAndView = new ModelAndView();

		mAndView.setViewName("home");
		return mAndView;
	}
	
	@RequestMapping("/viewusers")
	public ModelAndView viewCustomers(){
		ModelAndView mAndView = new ModelAndView();
		
		List<User>users = userService.getAllUsers();
		mAndView.addObject("users", users);
		mAndView.setViewName("viewusers");

		return mAndView;
	}
	
	@RequestMapping("/signup")
	public ModelAndView signUp(){
		ModelAndView mAndView = new ModelAndView();

		mAndView.addObject("user", new User());
		mAndView.setViewName("signup");
		return mAndView;
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute User user){
		userService.saveUser(user);
		return viewCustomers();
	}
}
