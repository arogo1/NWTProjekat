package com.example.microserviceuser.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microserviceuser.modelDTO.UserDTO;

public interface UserRepository extends CrudRepository<UserDTO, Integer> {

}
