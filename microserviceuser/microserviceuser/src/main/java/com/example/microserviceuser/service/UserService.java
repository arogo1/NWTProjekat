package com.example.microserviceuser.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microserviceuser.models.User;
import com.example.microserviceuser.models.error.ResourceNotFoundException;
import com.example.microserviceuser.repository.UserDAO;
import com.example.microserviceuser.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDAO userRepository;

	// @Override
	// public Iterable<User> findAllUsers() {
	// // TODO Auto-generated method stub
	// return userRepository.findAll();

	// }

	// @Override
	// public Optional<User> findUserById(Integer id) {
	// // TODO Auto-generated method stub
	// return userRepository.findById(id);
	// }

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		try {
			userRepository.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Override
	// public void deleteUserById(Integer id) {
	// 	// TODO Auto-generated method stub
	// 	userRepository.deleteById(id);
		
	// }

	// @Override
	// public User updateUser(User newUser, Integer id) {
	// 	// TODO Auto-generated method stub
	// 	return userRepository.findById(id)
    //             .map(user -> {
    //                 user.setUserId(newUser.getUserId()); 
    //                 user.setUsername(newUser.getUsername());
    //                 user.setPassword(newUser.getPassword());
    //                 try {
	// 					return userRepository.save(user);
	// 				} catch (Exception e) {
	// 					// TODO Auto-generated catch block
	// 					e.printStackTrace();
	// 					return null;
	// 				}
    //             }).orElseGet(() -> {
	// 				try {
	// 					return userRepository.save(newUser);
	// 				} catch (Exception e) {
	// 					// TODO Auto-generated catch block
	// 					e.printStackTrace();
	// 					return null;
	// 				}
	// 			});


	// }


	
	
}
