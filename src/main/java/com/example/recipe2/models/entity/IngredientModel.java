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
public class IngredientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String type_ukr;
    private String name;
    private String name_ukr;
    private int weight;
    private int calories;
    private float total_protein;
    private float total_fat;
    private float saturated_fatty_acids;
    private float monounsaturated_fatty_acids;
    private float polyunsaturated_fatty_acids;
    private float carbohydrate;
    private float fiber;
    private float sugars;
    private int vitamin_a;
    private int thiamin_vitamin_b1;
    private int riboflavin_vitamin_b2;
    private int niacin_vitamin_b3;
    private int choline_vitamin_b4;
    private int pantothenic_acid_vitamin_b5;
    private int vitamin_b6;
    private int folic_acid_vitamin_b5;
    private float vitamin_b12_cobalamin;
    private int vitamin_d;
    private int vitamin_e_alpha_tocopherol;
    private float vitamin_k;
    private int vitamin_c_ascorbic_acid;
    private int cholesterol;
    private int sodium;
    private int potassium;
    private int calcium;
    private float copper;
    private int phosphorus_p;
    private int magnesium;
    private float iron;
    private float zinc;
    private float manganese;
    private float selenium;

    @OneToMany(
            mappedBy = "ingredient",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @ToString.Exclude
    private List<IngredientQuantity> ingredientQuantities = new ArrayList<>();
}
