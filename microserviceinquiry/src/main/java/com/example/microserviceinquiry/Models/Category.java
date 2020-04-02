package com.example.microserviceinquiry.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Category")
public class Category {

    @Id
    @GeneratedValue
    @Column(name="CategoryId")
    private int categoryId;

    //@NotEmpty
    @Size(min=3)
    @Column(name="CategoryName")
    private String categoryName;

    public Category(){}

    public Category(String CategoryName){
        categoryName = CategoryName;
    }

    public String GetCategoryName(){
        return categoryName;
    }

    public void SetCategoryName(String categoryName){
        this.categoryName = categoryName;
    }
}