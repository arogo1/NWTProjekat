package com.example.microserviceuser.service;

import java.util.List;
import java.util.Optional;

import com.example.microserviceuser.models.UserModel;

public interface IUserService {
	
	public UserModel saveUser (UserModel user);
	
	public List<UserModel> findAllUsers ();
	
	public Optional<UserModel> findUserById(Integer id);
	
	public boolean findUserByUsername(String username);

	public void deleteUserById(Integer id);
	
	public UserModel updateUser(UserModel newUser, Integer id);
	
	public void deleteAllUsers();
	
	public boolean login(UserModel user);
	
	public boolean logout(UserModel user);

}
