package com.example.recipe2.models.dto;

import com.example.recipe2.models.entity.RecipeModel;
import lombok.Data;

@Data
public class RecipeDTO {
    private int id;
    private String image;
    private String title;
    private String description;

    public RecipeDTO(RecipeModel recipe) {
        this.id = recipe.getId();
        this.image = recipe.getImage();
        this.title = recipe.getTitle();
        this.description = recipe.getDescription();
    }
}
