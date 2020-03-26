package com.example.demo.DAO;

import com.example.demo.modelDTO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO implements IUserDAO {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean save(User user) throws Exception {
        userRepository.save(user);
        return true;
    }
}
