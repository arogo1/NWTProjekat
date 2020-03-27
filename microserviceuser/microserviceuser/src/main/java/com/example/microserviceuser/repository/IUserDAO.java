package com.example.microserviceuser.repository;

import com.example.microserviceuser.modelDTO.UserDTO;

public interface IUserDAO {
	
	 boolean save(UserDTO user) throws Exception;

}
