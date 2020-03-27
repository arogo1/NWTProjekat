package com.example.microserviceuser.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.microserviceuser.modelDTO.UserDTO;

@Component
public class UserDAO implements IUserDAO {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public boolean save(UserDTO user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
