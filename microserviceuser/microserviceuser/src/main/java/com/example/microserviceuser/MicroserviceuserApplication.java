package com.example.microserviceuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microserviceuser.modelDTO.UserDTO;
import com.example.microserviceuser.repository.UserRepository;

@SpringBootApplication
@RestController
@ConfigurationPropertiesScan
public class MicroserviceuserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceuserApplication.class, args);
	}
	
	    @Autowired
	    UserRepository userRepository;

	   @RequestMapping(value = "/saveUser")
	    public String saveUser(UserDTO user) {
	        System.out.println("Radi");
	        user.setUsername("slekic");
	        user.setPassword("test123456");
	        System.out.println(user.getUsername());
	        try {
	            userRepository.save(user);
	            System.out.println("repository");
	        } catch (Exception e) {
	        	System.out.println("error");
	            e.printStackTrace();
	            return "error " + e;
	        }
	        return "spaseno";
	    }
	 @RequestMapping("/test") 
		 public String test() {
			 return "nesto";
		 }
	 

}
