package com.example.microserviceinquiry;

import com.example.microserviceinquiry.DAO.InquiryRepository;
import com.example.microserviceinquiry.ModelDTO.InquiryDTO;

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

	@GetMapping("/")
	public String nesto() {
		return "Evo me";
	}

	@RequestMapping(value="/saveInquiry")
	public String saveInquiry(InquiryDTO inquiryDTO) {
	System.out.println("Usao");
	inquiryDTO.setCategoryId(1);
	inquiryDTO.setInquiryName("Test");
	inquiryDTO.setUserId(2);
	inquiryDTO.setNumberOfQuestionGroup(5);
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
