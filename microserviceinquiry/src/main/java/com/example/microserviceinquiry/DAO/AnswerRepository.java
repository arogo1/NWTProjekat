package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.Models.Answer;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {
}