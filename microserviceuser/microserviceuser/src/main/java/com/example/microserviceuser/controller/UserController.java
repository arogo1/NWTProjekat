package com.example.microserviceuser.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microserviceuser.controller.exception.UserNotFoundException;
import com.example.microserviceuser.models.User;
import com.example.microserviceuser.repository.UserRepository;
import com.example.microserviceuser.service.IUserService;
import com.example.microserviceuser.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/users")
	public Iterable<User>getUsers(){
        try {
        	System.out.println("try");
			return userService.findAllUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("catch");
			e.printStackTrace();
			return null;
		}
    }
    @GetMapping("/user/{id}")
    public Optional<User> findById(@PathVariable("id") Integer id){
			try {
				return Optional.ofNullable(userService.findUserById(id).orElseThrow(() -> new UserNotFoundException(id)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
    }
    
    @PostMapping("/user")
    public User newUser(User newUser) {
        try {
			return userService.saveUser(newUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        try {
			userService.deleteUserById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable("id") Integer id) {
       try {
		return userService.updateUser(newUser, id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
    }

}
