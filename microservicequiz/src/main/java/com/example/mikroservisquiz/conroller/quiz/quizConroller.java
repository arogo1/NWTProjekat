package com.example.mikroservisquiz.conroller.quiz;

import java.util.List;

//import com.example.mikroservisquiz.Configuration.Consumer;
import com.example.mikroservisquiz.conroller.quiz.exception.postException;
import com.example.mikroservisquiz.conroller.quiz.exception.quizNotFoundException;
import com.example.mikroservisquiz.models.Quiz;
import com.example.mikroservisquiz.servisi.quizService;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping()
public class quizConroller{

    @Autowired
    private quizService service;

    @Autowired
    private RestTemplate restTemplate;

/*
    @Autowired
    private Consumer consumer;
*/




//    @Autowired
//    ProducerService producer;

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

    @PostMapping("/createQuiz/{inquiryId}")
    public String newQuiz(@PathVariable int inquiryId) {
        int inquirId = restTemplate.getForObject("http://inquiry-service/getInquiryId/" + inquiryId, int.class);
        int numberOfQuestion = restTemplate.getForObject("http://inquiry-service/getNumberOfQuestion/" + inquiryId, int.class);
        // newQuiz.SetInquiryId(inquirId);
        // newQuiz.SetNumOfAns(numberOfQuestion);
        Quiz newQuiz = new Quiz(inquirId, 0, numberOfQuestion); //na početku kreiranja kviza rezultat bi trebao biti postavljen na nula
        try{
            //poziva se rabbit i ovako
//            service.addQuiz(newQuiz);
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
    @DeleteMapping("/user/{id}")
    public void deleleQuizByInquiryId(@PathVariable Integer id)
    {
        Quiz quiz = service.getById(id);

        if(quiz == null){
            throw new InternalException("There is NO user with id: " + id + " in database.");
        }

        restTemplate.getForObject("http://inquiry-service//deleteInquiryAndQuiz/" + id.toString(), void.class);

    }

    // @PutMapping("/quiz/{id}")
    // public Quiz updateQuiz(@RequestBody Quiz newquiz, @PathVariable("id") int id) {
    //     return service.editQuiz(newquiz, id);
    // }
     
}