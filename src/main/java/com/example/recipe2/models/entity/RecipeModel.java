package com.example.recipe2.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RecipeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image;
    private String title;
    private String description;
    private String category;
    private int rating;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<IngredientQuantity> ingredientQuantities = new ArrayList<>();

    public RecipeModel(String image, String title, String description, String category, int rating) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.category = category;
        this.rating = rating;
    }

    public void setIngredient(IngredientModel ingredient, int quantity) {
        IngredientQuantity ingredientQuantity = new IngredientQuantity(this, ingredient, quantity);
        ingredientQuantities.add(ingredientQuantity);
        ingredient.getIngredientQuantities().add(ingredientQuantity);
    }
}
