package com.example.microserviceuser.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.microserviceuser.modelDTO.UserDTO;

@Component
public class UserDAO implements IUserDAO {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO save(UserDTO user) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.save(user);
		
	}

	@Override
	public Iterable<UserDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findAll();
		
	}

	@Override
	public Optional<UserDTO> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

}
