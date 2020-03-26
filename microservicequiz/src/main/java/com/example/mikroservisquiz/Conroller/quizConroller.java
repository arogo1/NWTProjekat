package com.example.mikroservisquiz.Conroller;

import java.util.List;
import java.util.Optional;

import com.example.mikroservisquiz.models.Quiz;
import com.example.mikroservisquiz.repository.quizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class quizConroller{

    @Autowired
    quizRepository repo;

    @GetMapping("/nesto")
    public String getnesto(){
        return "blabla";
    }

    @GetMapping("/quizes")
    public Iterable<Quiz>getQuizes(){
        return repo.findAll();
    }

    @GetMapping("/quiz/{id}")
    public Optional<Quiz> findById(@PathVariable("id") Integer id){
        return repo.findById(id);
    }

    @PostMapping("/quiz")
    public Quiz newQuiz(Quiz newQuiz) {
        return repo.save(newQuiz);
    }
    
    @DeleteMapping("/quiz/{id}")
    public void deleteQuiz(@PathVariable Integer id){ repo.deleteById(id); }

    @PutMapping("/quiz/{id}")
    public Quiz updateQuiz(@RequestBody Quiz newData, @PathVariable("id") Integer id) {
        return repo.findById(id)
                    .map(quiz -> {
                        quiz.SetInquiryId(newData.getInquiryID());
                        quiz.SetResult(newData.getResul());
                        quiz.SetNumOfAns(newData.getNumberOfAnswers());
                    System.out.println(quiz.toString());
                    return repo.save(quiz);
                }).orElseGet(() -> repo.save(newData));
    }
}