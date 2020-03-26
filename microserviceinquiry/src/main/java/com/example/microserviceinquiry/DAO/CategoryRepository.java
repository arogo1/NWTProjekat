package com.example.microserviceinquiry.DAO;

import com.example.microserviceinquiry.ModelDTO.CategoryDTO;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryDTO, Integer> {
    
}