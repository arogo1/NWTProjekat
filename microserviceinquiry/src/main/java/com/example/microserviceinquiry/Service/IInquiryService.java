package com.example.microserviceinquiry.Service;

import java.util.List;

import com.example.microserviceinquiry.Models.*;

public interface IInquiryService {
    boolean save(Inquiry inquiry) throws Exception;

    boolean saveQuestionGroup(QuestionGroup questionGroup) throws Exception;

    boolean saveQuestion(Question question) throws Exception;

    boolean saveAnswer(Answer answer) throws Exception;

    List<Answer> getAnswer(int questionId) throws Exception;
}