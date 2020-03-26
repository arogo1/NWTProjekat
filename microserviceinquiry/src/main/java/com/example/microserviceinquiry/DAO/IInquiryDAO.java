package com.example.microserviceinquiry.DAO;

import java.util.List;

import com.example.microserviceinquiry.ModelDTO.InquiryDTO;

public interface IInquiryDAO {
    boolean save(InquiryDTO inquiryDTO) throws Exception;

    List<InquiryDTO> getInquiryByName(String InquiryId) throws Exception;

    List<InquiryDAO> getInquiryByCategory(int categoryId) throws Exception;
}