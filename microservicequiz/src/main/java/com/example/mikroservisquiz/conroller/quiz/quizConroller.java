package com.example.mikroservisquiz.conroller.quiz;

import java.util.List;

import com.example.mikroservisquiz.conroller.quiz.exception.postException;
import com.example.mikroservisquiz.conroller.quiz.exception.quizNotFoundException;
import com.example.mikroservisquiz.models.Quiz;
import com.example.mikroservisquiz.servisi.quizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class quizConroller{

    @Autowired
    private quizService service;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/quizes")
    public List<Quiz>getQuizes(){
        return service.getAllQuizes();
    }

    @GetMapping("/quiz/{id}")
    public Quiz findById(@PathVariable("id") int id){
        try{
            Quiz quiz = service.getById(id);
            if(quiz == null) {throw new quizNotFoundException(id);}
            return quiz;
        }catch(Exception ex){
            throw new quizNotFoundException(id);
        }
    }
    // @GetMapping("/quizByResult/{result}")
    // public List<Quiz> findByResult(@PathVariable("result") int result){
    //     try{
    //         return service.getAllByResult(result);
    //     }catch(Exception ex){
    //         throw new quizNotFoundException(result);
    //     }
    // }

    @PostMapping("/createQuiz/{inquiryId}")
    public String newQuiz(@PathVariable int inquiryId) {
        int inquirId = restTemplate.getForObject("http://inquiry-service/getInquiryId/" + inquiryId, int.class);
        int numberOfQuestion = restTemplate.getForObject("http://inquiry-service/getNumberOfQuestion/" + inquiryId, int.class);
        // newQuiz.SetInquiryId(inquirId);
        // newQuiz.SetNumOfAns(numberOfQuestion);
        Quiz newQuiz = new Quiz(inquirId, 0, numberOfQuestion); //na početku kreiranja kviza rezultat bi trebao biti postavljen na nula
        try{
            service.addQuiz(newQuiz);
        }
        catch(Exception e){
            throw new postException("Ne može proći validacija");
        }
        
        return "Uspješno dodan.";
    }
    
    @DeleteMapping("/deleteQuiz/{id}")
    public String deleteQuiz(@PathVariable int id) { 
        try{
            service.deleteQuiz(id);
            return "Uspješno obrisan.";
        }catch(Exception ex){
            throw new postException("Nije moguće izvršiti ovu operaciju.");
        }
    }

    // @PutMapping("/quiz/{id}")
    // public Quiz updateQuiz(@RequestBody Quiz newquiz, @PathVariable("id") int id) {
    //     return service.editQuiz(newquiz, id);
    // }
     
}