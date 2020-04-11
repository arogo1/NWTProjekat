package com.example.microserviceuser.service;

import java.util.Optional;

import com.example.microserviceuser.models.User;

public interface IUserService {
	
	public void saveUser (User user);
	
	// public Iterable<User> findAllUsers ();
	
	// public Optional<User> findUserById(Integer id);

	// public void deleteUserById(Integer id);
	
	// public User updateUser(User newUser, Integer id);

}
