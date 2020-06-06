package com.example.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.auth.security.UserDetailsServiceImpl;
import com.example.microserviceuser.repository.UserRepository;

@RestController
public class AuthenticationController {
	
	 @Autowired
	 private UserDetailsServiceImpl userDetailsService;
	 
	 @Autowired
	 private RestTemplate restTemplate;
	 
	 @GetMapping("/testRest")
	    public int getQuizes(){
		 int result = restTemplate.getForObject("http://user-microservice/user/1", int.class);
		 return result;
	    }

}
