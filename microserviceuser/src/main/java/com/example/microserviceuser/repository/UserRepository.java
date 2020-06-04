package com.example.microserviceuser.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microserviceuser.models.ApplUser;

public interface UserRepository extends CrudRepository<ApplUser, Integer> {
	
	//public User findUserByUsername(String username);

}
