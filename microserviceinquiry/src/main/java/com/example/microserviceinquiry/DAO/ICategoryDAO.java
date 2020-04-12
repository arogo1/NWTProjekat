package com.example.microserviceinquiry.DAO;

import java.util.List;

import com.example.microserviceinquiry.Models.Category;

public interface ICategoryDAO {
    List<Category> getCategories() throws Exception;
}