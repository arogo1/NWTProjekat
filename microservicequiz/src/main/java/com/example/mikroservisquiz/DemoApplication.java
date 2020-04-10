package com.example.mikroservisquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
@EnableAutoConfiguration
@EnableEurekaClient
//@ComponentScan(basePackages={"com.example.mikroservisquiz.conroller.donequiz"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	// @GetMapping("/")
	// public String getMethod(){
	// 	return "kvizic";
	// }
	// @Autowired
	// quizRepository repository;

	// @Autowired
	// doneQuizRepository doneQuizRepository;

	// @RequestMapping(value="/saveQuiz")
	// public String saveInquiry(Quiz quiz) {
	// 	quiz.SetInquiryId(1);
	// 	quiz.SetResult(40);
	// 	quiz.SetNumOfAns(10);
	// try {
	// 	repository.save(quiz);
	// } catch (Exception e) {
	// 	e.printStackTrace();
	// 	return "error " + e;
	// }
	// return "Uneseno u bazicu";
	// }

	// @RequestMapping(value="/saveDoneQuiz")
	// public String saveInquiry(DoneQuiz done_quiz) {
	// 	done_quiz.setUserId(1);
	// try {
	// 	doneQuizRepository.save(done_quiz);
	// } catch (Exception e) {
	// 	e.printStackTrace();
	// 	return "error " + e;
	// }
	// return "Uneseno u bazicu1";
	// }

}
