package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.ModelDTO.QuestionDTO;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<QuestionDTO, Integer> {
    
}