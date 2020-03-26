package com.example.demo.DAO;

import com.example.demo.modelDTO.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer > {

}
