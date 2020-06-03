package com.example.microserviceuser.service;

import java.util.List;
import java.util.Optional;

import com.example.microserviceuser.models.User;

public interface IUserService {
	
	public User saveUser (User user);
	
	public List<User> findAllUsers ();
	
	public Optional<User> findUserById(Integer id);
	
	public boolean findUserByUsername(String username);

	public void deleteUserById(Integer id);
	
	public User updateUser(User newUser, Integer id);
	
	public void deleteAllUsers();
	
	public boolean login(User user);
	
	public boolean logout(User user);

}
