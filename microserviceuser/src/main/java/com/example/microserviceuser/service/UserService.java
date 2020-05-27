package com.example.microserviceuser.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.microserviceuser.models.UserModel;
import com.example.microserviceuser.models.error.ResourceNotFoundException;
import com.example.microserviceuser.repository.UserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

	public List<UserModel> findAllUsers() {
		// TODO Auto-generated method stub
		List<UserModel> users = new ArrayList<UserModel>();
        Iterable<UserModel> response = userRepository.findAll();
        response.forEach(users::add);
        return users;
	}

	public Optional<UserModel> findUserById(Integer id){
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
	
	public boolean findUserByUsername(String username){
		// TODO Auto-generated method stub
		Iterable<UserModel> allUsers = userRepository.findAll();
		for (UserModel usr : allUsers) {
			if(usr.getUsername().contentEquals(username)) {
				return true;
			}
		}
		return false;
	}

	public UserModel saveUser(UserModel user){
		// TODO Auto-generated method stub	
		return userRepository.save(user);
	}

	public void deleteUserById(Integer id){
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	public UserModel updateUser(UserModel newUser, Integer id){
		// TODO Auto-generated method stub
		return userRepository.findById(id)
                .map(user -> {
                    user.setUserId(newUser.getUserId()); 
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                  
						return userRepository.save(user);
                }).orElseGet(()-> userRepository.save(newUser));
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
	}

	
	public boolean login(UserModel user) {
		// TODO Auto-generated method stub
		Iterable<UserModel> allUsers = userRepository.findAll();
		Iterable<UserModel> logedUsers = userRepository.findAll();
		for (UserModel usr : allUsers) {
			if(usr.getUsername().contentEquals(user.getUsername()) && usr.getPassword().contentEquals(user.getPassword())) {
				for(UserModel logedusr : logedUsers) {
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


	public boolean logout(UserModel user) {
		// TODO Auto-generated method stub
		Iterable<UserModel> allUsers = userRepository.findAll();
		for (UserModel usr : allUsers) {
			if(usr.getUsername().contentEquals(user.getUsername()) && usr.getPassword().contentEquals(user.getPassword())) {
				usr.setLoged(false);
				userRepository.save(usr);
				return true;
			}
		}
		return false;
		
	}

	

	
}
