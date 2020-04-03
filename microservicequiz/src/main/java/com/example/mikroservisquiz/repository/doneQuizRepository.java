package com.example.mikroservisquiz.repository;

import com.example.mikroservisquiz.models.DoneQuiz;
import org.springframework.data.repository.CrudRepository;


public interface doneQuizRepository extends CrudRepository<DoneQuiz, Integer> {
}