package com.example.demo.DAO;

import com.example.demo.modelDTO.User;

public interface IUserDAO {
    boolean save(User user) throws Exception;
}
