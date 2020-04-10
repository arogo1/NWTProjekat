package com.example.microserviceuser.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microserviceuser.models.User;
import com.example.microserviceuser.repository.IUserDAO;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

	@Override
	public Iterable<User> findAllUsers() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.findAll();
		
	}

	@Override
	public Optional<User> findUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}


	@Override
	public User saveUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.save(user);
	}

	@Override
	public void deleteUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		userDAO.deleteById(id);
		
	}

	@Override
	public User updateUser(User newUser, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.findById(id)
                .map(user -> {
                    user.setUserId(newUser.getUserId()); 
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    try {
						return userDAO.save(user);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
                }).orElseGet(() -> {
					try {
						return userDAO.save(newUser);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
				});


	}


	
	
}
