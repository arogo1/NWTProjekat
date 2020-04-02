package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.Models.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnswerDAO implements IAnswerDAO {

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public boolean save(Answer answer) throws Exception {
        answerRepository.save(answer);
        return false;
    }

}