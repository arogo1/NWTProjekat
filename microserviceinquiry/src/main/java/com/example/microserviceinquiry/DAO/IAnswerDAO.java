package com.example.microserviceinquiry.DAO;

import java.util.List;

import com.example.microserviceinquiry.Models.Answer;

public interface IAnswerDAO {
    boolean save(Answer answer) throws Exception;

    List<Answer> findAnswer(int questionId) throws Exception;
}