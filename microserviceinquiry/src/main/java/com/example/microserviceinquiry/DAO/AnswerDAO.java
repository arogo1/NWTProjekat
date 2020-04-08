package com.example.microserviceinquiry.DAO;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Answer> findAnswer(int questionId) throws Exception {
        List<Answer> answers = new ArrayList<Answer>();
        answers = (List<Answer>)answerRepository.findAll();
        System.out.println(answers.toArray()[0].toString());
        return answers;
    }

}