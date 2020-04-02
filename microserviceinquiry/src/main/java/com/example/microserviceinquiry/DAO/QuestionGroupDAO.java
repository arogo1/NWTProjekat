package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.Models.QuestionGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionGroupDAO implements IQuestionGroupDAO {

    @Autowired
    QuestionGroupRepository questionGroupRepository;

    @Override
    public boolean save(QuestionGroup questionGroup) throws Exception {
        questionGroupRepository.save(questionGroup);
        return false;
    }

}