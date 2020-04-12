package com.example.microserviceinquiry;

import java.util.ArrayList;
import java.util.List;

import com.example.microserviceinquiry.Exception.SaveException;
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
        // int userId = restTemplate.getForObject("Http://user-microservice/getUser", int.class);
        //inquiry.setUserId(userId);
        Inquiry saveInquiry = new Inquiry();// Hardcode podaci
        saveInquiry.SetCategoryId(3);
        saveInquiry.SetInquiryName("Test");
        saveInquiry.SetNumberOfQuestionGroup(4);
        saveInquiry.SetUserId(3);
        QuestionGroup questionGroup = new QuestionGroup("Grupa2", 5);
        QuestionGroup questionGroup1 = new QuestionGroup("Grupa3", 5);
        questionGroup.SetInquiry(saveInquiry);
        questionGroup1.SetInquiry(saveInquiry);
        List<QuestionGroup> lista = new ArrayList<QuestionGroup>();
        lista.add(questionGroup);
        Question question = new Question("Pitanje");
        Answer answer = new Answer("Odgovor", true);

        saveInquiry.GetQuestionGroup().add(questionGroup);
        saveInquiry.GetQuestionGroup().add(questionGroup1);

        questionGroup.GetQuestions().add(question);
        question.SetQuestionGroupId(questionGroup);

        answer.SetQuestion(question);
        question.GetAnswerDTO().add(answer);

        try {
            inquiryService.save(saveInquiry);
            // Metodi save ce se proslijediti parametar inquiry,
            // na frontendu je zamisljeno da se podatak pripremi backendu
            // inquiryService.save(inquiry);

        } catch (Exception e) {
            throw new SaveException("Nije moguće spasiti inquiry");
        }
        return ResponseEntity.ok(inquiry);
    }

    @GetMapping("/getInquiryById/{id}")
    public Inquiry getInquiryById(@PathVariable int id) {
        try {
            return inquiryService.getInquiryById(id);
        } catch (Exception e) {
            throw new RequestException("Nije moguce izvrsiti pretragu, pokusajte ponovo");
        }
    }

    @GetMapping("/getInquiryId/{id}")
    public int getInquiryId(@PathVariable int id) {
        try {
            return inquiryService.getInquiryById(id).GetInquiryId();
        } catch (Exception e) {
            throw new RequestException("Nije moguce izvrsiti pretragu, pokusajte ponovo");
        }
    }

    @GetMapping("/getCategories")
    public List<Category> getCatergories() {
        try {
            return inquiryService.getCategories();
        } catch (Exception e) {
            throw new RequestException("Nije moguce izvrsiti pretragu, pokusajte ponovo");
        }
    }

    @GetMapping("/getInquiryByCategory/{categoryId}")
    public List<Inquiry> getInquiryByCategoryId(@PathVariable int categoryId) {
        try {
            return inquiryService.getInquiryByCategoryId(categoryId);
        } catch (Exception e) {
            throw new RequestException("Nije moguce izvrsiti pretragu, pokusajte ponovo");
        }
    }

    @GetMapping("/getInquiryByName/{inquiryName}")
    public List<Inquiry> getInquiryByCategoryId(@PathVariable String inquiryName) {
        try {
            return inquiryService.getInquiryByName(inquiryName);
        } catch (Exception e) {
            throw new RequestException("Nije moguce izvrsiti pretragu, pokusajte ponovo");
        }
    }

    @GetMapping("/getInquiryByUserId/{userId}")
    public List<Inquiry> getInquiryByUserId(@PathVariable int userId) {
        try {
            return inquiryService.getInquiryByUserId(userId);
        } catch (Exception e) {
            throw new RequestException("Nije moguce izvrsiti pretragu, pokusajte ponovo");
        }
    }
}