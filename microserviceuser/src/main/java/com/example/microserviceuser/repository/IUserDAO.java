package com.example.microserviceuser.repository;

import java.util.Optional;

import com.example.microserviceuser.models.UserModel;

public interface IUserDAO {
	
	 UserModel save(UserModel user) throws Exception;
	 
	 public Iterable<UserModel> findAll() throws Exception;
	 
	 public Optional<UserModel> findById(Integer id) throws Exception;
	 
	 void deleteById(Integer id) throws Exception;
}
