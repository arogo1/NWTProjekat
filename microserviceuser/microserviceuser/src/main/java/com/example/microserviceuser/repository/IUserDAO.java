package com.example.microserviceuser.repository;

import java.util.Optional;

import com.example.microserviceuser.modelDTO.UserDTO;

public interface IUserDAO {
	
	 UserDTO save(UserDTO user) throws Exception;
	 
	 public Iterable<UserDTO> findAll() throws Exception;
	 
	 public Optional<UserDTO> findById(Integer id) throws Exception;
	 
	 void deleteById(Integer id) throws Exception;
}
