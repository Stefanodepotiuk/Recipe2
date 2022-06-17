package com.example.recipe2.models.entity;

import com.example.recipe2.models.dto.CategoryDTO;
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

    private int rating;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @ToString.Exclude
    private List<CategoryModel> category ;


    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<IngredientQuantity> ingredientQuantities = new ArrayList<>();

    public RecipeModel(String image, String title, String description, int rating) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public void setIngredient(IngredientModel ingredient, int quantity) {
        IngredientQuantity ingredientQuantity = new IngredientQuantity(this, ingredient, quantity);
        ingredientQuantities.add(ingredientQuantity);
        ingredient.getIngredientQuantities().add(ingredientQuantity);
    }


//    public void setCategory(CategoryModel setCategory) {
//
//    }
}
