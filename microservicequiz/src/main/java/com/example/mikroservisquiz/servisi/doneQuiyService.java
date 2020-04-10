package com.example.mikroservisquiz.servisi;

import java.util.Optional;

import com.example.mikroservisquiz.models.DoneQuiz;
import com.example.mikroservisquiz.repository.doneQuizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class doneQuiyService implements IDoneQuizService {
    @Autowired
    doneQuizRepository repository;

    public Iterable<DoneQuiz>getAllDneQuizes(){
        return repository.findAll();
    }

    public Optional<DoneQuiz> getDoneQuizById(Integer id){
        return repository.findById(id);
    }

    public void addDoneQuiz(DoneQuiz newDoneQuiz){
        repository.save(newDoneQuiz);
    }

    public void deleteDoneQuiz(Integer id){
        repository.deleteById(id);
    }

    public DoneQuiz editDoneQuiz(DoneQuiz newDoneQuiz,Integer id){
        return repository.findById(id).map(
            quiz->{
                quiz.setUserId(newDoneQuiz.getUserId());
                return repository.save(quiz);
            }).orElseGet(()-> repository.save(newDoneQuiz));
    }
}