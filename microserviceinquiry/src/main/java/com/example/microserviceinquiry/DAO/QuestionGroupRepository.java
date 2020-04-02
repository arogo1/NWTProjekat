package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.Models.QuestionGroup;

import org.springframework.data.repository.CrudRepository;

public interface QuestionGroupRepository extends CrudRepository<QuestionGroup, Integer> {
    
}