package com.example.mikroservisquiz.repository;

import java.util.List;

import com.example.mikroservisquiz.models.DoneQuiz;
import org.springframework.data.repository.CrudRepository;


public interface doneQuizRepository extends CrudRepository<DoneQuiz, Integer> {
    List<DoneQuiz> findAll();
    //DoneQuiz findById(int id);
    //List<DoneQuiz> findByUserId(int userid);
}