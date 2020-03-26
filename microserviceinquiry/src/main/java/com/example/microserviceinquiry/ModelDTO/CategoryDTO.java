package com.example.microserviceinquiry.ModelDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="categorydto")
public class CategoryDTO {

    @Id
    @GeneratedValue
    @Column(name="category_id")
    private int categoryId;

    @NotEmpty
    @Size(min=3)
    @Column(name="category_name")
    private String categoryName;

    public CategoryDTO(){}

    public CategoryDTO(String CategoryName){
        categoryName = CategoryName;
    }

    public String GetCategoryName(){
        return categoryName;
    }

    public void SetCategoryName(String categoryName){
        this.categoryName = categoryName;
    }
}