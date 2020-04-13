package com.example.microserviceuser.repository;

import java.util.Optional;

import com.example.microserviceuser.models.User;

public interface IUserDAO {
	
	 User save(User user) throws Exception;
	 
	 public Iterable<User> findAll() throws Exception;
	 
	 public Optional<User> findById(Integer id) throws Exception;
	 
	 void deleteById(Integer id) throws Exception;
}
