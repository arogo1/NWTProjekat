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

import com.example.microserviceuser.modelDTO.UserDTO;
import com.example.microserviceuser.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
    UserRepository userRepository;
	
	
	@GetMapping("/users")
    public Iterable<UserDTO>getUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    public Optional<UserDTO> findById(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }
    @PostMapping("/user")
    public UserDTO newUser(UserDTO newUser) {
        return userRepository.save(newUser);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
    @PutMapping("/user/{id}")
    public UserDTO updateUser(@RequestBody UserDTO newData, @PathVariable("id") Integer id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUserId(newData.getUserId()); 
                    user.setUsername(newData.getUsername());
                    user.setPassword(newData.getPassword());
                    System.out.println(user.toString());
                    return userRepository.save(user);
                }).orElseGet(() -> userRepository.save(newData));
    }

}
