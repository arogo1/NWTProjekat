package com.example.ZuulAPIGateway.repository;

import java.util.Optional;

import com.example.ZuulAPIGateway.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}