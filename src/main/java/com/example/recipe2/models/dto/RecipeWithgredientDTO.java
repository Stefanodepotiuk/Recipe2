package com.example.recipe2.models.dto;

import com.example.recipe2.models.entity.RecipeModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class RecipeWithgredientDTO {

    private int id;
    private String title;
    private String description;
    private List<CategoryDTO> category = new ArrayList<>();
    private int rating;
    private List<IngredientDTO> ingredients = new ArrayList<>();

    public RecipeWithgredientDTO(RecipeModel recipe) {
        this.id = recipe.getId();
        this.title = recipe.getTitle();
        this.description = recipe.getDescription();
        this.rating = recipe.getRating();
        this.ingredients = recipe.getIngredientQuantities()
                .stream()
                .map(item -> new IngredientDTO(item.getIngredient(), item.getQuantity()))
                .collect(Collectors.toList());
    }


    public RecipeWithgredientDTO(RecipeModel recipe, List<CategoryDTO> categoryDTOS) {
        this.id = recipe.getId();
        this.title = recipe.getTitle();
        this.description = recipe.getDescription();
        this.rating = recipe.getRating();
        if (recipe.getIngredientQuantities() != null) {
            this.ingredients = recipe.getIngredientQuantities()
                    .stream()
                    .map(item -> new IngredientDTO(item.getIngredient(), item.getQuantity()))
                    .collect(Collectors.toList());
        }
        this.category = categoryDTOS;
    }

}

