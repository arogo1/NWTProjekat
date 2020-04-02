package com.example.microserviceinquiry.Service;

import com.example.microserviceinquiry.DAO.IAnswerDAO;
import com.example.microserviceinquiry.DAO.IInquiryDAO;
import com.example.microserviceinquiry.DAO.IQuestionDAO;
import com.example.microserviceinquiry.DAO.IQuestionGroupDAO;
import com.example.microserviceinquiry.Models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InquiryService implements IInquiryService {

    @Autowired
    IInquiryDAO inquiryDAO;

    @Autowired
    IQuestionDAO questionDAO;

    @Autowired
    IQuestionGroupDAO questionGroupDAO;

    @Autowired
    IAnswerDAO answerDAO;

    @Override
    public boolean save(Inquiry inquiry) throws Exception {
        inquiryDAO.save(inquiry);
        return false;
    }

    @Override
    public boolean saveQuestionGroup(QuestionGroup questionGroup) throws Exception {
        questionGroupDAO.save(questionGroup);
        return false;
    }

    @Override
    public boolean saveQuestion(Question question) throws Exception {
        questionDAO.save(question);
        return false;
    }

    @Override
    public boolean saveAnswer(Answer answer) throws Exception {
        answerDAO.save(answer);
        return false;
    }

}