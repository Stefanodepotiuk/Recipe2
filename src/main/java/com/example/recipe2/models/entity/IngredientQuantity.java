package com.example.recipe2.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class IngredientQuantity {
    @EmbeddedId
    private RecipeIngredientId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ingredient_id")
    private IngredientModel ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("recipe_id")
    private RecipeModel recipe;

    @Column
    private int quantity;

    public IngredientQuantity(RecipeModel recipe, IngredientModel ingredient, int quantity) {
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.quantity = quantity;
        this.id = new RecipeIngredientId(recipe.getId(), ingredient.getId());
    }
}
