package com.example.microserviceinquiry.Configuration;

import com.example.microserviceinquiry.Models.Inquiry;
import com.example.microserviceinquiry.Service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.lang.Integer.parseInt;

public class Consumer {
    @Autowired
    InquiryService Service;

    @Autowired
    RestTemplate restTemplate;


}
