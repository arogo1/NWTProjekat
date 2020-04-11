package com.example.microserviceinquiry.DAO;

import java.util.List;

import com.example.microserviceinquiry.Models.Inquiry;

public interface IInquiryDAO {
    boolean save(Inquiry inquiry) throws Exception;

    List<Inquiry> getInquiryByName(String InquiryId) throws Exception;

    List<Inquiry> getInquiryByCategory(int categoryId) throws Exception;

    Inquiry getInquiryById(int id) throws Exception;
}