package com.example.mikroservisquiz.servisi;

import java.util.List;

import com.example.mikroservisquiz.models.Quiz;
import com.example.mikroservisquiz.repository.quizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class quizService {
   
    @Autowired
    private quizRepository repository;

    public List<Quiz> getAllQuizes(){
        return repository.findAll();
    }

    public Quiz getById(int id){
        return repository.findById(id);
    }

    // public List<Quiz> getAllByResult(int result){
    //     return repository.(result);
    // }

    public void addQuiz(Quiz quiz){
        repository.save(quiz);
    }

    public void deleteQuiz(int id){
        repository.deleteById(id);
    }

    // public Quiz editQuiz(Quiz newquiz, int id){
    //     return repository.findById(id).map(
    //         quiz->{
    //             quiz.SetInquiryId(newquiz.getId());
    //             quiz.SetResult(newquiz.getResul());
    //             quiz.SetNumOfAns(newquiz.getNumberOfAnswers());
    //             return repository.save(quiz);
    //         }).orElseGet(()-> repository.save(newquiz));
    // }
}
