package com.example.mikroservisquiz;

import com.example.mikroservisquiz.models.DoneQuiz;
import com.example.mikroservisquiz.models.Quiz;
import com.example.mikroservisquiz.repository.doneQuizRepository;
import com.example.mikroservisquiz.repository.quizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String getMethod(){
		return "kvizic";
	}
	@Autowired
	quizRepository repository;

	@Autowired
	doneQuizRepository doneQuizRepository;

	@RequestMapping(value="/saveQuiz")
	public String saveInquiry(Quiz quiz) {
		quiz.SetInquiryId(1);
		quiz.SetResult(40);
		quiz.SetNumOfAns(10);
	try {
		repository.save(quiz);
	} catch (Exception e) {
		e.printStackTrace();
		return "error " + e;
	}
	return "Uneseno u bazicu";
	}

	@RequestMapping(value="/saveDoneQuiz")
	public String saveInquiry(DoneQuiz done_quiz) {
		done_quiz.setUserId(1);
	try {
		doneQuizRepository.save(done_quiz);
	} catch (Exception e) {
		e.printStackTrace();
		return "error " + e;
	}
	return "Uneseno u bazicu1";
	}

}
