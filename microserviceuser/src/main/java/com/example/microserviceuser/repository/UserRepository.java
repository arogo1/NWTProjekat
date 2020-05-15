package com.example.microserviceuser.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microserviceuser.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	//public User findUserByUsername(String username);

}
