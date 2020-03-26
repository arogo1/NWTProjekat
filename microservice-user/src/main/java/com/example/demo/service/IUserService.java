package com.example.demo.service;

import com.example.demo.modelDTO.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserService {
    boolean save(User user) throws Exception;
}
