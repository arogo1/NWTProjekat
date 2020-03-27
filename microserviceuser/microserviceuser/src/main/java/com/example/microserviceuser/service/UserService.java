package com.example.microserviceuser.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.microserviceuser.modelDTO.UserDTO;
import com.example.microserviceuser.repository.IUserDAO;

public class UserService implements IUserService {

    @Autowired
    IUserDAO userDAO;
    @Override
    
    public boolean save(UserDTO user) throws Exception {
        userDAO.save(user);
        return true;
    }
}
