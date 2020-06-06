package com.example.microserviceinquiry.DAO;

import java.util.List;

import com.example.microserviceinquiry.Models.Inquiry;

public interface IInquiryDAO {
    boolean save(Inquiry inquiry) throws Exception;

    List<Inquiry> getInquiryByName(String inquiryNmame) throws Exception;

    Inquiry getInquiryById(int id) throws Exception;

    List<Inquiry> getInquiryByCategoryId(int categoryId) throws Exception;

    List<Inquiry> getInquiryByUserId(int userId) throws Exception;

    void deleteUserInquirs(List<Inquiry>inquiries) throws Exception;

    void deleteInquiry(Inquiry inquiry) throws  Exception;
}