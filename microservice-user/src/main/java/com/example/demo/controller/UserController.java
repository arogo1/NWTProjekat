package com.example.demo.controller;

import com.example.demo.DAO.UserRepository;
import com.example.demo.modelDTO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<User>getUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    public Optional<User> findById(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }
    @PostMapping("/user")
    public User newUser(User newUser) {
        return userRepository.save(newUser);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User newData, @PathVariable("id") Integer id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setId(newData.getId());
                    user.setUsername(newData.getUsername());
                    user.setPassword(newData.getPassword());
                    System.out.println(user.toString());
                    return userRepository.save(user);
                }).orElseGet(() -> userRepository.save(newData));
    }

}
