package com.example.microserviceinquiry.DAO;

import java.util.List;

import com.example.microserviceinquiry.Models.Inquiry;

import org.springframework.data.repository.CrudRepository;

public interface InquiryRepository extends CrudRepository<Inquiry, Integer> {
    List<Inquiry> findByInquiryName(String InquiryName);

    List<Inquiry> findByCategoryId(int categoryId);

    List<Inquiry> findByUserId(int userId);
}