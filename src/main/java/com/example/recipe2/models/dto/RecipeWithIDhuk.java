package com.example.recipe2.models.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecipeWithIDhuk {
    private String image;
    private String title;
    private String description;
    private String category;
    private int rating;
    private List<Integer> ids;
}
