package com.example.microserviceuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microserviceuser.models.User;
import com.example.microserviceuser.repository.UserRepository;
import com.example.microserviceuser.service.IUserService;
import com.example.microserviceuser.service.UserService;

import java.util.List;


@SpringBootApplication
@RestController
@ConfigurationPropertiesScan
@ComponentScan(basePackages={"com.example.microserviceuser"})
@EnableEurekaClient

public class MicroserviceuserApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceuserApplication.class, args);
	}
	
	    @Autowired
	    IUserService userService;

	   /*@RequestMapping(value = "/saveUser")
	    public String saveUser(User user) {
	        System.out.println("Radi");
	        user.setUsername("slekic");
	        user.setPassword("test123456");
	        System.out.println(user.getUsername());
	        try {
	            //userRepository.save(user);
	        	userService.saveUser(user);
	            System.out.println("repository");
	        } catch (Exception e) {
	        	System.out.println("error");
	            e.printStackTrace();
	            return "error " + e;
	        }
	        return "spaseno";
	    }*/
	 @RequestMapping("/test") 
		 public String test() {
			 return "nesto";
		 }
	 
	 @RestController
	 class ServiceInstanceRestController {
		 
		 @Autowired
		 private DiscoveryClient discoveryClient;
		 
		 @RequestMapping("service-instances/{applicationName}")
		 public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
			 return this.discoveryClient.getInstances(applicationName);
			 
		 }
	 }
	 

}
