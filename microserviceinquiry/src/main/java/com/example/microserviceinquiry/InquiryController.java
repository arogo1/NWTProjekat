package com.example.microserviceinquiry;

import java.util.ArrayList;
import java.util.List;

import com.example.microserviceinquiry.Exception.SaveException;
import com.example.microserviceinquiry.DAO.InquiryRepository;
import com.example.microserviceinquiry.Exception.RequestException;
import com.example.microserviceinquiry.Models.*;
import com.example.microserviceinquiry.Service.IInquiryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InquiryController {

    @Autowired
    private IInquiryService inquiryService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public @ResponseBody String nesto() {
        return "Usao sam";
    }

    @PostMapping("/saveInquiry")
    public ResponseEntity<Inquiry> saveInquiry(@RequestBody Inquiry inquiry) {
        //int userId = restTemplate.getForObject("Http://user-microservice/getUser()", int.class);
        Inquiry saveInquiry = new Inquiry();
        QuestionGroup questionGroup = new QuestionGroup("Grupa2", 5);
        QuestionGroup questionGroup1 = new QuestionGroup("Grupa3", 5);
        questionGroup.SetInquiry(inquiry);
        questionGroup1.SetInquiry(inquiry);
        List<QuestionGroup> lista = new ArrayList<QuestionGroup>();
        lista.add(questionGroup);
        Question question = new Question("Pitanje");
        Answer answer = new Answer("Odgovor", true);
        saveInquiry.setCategoryId(inquiry.getCategoryId());
        saveInquiry.setInquiryName(inquiry.GetInquiryName());
        saveInquiry.setNumberOfQuestionGroup(inquiry.GetNumberOfQuestion());
        saveInquiry.setUserId(inquiry.getUserId());
        saveInquiry.GetQuestionGroup().add(questionGroup);
        saveInquiry.GetQuestionGroup().add(questionGroup1);

        questionGroup.GetQuestions().add(question);
        question.SetQuestionGroupId(questionGroup);

        answer.SetQuestion(question);
        question.GetAnswerDTO().add(answer);

        try {
            inquiryService.save(saveInquiry);
        } catch (Exception e) {
            throw new SaveException("Nije moguće spasiti inquiry");
        }
        return ResponseEntity.ok(inquiry);
    }

    @GetMapping("/getAnswer")
    public List<Answer> getAnswer(@PathVariable int questionId) {
        List<Answer> answers = new ArrayList<Answer>();
        try {
            answers = inquiryService.getAnswer(10);
        } catch (Exception e) {
            throw new RequestException("Nije moguće dohvatit traženi inquiry");
        }
        return answers;
    }

    @GetMapping("/getInquiryById")
    public String getInquiryById() {
        try {
            return inquiryService.getInquiryById(19).toString();
        } catch (Exception e) {
            throw new RequestException("Ne postoji inquiry sa proslijedjenim id");
        }
    }
}