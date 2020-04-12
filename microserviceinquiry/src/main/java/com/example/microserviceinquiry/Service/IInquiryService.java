package com.example.microserviceinquiry.Service;

import java.util.List;

import com.example.microserviceinquiry.Models.*;

public interface IInquiryService {
    boolean save(Inquiry inquiry) throws Exception;

    Inquiry getInquiryById(int id) throws Exception;

    List<Category> getCategories() throws Exception;

    List<Inquiry> getInquiryByCategoryId(int categoryId) throws Exception;

    List<Inquiry> getInquiryByName(String inquiryName) throws Exception;

    List<Inquiry> getInquiryByUserId(int userId) throws Exception;
}