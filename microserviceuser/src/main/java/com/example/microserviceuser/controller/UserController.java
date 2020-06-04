package com.example.microserviceuser.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microserviceuser.validation.PasswordValidator;
import com.example.microserviceuser.models.ApplUser;
import com.example.microserviceuser.models.error.ResourceNotFoundException;
import com.example.microserviceuser.repository.UserRepository;
import com.example.microserviceuser.service.IUserService;
import com.example.microserviceuser.service.UserService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/users")
	public List<ApplUser>getUsers() {
			if(userService.findAllUsers().toString()=="[]")
				throw new ResourceNotFoundException("No users found!");
		return userService.findAllUsers();
			
    }
	
    @GetMapping("/user/{id}")
    public ApplUser findById(@PathVariable("id") Integer id){
    	System.out.println(userService.findUserById(id).isEmpty());
    	if(userService.findUserById(id).isEmpty())
    		throw new ResourceNotFoundException(id);
		return userService.findUserById(id).get();
    }
    
   /*@GetMapping("/user/find/{username}")
   public User findUserByUsername(@PathVariable("username") String username) {
	   if(userService.findUserByUsername(username)==null)
		   throw new ResourceNotFoundException("No user with this username found!");
		return userService.findUserByUsername(username);
   }*/
    
    @PostMapping("/user")
    public ApplUser newUser(ApplUser newUser) {
    	if(userService.findUserByUsername(newUser.getUsername()))
    		throw new ResourceNotFoundException("Already exists user with this username");
   
		PasswordValidator passwordValidator = new PasswordValidator();
		Boolean response = passwordValidator.validate(newUser.getPassword());
		if(response) 
			return userService.saveUser(newUser);
		else 
			throw new ResourceNotFoundException("Password must contain 8-40digits,at least one digit,at least one lower case character and at least one upper case character!");
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
		userService.deleteUserById(id);
    }
    
    @DeleteMapping("/deleteAll")
    public void deleteAllUsers() {
		userService.deleteAllUsers();
    }
    
    @PutMapping("/user/{id}")
    public ApplUser updateUser(@RequestBody ApplUser newUser, @PathVariable("id") Integer id) {
    	PasswordValidator passwordValidator = new PasswordValidator();
		Boolean response = passwordValidator.validate(newUser.getPassword());
		System.out.println(userService.findUserById(id).isEmpty());
    	if(userService.findUserById(id).isEmpty()) {
    		if(!userService.findUserByUsername(newUser.getUsername())) {
    			if(response)
    				return userService.saveUser(newUser);
    			throw new ResourceNotFoundException("Password must contain 8-40digits,at least one digit,at least one lower case character and at least one upper case character!");
    		}
    		throw new ResourceNotFoundException("Already exists user with this username!");
    	}

    	/*else if(!userService.findUserById(id).isEmpty() && userService.findUserByUsername(newUser.getUsername())) {
    		if(response)
				return userService.saveUser(newUser);
			throw new ResourceNotFoundException("Password must contain 8-40digits,at least one digit,at least one lower case character and at least one upper case character!");
    	}*/

    	else if(!userService.findUserByUsername(newUser.getUsername())) {
    		if(response)
    			return userService.updateUser(newUser, id);
			throw new ResourceNotFoundException("Password must contain 8-40digits,at least one digit,at least one lower case character and at least one upper case character!");
    	}

		throw new ResourceNotFoundException("Cannot update because already exists user with this username!");

    }
    
    @PostMapping("/user/login")
    public String login(ApplUser user) {
    	if(userService.login(user)) 
    		return "User loged in";
    	return "Something went wrong";
    	
    }
    
    @PostMapping("/user/logout")
    public String logout(ApplUser user) {
    	if(userService.logout(user)) 
    		return "User loged out";
    	return "Something went wrong";
    }
    
    @GetMapping("/user-microservice/getLogedUser")
    public Integer getLogedUser() {
    	Iterable<ApplUser> allUsers = userService.findAllUsers();
		for (ApplUser usr : allUsers) {
			if(usr.getLoged()) {
				return usr.getUserId();
			}
		}
		throw new ResourceNotFoundException("No loged user found!");
    }

}
