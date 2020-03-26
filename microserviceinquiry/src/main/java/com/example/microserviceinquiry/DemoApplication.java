package com.example.microserviceinquiry;

import java.util.ArrayList;
import java.util.List;

import com.example.microserviceinquiry.DAO.AnswerRepository;
import com.example.microserviceinquiry.DAO.InquiryRepository;
import com.example.microserviceinquiry.DAO.QuestionGroupRepository;
import com.example.microserviceinquiry.DAO.QuestionRepository;
import com.example.microserviceinquiry.ModelDTO.AnswerDTO;
import com.example.microserviceinquiry.ModelDTO.InquiryDTO;
import com.example.microserviceinquiry.ModelDTO.QuestionDTO;
import com.example.microserviceinquiry.ModelDTO.QuestionGroupDTO;

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

	
	// InquiryDAO inquiryDAO;

	@Autowired
	InquiryRepository inquiryRepository;

	@Autowired
	QuestionGroupRepository questionGroupRepository;

	@Autowired
	AnswerRepository answerRepository;

	@Autowired
	QuestionRepository questionRepository;
	
	@RequestMapping(value="/saveQuestion")
	public String saveQuestion(QuestionDTO questionDTO) {
		System.out.println("Usao");
		//questionDTO.SetQuestionGroupId(1);
		questionDTO.SetQuestion("Test");
		try {
			questionRepository.save(questionDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return "error " + e;
		}
		return "Spaseno";
		}


	@RequestMapping(value="/saveAnswer")
	public String saveAnswer(AnswerDTO answerDTO) {
		System.out.println("Usao");
		//answerDTO.SetQuestionId(1);
		answerDTO.SetAnswer("Test");
		answerDTO.SetIsCorrect(true);
		try {
			answerRepository.save(answerDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return "error " + e;
		}
		return "Spaseno";
		}

	@RequestMapping(value="/saveQuestionGroup")
	public String saveQuestionGroup(QuestionGroupDTO questionGroupDTO) {
		System.out.println("Usao");
		// questionGroupDTO.SetInquiryId(1);
		questionGroupDTO.SetQuestionGroupName("Test");
		questionGroupDTO.SetNumberOfQuestion(2);
		try {
			questionGroupRepository.save(questionGroupDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return "error " + e + questionGroupDTO.GetQuestionGroupName();
		}
		return "Spaseno";
		}

	@GetMapping("/")
	public String nesto() {
		return "Evo me";
	}

	

	@RequestMapping(value="/saveInquiry")
	public String saveInquiry(InquiryDTO inquiryDTO, QuestionGroupDTO questionGroupDTO) {
	System.out.println("Usao");
	List<QuestionGroupDTO> questionGroupsDTO = new ArrayList<>();
	inquiryDTO.setCategoryId(1);
	inquiryDTO.setInquiryName("Proba");
	inquiryDTO.setUserId(2);
	inquiryDTO.setNumberOfQuestionGroup(5);
	
	// questionGroupDTO.SetInquiryId(1);
	questionGroupDTO.SetQuestionGroupName("Proba");
	questionGroupDTO.SetNumberOfQuestion(2);
	questionGroupsDTO.add(questionGroupDTO);
	inquiryDTO.SetQuestionGroupsDTO(questionGroupsDTO);
	System.out.println(inquiryDTO.GetInquiryName());
	try {
		inquiryRepository.save(inquiryDTO);
	} catch (Exception e) {
		e.printStackTrace();
		return "error " + e;
	}
	return "Spaseno";
	}

}
