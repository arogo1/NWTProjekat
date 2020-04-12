package com.example.microserviceinquiry.DAO;

import java.util.ArrayList;
import java.util.List;

import com.example.microserviceinquiry.Models.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryDAO implements ICategoryDAO {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() throws Exception {
        List<Category> categories = new ArrayList<Category>();
        Iterable<Category> response = categoryRepository.findAll();
        response.forEach(categories::add);
        return categories;
    }

}