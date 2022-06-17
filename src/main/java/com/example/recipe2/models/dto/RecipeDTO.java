package com.example.recipe2.models.dto;

import com.example.recipe2.models.entity.CategoryModel;
import com.example.recipe2.models.entity.RecipeModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Data
public class RecipeDTO {
    private int id;
    private String image;
    private String title;
    private String description;
    private int rating;
    private List<CategoryDTO> category = new ArrayList<>();
    private List<IngredientDTO> ingredient = new ArrayList<>();



    public RecipeDTO(RecipeModel recipe) {
        this.id = recipe.getId();
        this.image = recipe.getImage();
        this.title = recipe.getTitle();
        this.description = recipe.getDescription();
        this.rating = recipe.getRating();

        this.category = recipe.getCategory()
                .stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
//                .stream()
//                .map(model -> new CategoryDTO(model.getCategory()))
//                .collect(Collectors.toList());

        if (recipe.getIngredientQuantities() != null) {
            this.ingredient = recipe.getIngredientQuantities()
                    .stream()
                    .map(item -> new IngredientDTO(item.getIngredient(), item.getQuantity()))
                    .collect(Collectors.toList());
        }
    }

}
