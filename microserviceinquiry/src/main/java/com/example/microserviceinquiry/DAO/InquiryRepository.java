package com.example.microserviceinquiry.DAO;

import java.util.List;

import com.example.microserviceinquiry.ModelDTO.InquiryDTO;

import org.springframework.data.repository.CrudRepository;

public interface InquiryRepository extends CrudRepository<InquiryDTO, Integer> {
    List<InquiryDTO> getInquiryByName(String InquiryName);
}