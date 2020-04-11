package com.example.mikroservisquiz.conroller.donequiz;

import com.example.mikroservisquiz.conroller.donequiz.exception.doneQuizNotFoundException;


 import com.example.mikroservisquiz.models.DoneQuiz;
import com.example.mikroservisquiz.servisi.IDoneQuizService;
import com.example.mikroservisquiz.servisi.doneQuiyService;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.DeleteMapping;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.PutMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RestController;

 @RestController
 public class doneQuizController{

     @Autowired
     IDoneQuizService service;

     @GetMapping("/doneQuizes")
     public Iterable<DoneQuiz>getQuizes(){
         return service.getAllDneQuizes();
     }

     @GetMapping("/doneQuiz/{id}")
     public DoneQuiz findById(@PathVariable("id") Integer id){
         return service.getDoneQuizById(id).orElseThrow(() -> new doneQuizNotFoundException(id));
     }

     @PostMapping("/doneQuiz")
     public void newQuiz(DoneQuiz newDoneQuiz) {
          service.addDoneQuiz(newDoneQuiz);
     }
    
     @DeleteMapping("/doneQuiz/{id}")
     public void deleteQuiz(@PathVariable Integer id){ 
         service.deleteDoneQuiz(id); 
     }

    //  @PutMapping("/quiz/{id}")
    //  public DoneQuiz updateDoneQuiz(@RequestBody DoneQuiz newDoneQuiz, @PathVariable("id") Integer id) {
    //      return service.editDoneQuiz(newDoneQuiz, id);
    //  }
 }