package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.Models.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    
}