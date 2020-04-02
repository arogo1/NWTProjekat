package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.Models.Inquiry;

import org.springframework.data.repository.CrudRepository;

public interface InquiryRepository extends CrudRepository<Inquiry, Integer> {
    //List<Inquiry> getInquiryByName(String InquiryName);
}