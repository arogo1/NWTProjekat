package com.example.microserviceinquiry;

import java.util.ArrayList;
import java.util.List;

import com.example.microserviceinquiry.DAO.InquiryRepository;
import com.example.microserviceinquiry.Models.Inquiry;
import com.example.microserviceinquiry.Models.QuestionGroup;
import com.example.microserviceinquiry.Service.IInquiryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InquiryController {

    @Autowired
    private IInquiryService inquiryService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public @ResponseBody String nesto(){
        return "Usao sam";
    }

    @RequestMapping(value="/saveInquiry")
    public String saveInquiry(Inquiry inquiry) {
        //return "Usooooooooooooooooooo";
        QuestionGroup questionGroup = new QuestionGroup();
        logger.trace("Usao");
        inquiry.setCategoryId(1);
        inquiry.setInquiryName("Proba");
        inquiry.setUserId(2);
        inquiry.setNumberOfQuestionGroup(2);
        
        try {
            inquiryService.save(inquiry);
        } catch (Exception e) {
            e.printStackTrace();
            return "Paoo";
        }
        return "Prosoo";
    }

    // @Autowired
    // InquiryRepository inquiryRepository;

    // @RequestMapping(value="/saveInquiry")
	// public String saveInquiry(Inquiry inquiryDTO, QuestionGroup questionGroupDTO) {
	// System.out.println("Usao");
	// List<QuestionGroup> questionGroupsDTO = new ArrayList<>();
	// inquiryDTO.setCategoryId(1);
	// inquiryDTO.setInquiryName("Proba");
	// inquiryDTO.setUserId(2);
	// inquiryDTO.setNumberOfQuestionGroup(5);
	
	// // questionGroupDTO.SetInquiryId(1);
	// questionGroupDTO.SetQuestionGroupName("Proba");
	// questionGroupDTO.SetNumberOfQuestion(2);
	// questionGroupsDTO.add(questionGroupDTO);
	// inquiryDTO.SetQuestionGroups(questionGroupsDTO);
	// System.out.println(inquiryDTO.GetInquiryName());
	// try {
	// 	inquiryRepository.save(inquiryDTO);
	// } catch (Exception e) {
	// 	e.printStackTrace();
	// 	return "error " + e;
	// }
	// return "Spaseno";
	// }
}