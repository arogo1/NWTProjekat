package com.example.microserviceuser.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.microserviceuser.models.User;

@Component
public class UserDAO implements IUserDAO {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User save(User user) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.save(user);
		
	}

	@Override
	public Iterable<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findAll();
		
	}

	@Override
	public Optional<User> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

}
