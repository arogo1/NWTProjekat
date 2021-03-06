package com.example.mikroservisquiz;

import com.example.mikroservisquiz.models.DoneQuiz;
import com.example.mikroservisquiz.models.Quiz;
import com.example.mikroservisquiz.repository.doneQuizRepository;
import com.example.mikroservisquiz.repository.quizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
@EnableAutoConfiguration
@EnableEurekaClient
//@ComponentScan(basePackages={"com.example.mikroservisquiz.conroller.quiz"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@GetMapping("/")
	public String getMethod(){
		return "kvizic";
	}
	@Autowired
	quizRepository repository;

	@Autowired
	doneQuizRepository doneQuizRepository;

}
