package com.example.demo.service;

import com.example.demo.DAO.IUserDAO;
import com.example.demo.modelDTO.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements IUserService {

    @Autowired
    IUserDAO userDAO;
    @Override
    public boolean save(User user) throws Exception {
        userDAO.save(user);
        return false;
    }
}
