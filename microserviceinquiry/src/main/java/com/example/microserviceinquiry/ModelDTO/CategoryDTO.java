package com.example.microserviceinquiry.ModelDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private String categoryName;

    public CategoryDTO(){}

    public CategoryDTO(String CategoryName){
        categoryName = CategoryName;
    }

    public String GetCategoryName(){
        return categoryName;
    }
}