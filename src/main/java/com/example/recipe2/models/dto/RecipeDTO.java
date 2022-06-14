package com.example.recipe2.models.dto;

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
    private String category;
    private int rating;

    private List<IngredientDTO> ingredient = new ArrayList<>();

    public RecipeDTO(RecipeModel recipe) {
        this.id = recipe.getId();
        this.image = recipe.getImage();
        this.title = recipe.getTitle();
        this.description = recipe.getDescription();
        this.category = recipe.getCategory();
        this.rating = recipe.getRating();


//        List<IngredientDTO> IngredientsDTOList = new ArrayList<>();
//        List<IngredientModel> ingredients = new ArrayList<>(recipe.getIngredient());
//        for (IngredientModel model : ingredients) {
//            IngredientsDTOList.add(new IngredientDTO(model));
//        }
//        this.ingredient = new ArrayList<>(IngredientsDTOList);

        if (recipe.getIngredientQuantities() != null) {
            this.ingredient = recipe.getIngredientQuantities()
                    .stream()
                    .map(item -> new IngredientDTO(item.getIngredient(), item.getQuantity()))

                    .collect(Collectors.toList());
        }
    }

}
