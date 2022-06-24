package com.example.recipe2.models.dto;

import com.example.recipe2.models.entity.CategoryModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CategoryWithFetch_RecipeDTO {

    private int id;
    private String category;
    private List<RecipeDTO> recipe = new ArrayList<>();

    public CategoryWithFetch_RecipeDTO(CategoryModel categoryModel) {
        this.id = categoryModel.getId();
        this.category = categoryModel.getCategory();
        this.recipe = categoryModel.getRecipe()
                .stream()
                .map(RecipeDTO::new)
                .collect(Collectors.toList());
    }
}
