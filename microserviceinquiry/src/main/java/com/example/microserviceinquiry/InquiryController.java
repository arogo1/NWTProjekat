package com.example.microserviceinquiry;

import java.util.ArrayList;
import java.util.List;

import com.example.microserviceinquiry.Exception.SaveException;
import com.example.microserviceinquiry.Exception.RequestException;
import com.example.microserviceinquiry.Models.*;
import com.example.microserviceinquiry.Service.IInquiryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InquiryController {

    @Autowired
    private IInquiryService inquiryService;

    @GetMapping("/")
    public @ResponseBody String nesto() {
        return "Usao sam";
    }

    @PostMapping("/saveInquiry")
    public String saveInquiry(@RequestBody Inquiry inquiry) {
        QuestionGroup questionGroup = new QuestionGroup();
        Question question = new Question();
        Answer answer = new Answer();
        inquiry.setCategoryId(1);
        inquiry.setInquiryName("Proba");
        inquiry.setUserId(2);
        inquiry.setNumberOfQuestionGroup(2);

        try {
            inquiryService.save(inquiry);
        } catch (Exception e) {
            throw new SaveException("Nije moguće spasiti inquiry");
        }

        questionGroup.SetQuestionGroupName("Grupa");
        questionGroup.SetNumberOfQuestion(4);
        questionGroup.SetInquiry(inquiry);
        try {
            inquiryService.saveQuestionGroup(questionGroup);
        } catch (Exception e) {
            throw new SaveException("Nije moguće spasiti question group");
        }

        question.SetQuestion("Pitanje");
        question.SetQuestionGroupId(questionGroup);

        try {
            inquiryService.saveQuestion(question);
        } catch (Exception e) {
            throw new SaveException("Nije moguće spasiti question");
        }

        answer.SetAnswer("Odgovor");
        answer.SetIsCorrect(true);
        answer.SetQuestion(question);
        try {
            inquiryService.saveAnswer(answer);
        } catch (Exception e) {
            throw new SaveException("Nije moguće spasiti answer");
        }

        return "Prosoo";
    }

    @GetMapping("/getAnswer")
    public List<Answer> getAnswer(@PathVariable int questionId) {
        List<Answer> answers = new ArrayList<Answer>();
        try {
            answers = inquiryService.getAnswer(10);
        } catch (Exception e) {
            throw new RequestException("Nije moguće dohvatit traženi inquiry");
        }
        return answers;
    }
}