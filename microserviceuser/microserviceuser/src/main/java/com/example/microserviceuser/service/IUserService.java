package com.example.microserviceuser.service;

import com.example.microserviceuser.modelDTO.UserDTO;

public interface IUserService {
	
	boolean save(UserDTO user) throws Exception;

}
