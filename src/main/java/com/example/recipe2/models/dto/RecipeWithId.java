package com.example.recipe2.models.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeWithId {
    private String image;
    private String title;
    private String description;
    private List<CategoryDTO> category =new ArrayList<>();
    private int rating;
    private List<IngredientShortDTO> ingredients = new ArrayList<>();

}
