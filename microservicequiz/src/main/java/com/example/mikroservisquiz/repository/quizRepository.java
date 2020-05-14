package com.example.mikroservisquiz.repository;

import java.util.List;

import com.example.mikroservisquiz.models.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface quizRepository extends JpaRepository<Quiz, Integer> {
    List<Quiz> findAll();
    Quiz findById(int id);
    //List<Quiz> findAllByResult(int result);

}