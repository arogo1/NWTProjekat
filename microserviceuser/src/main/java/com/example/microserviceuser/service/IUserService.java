package com.example.microserviceuser.service;

import java.util.List;
import java.util.Optional;

import com.example.microserviceuser.models.ApplUser;

public interface IUserService {
	
	public ApplUser saveUser (ApplUser user);
	
	public List<ApplUser> findAllUsers ();
	
	public Optional<ApplUser> findUserById(Integer id);
	
	public boolean findUserByUsername(String username);

	public void deleteUserById(Integer id);
	
	public ApplUser updateUser(ApplUser newUser, Integer id);
	
	public void deleteAllUsers();
	
	public boolean login(ApplUser user);
	
	public boolean logout(ApplUser user);

}
