package com.example.microserviceinquiry.DAO;

import java.util.List;

import com.example.microserviceinquiry.Models.Inquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InquiryDAO implements IInquiryDAO {

    @Autowired
    InquiryRepository inquiryRepository;

    @Override
    public boolean save(Inquiry inquiry) throws Exception {
        inquiryRepository.save(inquiry);
        return true;
    }

    @Override
    public List<Inquiry> getInquiryByName(String InquiryName) {
        //inquiryRepository.getInquiryByName(InquiryName;)
        return null;
    }

    @Override
    public List<InquiryDAO> getInquiryByCategory(int categoryId) throws Exception {
        inquiryRepository.findById(categoryId);
        return null;
    }

}