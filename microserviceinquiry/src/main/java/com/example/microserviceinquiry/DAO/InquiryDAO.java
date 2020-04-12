package com.example.microserviceinquiry.DAO;

import java.util.ArrayList;
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
    public List<Inquiry> getInquiryByName(String inquiryName) {
        List<Inquiry> inquirys = new ArrayList<Inquiry>();
        Iterable<Inquiry> response = inquiryRepository.findByInquiryName(inquiryName);
        response.forEach(inquirys::add);
        return inquirys;
    }


    @Override
    public Inquiry getInquiryById(int id) throws Exception {
        Inquiry inquiry = inquiryRepository.findById(id).get();
        return inquiry;
    }

    @Override
    public List<Inquiry> getInquiryByCategoryId(int categoryId) throws Exception{
        List<Inquiry> inquirys = new ArrayList<Inquiry>();
        Iterable<Inquiry> response = inquiryRepository.findByCategoryId(categoryId);
        response.forEach(inquirys::add);
        return inquirys;
    }

    @Override
    public List<Inquiry> getInquiryByUserId(int userId) throws Exception{
        List<Inquiry> inquirys = new ArrayList<Inquiry>();
        Iterable<Inquiry> response = inquiryRepository.findByUserId(userId);
        response.forEach(inquirys::add);
        return inquirys;
    }
}