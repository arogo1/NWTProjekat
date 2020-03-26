package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.ModelDTO.QuestionGroupDTO;

import org.springframework.data.repository.CrudRepository;

public interface QuestionGroupRepository extends CrudRepository<QuestionGroupDTO, Integer> {
    
}