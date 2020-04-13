package com.example.mikroservisquiz.repository;

import java.util.List;

import com.example.mikroservisquiz.models.Quiz;

import org.springframework.data.repository.CrudRepository;


public interface quizRepository extends CrudRepository<Quiz, Integer> {
    List<Quiz> findAll();
    Quiz findById(int id);
    //List<Quiz> findAllByResult(int result);

}