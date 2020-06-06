/*
package com.example.mikroservisquiz.Configuration;

import com.example.mikroservisquiz.servisi.quizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.lang.Integer.parseInt;

public class Consumer {

    @Autowired
    quizService service;

    @Autowired
    RestTemplate restTemplate;

    public void deleteDetails(String cs) {

        Integer inquiryID = parseInt(cs.split(",", 2)[0]);

        try {
            System.out.println("User ID = " + inquiryID);
            service.deleteQuiz(inquiryID);
        } catch (Exception e) {
            throw e;
        }
        restTemplate.delete("http://inquiry-service//deleteInquiryAndQuiz/" + inquiryID);
    }
}
*/
