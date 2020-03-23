package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.ModelDTO.InquiryDTO;

import org.springframework.data.repository.CrudRepository;

public interface InquiryRepository extends CrudRepository<InquiryDTO, Integer> {

}