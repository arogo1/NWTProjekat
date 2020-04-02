package com.example.microserviceinquiry.DAO;

import java.util.List;

import com.example.microserviceinquiry.Models.Inquiry;

public interface IInquiryDAO {
    boolean save(Inquiry inquiry) throws Exception;

    List<Inquiry> getInquiryByName(String InquiryId) throws Exception;

    List<InquiryDAO> getInquiryByCategory(int categoryId) throws Exception;
}