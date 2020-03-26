package com.example.mikroservisquiz.repository;

import com.example.mikroservisquiz.models.Quiz;

import org.springframework.data.repository.CrudRepository;


public interface quizRepository extends CrudRepository<Quiz, Integer> {
}