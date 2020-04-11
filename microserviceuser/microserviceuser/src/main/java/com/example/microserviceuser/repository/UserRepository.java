package com.example.microserviceuser.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microserviceuser.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findUserByUsername(String username);

}
