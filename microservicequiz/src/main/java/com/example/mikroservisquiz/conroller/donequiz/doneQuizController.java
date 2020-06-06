package com.example.mikroservisquiz.conroller.donequiz;

import java.util.List;

import com.example.mikroservisquiz.conroller.donequiz.exception.doneQuizNotFoundException;
import com.example.mikroservisquiz.conroller.quiz.exception.postException;
import com.example.mikroservisquiz.models.DoneQuiz;
import com.example.mikroservisquiz.servisi.doneQuiyService;
import com.example.mikroservisquiz.servisi.quizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

 @RestController
 public class doneQuizController{

     @Autowired
     doneQuiyService service;

     @Autowired
     private RestTemplate restTemplate;

     @GetMapping("/doneQuizes")
     public List<DoneQuiz>getQuizes(){
         return service.getAllDoneQuizes();
     }

     @GetMapping("/doneQuiz/{id}")
     public DoneQuiz findById(@PathVariable("id") int id){
         try{
             DoneQuiz doneQuiz = service.getDoneQuizById(id);
             if(doneQuiz==null) {throw new doneQuizNotFoundException(id);}
            return doneQuiz;
         }catch(Exception ex){
             throw new doneQuizNotFoundException(id);
         }
     }

     @GetMapping("/getdoneQuizByUserId/{userId}")
    public List<DoneQuiz> getdoneQuizByUserId(@PathVariable("userId") int userId) {
        try{
            return service.getdoneQuizByUserId(userId);
         }catch(Exception ex){
             throw new doneQuizNotFoundException(userId);
        }
    }

    //Možda će mi ova metoda trebati u budućnosti, ali sad za sad mi ne treba
    // @GetMapping("/getdoneQuizByQuizId/{quizId}")
    // public DoneQuiz getdoneQuizByQuizId(@PathVariable("quizId") int quizId) {
    //     try{
    //         return service.getdoneQuizByQuizId(quizId);
    //      }catch(Exception ex){
    //          throw new doneQuizNotFoundException(quizId);
    //      }
    // }

     @PostMapping("/createDoneQuiz/{quizId}")
     public String newQuiz(@PathVariable int quizId) {
        int userid = restTemplate.getForObject("http://user-microservice//user-microservice/getLogedUser", int.class);
        DoneQuiz newDoneQuiz = new DoneQuiz(userid, quizId);
         try{
            service.addDoneQuiz(newDoneQuiz);
            return "Uspješno dodan.";
         }catch(Exception ex){
             throw new postException("Došlo je do greške.");
         }
          
     }
    
     @DeleteMapping("/deleteDoneQuiz/{id}")
     public String deleteQuiz(@PathVariable("id") int id){ 
         try{
            service.deleteDoneQuiz(id);
            return "Uspješno obrisan.";
         }catch(Exception ex){
             throw new doneQuizNotFoundException(id);
         }
     }

 }