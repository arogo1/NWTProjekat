package com.example.microserviceuser.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microserviceuser.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
	
	//public User findUserByUsername(String username);

}
