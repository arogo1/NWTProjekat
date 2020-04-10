package com.example.microserviceuser.service;

import java.util.Optional;

import com.example.microserviceuser.models.User;

public interface IUserService {
	
	public User saveUser (User user) throws Exception;
	
	public Iterable<User> findAllUsers () throws Exception;
	
	public Optional<User> findUserById(Integer id) throws Exception;

	void deleteUserById(Integer id) throws Exception;
	
	public User updateUser(User newUser, Integer id) throws Exception;

}
