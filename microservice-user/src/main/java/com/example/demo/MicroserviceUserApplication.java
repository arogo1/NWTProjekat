package com.example.demo;

import com.example.demo.DAO.UserRepository;
import com.example.demo.modelDTO.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ConfigurationPropertiesScan
public class MicroserviceUserApplication {

    public static void main(String[] args) {

        SpringApplication.run(MicroserviceUserApplication.class, args);
    }
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("Radi");
        user.setUsername("slekic");
        user.setPassword("test123456");
        System.out.println(user.getUsername());
        System.out.println(user.getId());
        try {
            userRepository.save(user);
            System.out.println("repository");
        } catch (Exception e) {
            e.printStackTrace();
            return "error " + e;
        }
        return "spaseno";
    }
   @RequestMapping("/test")
    public String test() {
       return "Hajde molim te";
   }

}
