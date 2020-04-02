package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.Models.Question;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
    
}