package com.example.microserviceuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.boot.CommandLineRunner;

import com.example.microserviceuser.models.UserModel;
import com.example.microserviceuser.repository.UserRepository;
import com.example.microserviceuser.service.IUserService;
import com.example.microserviceuser.service.UserService;

import java.util.List;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@RestController
@ConfigurationPropertiesScan
@ComponentScan(basePackages={"com.example.microserviceuser"})
@EnableEurekaClient
@EnableAutoConfiguration
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

	   @PostMapping(value = "/saveUser")
	    public String saveUser(@RequestBody UserModel user) {
	        System.out.println("Radi");
	        user.setUsername("slekic");
			user.setPassword("test123456");
			user.setUserId(1);
	        System.out.println(user.getUsername());
	        try {
	            //userRepository.save(user);
	        	userService.saveUser(user);
	            System.out.println("repository");
	            System.out.println(userService.findUserById(1));
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
	 
	 @RestController
	 class ServiceInstanceRestController {
		 
		 @Autowired
		 private DiscoveryClient discoveryClient;
		 
		 @RequestMapping("service-instances/{applicationName}")
		 public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
			 return this.discoveryClient.getInstances(applicationName);
			 
		 }
	 }
	 
	 /*@Component
	 class DiscoveryClientExample {

	     @Autowired
	     private DiscoveryClient discoveryClient;

	     public List<ServiceInstance> run(String applicationName) throws Exception {
	    	 discoveryClient.getInstances(applicationName).forEach((ServiceInstance s) -> {
	         System.out.println(ToStringBuilder.reflectionToString(s));
	    	 });
	         return discoveryClient.getInstances(applicationName);
	         
	         /*discoveryClient.getInstances("quiz-microservice").forEach((ServiceInstance s) -> {
	             System.out.println(ToStringBuilder.reflectionToString(s));
	         });
	     
	     }
	 }*/
	 

}
