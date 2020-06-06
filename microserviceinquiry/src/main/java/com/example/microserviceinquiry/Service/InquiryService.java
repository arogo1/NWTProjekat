package com.example.microserviceinquiry.Service;

import java.util.List;

import com.example.microserviceinquiry.DAO.ICategoryDAO;
import com.example.microserviceinquiry.DAO.IInquiryDAO;
import com.example.microserviceinquiry.Models.Category;
import com.example.microserviceinquiry.Models.Inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InquiryService implements IInquiryService {

    @Autowired
    IInquiryDAO inquiryDAO;

    @Autowired
    ICategoryDAO categoryDAO;

    @Override
    public boolean save(final Inquiry inquiry) throws Exception {
        inquiryDAO.save(inquiry);
        return false;
    }

    @Override
    public Inquiry getInquiryById(final int id) throws Exception {
        return inquiryDAO.getInquiryById(id);
    }

    @Override
    public List<Category> getCategories() throws Exception {
        return categoryDAO.getCategories();
    }

    @Override
    public List<Inquiry> getInquiryByCategoryId(int categoryId) throws Exception{
        return inquiryDAO.getInquiryByCategoryId(categoryId);
    }

    @Override
    public List<Inquiry> getInquiryByName(String inquiryName) throws Exception{
        return inquiryDAO.getInquiryByName(inquiryName);
    }

    @Override
    public List<Inquiry> getInquiryByUserId(int userId) throws Exception{
        return inquiryDAO.getInquiryByUserId(userId);
    }

    @Override
    public void deleteUserInquirys(List<Inquiry> inquirys) throws Exception {
        inquiryDAO.deleteUserInquirs(inquirys);
    }

    @Override
    public void deleteInquiry(Inquiry inquiry) throws Exception {
        inquiryDAO.deleteInquiry(inquiry);
    }


}