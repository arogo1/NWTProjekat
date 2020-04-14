package com.example.microserviceuser.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microserviceuser.models.User;
import com.example.microserviceuser.models.error.ResourceNotFoundException;
import com.example.microserviceuser.repository.UserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
        Iterable<User> response = userRepository.findAll();
        response.forEach(users::add);
        return users;
	}

	@Override
	public Optional<User> findUserById(Integer id){
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
	
	@Override
	public boolean findUserByUsername(String username){
		// TODO Auto-generated method stub
		Iterable<User> allUsers = userRepository.findAll();
		for (User usr : allUsers) {
			if(usr.getUsername().contentEquals(username)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public User saveUser(User user){
		// TODO Auto-generated method stub	
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Integer id){
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User newUser, Integer id){
		// TODO Auto-generated method stub
		return userRepository.findById(id)
                .map(user -> {
                    user.setUserId(newUser.getUserId()); 
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                  
						return userRepository.save(user);
                }).orElseGet(()-> userRepository.save(newUser));
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		Iterable<User> allUsers = userRepository.findAll();
		Iterable<User> logedUsers = userRepository.findAll();
		for (User usr : allUsers) {
			if(usr.getUsername().contentEquals(user.getUsername()) && usr.getPassword().contentEquals(user.getPassword())) {
				for(User logedusr : logedUsers) {
					if(logedusr.getLoged()) 
						return false;
				}
				usr.setLoged(true);
				userRepository.save(usr);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean logout(User user) {
		// TODO Auto-generated method stub
		Iterable<User> allUsers = userRepository.findAll();
		for (User usr : allUsers) {
			if(usr.getUsername().contentEquals(user.getUsername()) && usr.getPassword().contentEquals(user.getPassword())) {
				usr.setLoged(false);
				userRepository.save(usr);
				return true;
			}
		}
		return false;
		
	}

	
}
