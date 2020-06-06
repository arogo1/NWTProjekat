package com.example.microserviceuser.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.microserviceuser.models.ApplUser;
import com.example.microserviceuser.models.error.ResourceNotFoundException;
import com.example.microserviceuser.repository.UserRepository;
import com.example.microserviceuser.validation.MyPasswordEncoder;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

	//@Autowired
	//private AmqpTemplate rabbitTemplate;
	
	 @Autowired
	 MyPasswordEncoder myPasswordEncoder;

	//@Value("${javainuse.rabbitmq.exchange}")
	//private String exchange;

	//@Value("${javainuse.rabbitmq.routingkey}")
	//private String routingkey;

	@Override
	public List<ApplUser> findAllUsers() {
		// TODO Auto-generated method stub
		List<ApplUser> users = new ArrayList<ApplUser>();
        Iterable<ApplUser> response = userRepository.findAll();
        response.forEach(users::add);
        return users;
	}

	@Override
	public Optional<ApplUser> findUserById(Integer id){
		// TODO Auto-generated method stub
		//rabbitTemplate.convertAndSend(exchange, routingkey, id);
		System.out.println("Send msg = " + id);
		return userRepository.findById(id);
	}
	
	@Override
	public boolean findUserByUsername(String username){
		// TODO Auto-generated method stub
		Iterable<ApplUser> allUsers = userRepository.findAll();
		for (ApplUser usr : allUsers) {
			if(usr.getUsername().contentEquals(username)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public ApplUser saveUser(ApplUser user){
		// TODO Auto-generated method stub	
		user.setPassword(myPasswordEncoder.passwordEncoder().encode(user.getPassword()));
		user.setRole("USER");
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Integer id){
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public ApplUser updateUser(ApplUser newUser, Integer id){
		// TODO Auto-generated method stub
		return userRepository.findById(id)
                .map(user -> {
                    user.setUserId(newUser.getUserId()); 
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                  
						return userRepository.save(user);
                }).orElseGet(()-> userRepository.save(newUser));
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
	}

	@Override
	public boolean login(ApplUser user) {
		// TODO Auto-generated method stub
		Iterable<ApplUser> allUsers = userRepository.findAll();
		Iterable<ApplUser> logedUsers = userRepository.findAll();
		for (ApplUser usr : allUsers) {
			if(usr.getUsername().contentEquals(user.getUsername()) && usr.getPassword().contentEquals(user.getPassword())) {
				for(ApplUser logedusr : logedUsers) {
					if(logedusr.getLoged()) 
						return false;
				}
				usr.setLoged(true);
				userRepository.save(usr);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean logout(ApplUser user) {
		// TODO Auto-generated method stub
		Iterable<ApplUser> allUsers = userRepository.findAll();
		for (ApplUser usr : allUsers) {
			if(usr.getUsername().contentEquals(user.getUsername()) && usr.getPassword().contentEquals(user.getPassword())) {
				usr.setLoged(false);
				userRepository.save(usr);
				return true;
			}
		}
		return false;
		
	}

	
}
