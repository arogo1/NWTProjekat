package com.example.microserviceuser.repository;

import java.util.Optional;

import com.example.microserviceuser.models.ApplUser;

public interface IUserDAO {
	
	 ApplUser save(ApplUser user) throws Exception;
	 
	 public Iterable<ApplUser> findAll() throws Exception;
	 
	 public Optional<ApplUser> findById(Integer id) throws Exception;
	 
	 void deleteById(Integer id) throws Exception;
}
