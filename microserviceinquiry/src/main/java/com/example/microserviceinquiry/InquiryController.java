package com.example.microserviceinquiry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import com.example.microserviceinquiry.Exception.SaveException;
//import com.example.microserviceinquiry.Grpc.GrpcInquiryServiceClient;
import com.example.microserviceinquiry.Exception.RequestException;
import com.example.microserviceinquiry.Models.*;
import com.example.microserviceinquiry.Service.IInquiryService;
import com.example.microserviceinquiry.Service.ProducerService;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
public class InquiryController {

    @Autowired
    private IInquiryService inquiryService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    ProducerService producerService;

    // @Autowired
    // GrpcInquiryServiceClient client;

    @GetMapping("/nesto")
    public String nesto() {
        return "Usao sam";
    }

    @PostMapping("/saveInquiry")
    public ResponseEntity<Inquiry> saveInquiry(@RequestBody Inquiry inquiry) {
        int userId = restTemplate.getForObject("http://user-microservice//user-microservice/getLogedUser", int.class);
        inquiry.SetUserId(userId);
        // int userId = 2;
        // Inquiry saveInquiry = new Inquiry();// Hardcode podaci
        // saveInquiry.SetCategoryId(3);
        // saveInquiry.SetInquiryName("Test");
        // saveInquiry.SetNumberOfQuestionGroup(4);
        // saveInquiry.SetUserId(3);
        // QuestionGroup questionGroup = new QuestionGroup("Grupa2", 5);
        // QuestionGroup questionGroup1 = new QuestionGroup("Grupa3", 5);
        // questionGroup.SetInquiry(saveInquiry);
        // questionGroup1.SetInquiry(saveInquiry);
        // List<QuestionGroup> lista = new ArrayList<QuestionGroup>();
        // lista.add(questionGroup);
        // Question question = new Question("Pitanje");
        // Answer answer = new Answer("Odgovor", true);

        // saveInquiry.GetQuestionGroup().add(questionGroup);
        // saveInquiry.GetQuestionGroup().add(questionGroup1);

        // questionGroup.GetQuestions().add(question);
        // question.SetQuestionGroupId(questionGroup);

        // answer.SetQuestion(question);
        // question.GetAnswerDTO().add(answer);

        try {
            inquiryService.save(inquiry);
            producerService.send(userId);
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
            Inquiry response = inquiryService.getInquiryById(id);
            if(response == null) {
                throw new RequestException("Ne postoji Inquiry sa proslijedjenim Id");
            }
            else {
                return response;
            }
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

    @RequestMapping(value="/getCategories", method=RequestMethod.GET)
    @ResponseBody
    public List<Category> getCatergories() {
        try {
            List<Category> response = inquiryService.getCategories();
            if(response == null) {
                throw new RequestException("Ne postoje kategorije");
            }
            else {
                return response;
            }
        } catch (Exception e) {
            throw new RequestException("Nije moguce izvrsiti pretragu, pokusajte ponovo");
        }
    }

    @GetMapping("/getInquiryByCategory/{categoryId}")
    public List<Inquiry> getInquiryByCategoryId(@PathVariable int categoryId) {
        try {
            List<Inquiry> response = inquiryService.getInquiryByCategoryId(categoryId);
            if(response == null) {
                throw new RequestException("Ne postoji Inquiry sa proslijedjenom kategorijom");
            }
            else {
                return response;
            }
        } catch (Exception e) {
            throw new RequestException("Nije moguce izvrsiti pretragu, pokusajte ponovo");
        }
    }

    @GetMapping("/getInquiryByName/{inquiryName}")
    public List<Inquiry> getInquiryByNmae(@PathVariable String inquiryName) {
        try {
            List<Inquiry> response = inquiryService.getInquiryByName(inquiryName);
            if(response == null) {
                throw new RequestException("Ne postoji Inquiry sa proslijedjenim imenom");
            }
            else {
                return response;
            }
        } catch (Exception e) {
            throw new RequestException("Nije moguce izvrsiti pretragu, pokusajte ponovo");
        }
    }

    @GetMapping("/getInquiryByUserId/{userId}")
    public List<Inquiry> getInquiryByUserId(@PathVariable int userId) {
        try {
            List<Inquiry> response = inquiryService.getInquiryByUserId(userId);
            if(response == null) {
                throw new RequestException("Ne postoji Inquiry sa proslijedjenom user id");
            }
            else {
                return response;
            }
        } catch (Exception e) {
            throw new RequestException("Nije moguce izvrsiti pretragu, pokusajte ponovo");
        }
    }

    @GetMapping("/getNumberOfQuestion/{inquiryId}")
    public int getNumberOfQuestion(@PathVariable int inquiryId) {
        try {
            return inquiryService.getInquiryById(inquiryId).GetNumberOfQuestion();
        } catch (Exception e) {
            throw new RequestException("Nije moguce izvrsiti pretragu, pokusajte ponovo");
        }
    }

    @DeleteMapping("/deleteAllUserInquiry/{userId}")
    public void deleteAllUserInquiry(@PathVariable int userId){
        try {
            List<Inquiry> inquirys = getInquiryByUserId(userId);
            if(inquirys.size() > 0 && inquirys != null) inquiryService.deleteUserInquirys(inquirys);
        } catch (Exception e){
            throw new RequestException("Nije moguce izvrsiti brisanje, pokusajte ponovo");
        }
    }

    @DeleteMapping("/deleteInquiryAndQuiz/{userId}")
    public void deleteInquiryAndQuiz(@PathVariable int id){
        try {
            Inquiry inquiry = getInquiryById(id);
            if(inquiry != null) inquiryService.deleteInquiry(inquiry);
        } catch (Exception e){
            throw new RequestException("Nije moguce izvrsiti brisanje, pokusajte ponovo");
        }
    }
}