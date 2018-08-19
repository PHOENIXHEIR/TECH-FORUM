package com.practice.springbootdemo.controllers;

import java.security.Principal;
import java.util.List;

import com.practice.springbootdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.practice.springbootdemo.models.User;

//THIS CLASS HAS NOT BEEN MODIFIED TO BE RESTFUL YET...

@Controller
public class RootController {

	@Autowired
	private UserService userService;

	/**
	 * Important to stop spring from showing default page not found for any request.
	 * Spring doesn't know about the routes on the front-end.
	 * So, just forward every request to index.html, if the page requested really doesn't exist,
	 * the error 404 is managed by the front-end.
	 *
	 * @return forwarder String to index.html
	 */
	@GetMapping(value = "/{path:[^\\.]*}")
	public String redirect() {
		return "forward:/";
	}


	@PostMapping("/signup")
	@ResponseBody
	public User signUp(@RequestBody User user){
		return userService.saveUser(user);
	}
}
