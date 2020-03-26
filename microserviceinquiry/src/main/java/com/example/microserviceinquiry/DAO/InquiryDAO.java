package com.example.microserviceinquiry.DAO;

import java.util.List;

import com.example.microserviceinquiry.ModelDTO.InquiryDTO;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class InquiryDAO implements IInquiryDAO {

    @Autowired
    InquiryRepository inquiryRepository;

    @Override
    public boolean save(InquiryDTO inquiryDTO) throws Exception {
        inquiryRepository.save(inquiryDTO);
        return true;
    }

    @Override
    public List<InquiryDTO> getInquiryByName(String InquiryName) {
        //inquiryRepository.getInquiryByName(InquiryName;)
        return null;
    }

    @Override
    public List<InquiryDAO> getInquiryByCategory(int categoryId) throws Exception {
        inquiryRepository.findById(categoryId);
        return null;
    }

}