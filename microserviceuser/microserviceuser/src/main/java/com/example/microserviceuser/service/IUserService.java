package com.example.microserviceuser.service;

import java.util.Optional;

import com.example.microserviceuser.modelDTO.UserDTO;

public interface IUserService {
	
	public UserDTO saveUser (UserDTO user) throws Exception;
	
	public Iterable<UserDTO> findAllUsers () throws Exception;
	
	public Optional<UserDTO> findUserById(Integer id) throws Exception;

	void deleteUserById(Integer id) throws Exception;
	
	public UserDTO updateUser(UserDTO newUser, Integer id) throws Exception;

}
