package com.example.recipe2.models.dto;

import com.example.recipe2.models.entity.CategoryModel;
import lombok.Data;

@Data
public class CategoryDTO {

    private int id;
    private String category;

    public CategoryDTO(CategoryModel category) {
        this.id = category.getId();
        this.category = category.getCategory();
    }

//    public CategoryDTO(String category) {
//        this.category = category;
//    }
}
