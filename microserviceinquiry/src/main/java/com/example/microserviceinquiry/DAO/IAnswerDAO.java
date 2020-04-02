package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.Models.Answer;

public interface IAnswerDAO {
    boolean save(Answer answer) throws Exception;
}