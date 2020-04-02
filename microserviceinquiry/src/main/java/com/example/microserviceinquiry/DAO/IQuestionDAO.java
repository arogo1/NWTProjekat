package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.Models.Question;

public interface IQuestionDAO {
    boolean save(Question question) throws Exception;
}