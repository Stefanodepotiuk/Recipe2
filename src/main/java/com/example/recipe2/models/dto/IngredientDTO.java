package com.example.recipe2.models.dto;

import com.example.recipe2.models.entity.IngredientModel;
import com.example.recipe2.models.entity.RecipeModel;
import lombok.Data;

import java.util.List;

@Data
public class IngredientDTO {
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

    private List<RecipeModel> recipeModels;

    public IngredientDTO(IngredientModel ingredient) {
        this.id = ingredient.getId();
        this.type = ingredient.getType();
        this.type_ukr = ingredient.getType_ukr();
        this.name = ingredient.getName();
        this.name_ukr = ingredient.getName_ukr();
        this.weight = ingredient.getWeight();
        this.calories = ingredient.getCalories();
        this.total_protein = ingredient.getTotal_protein();
        this.total_fat = ingredient.getTotal_fat();
        this.saturated_fatty_acids = ingredient.getSaturated_fatty_acids();
        this.monounsaturated_fatty_acids = ingredient.getMonounsaturated_fatty_acids();
        this.polyunsaturated_fatty_acids = ingredient.getPolyunsaturated_fatty_acids();
        this.carbohydrate = ingredient.getCarbohydrate();
        this.fiber = ingredient.getFiber();
        this.sugars = ingredient.getSugars();
        this.vitamin_a = ingredient.getVitamin_a();
        this.thiamin_vitamin_b1 = ingredient.getThiamin_vitamin_b1();
        this.riboflavin_vitamin_b2 = ingredient.getRiboflavin_vitamin_b2();
        this.niacin_vitamin_b3 = ingredient.getNiacin_vitamin_b3();
        this.choline_vitamin_b4 = ingredient.getCholine_vitamin_b4();
        this.pantothenic_acid_vitamin_b5 = ingredient.getPantothenic_acid_vitamin_b5();
        this.vitamin_b6 = ingredient.getVitamin_b6();
        this.folic_acid_vitamin_b5 = ingredient.getFolic_acid_vitamin_b5();
        this.vitamin_b12_cobalamin = ingredient.getVitamin_b12_cobalamin();
        this.vitamin_d = ingredient.getVitamin_d();
        this.vitamin_e_alpha_tocopherol = ingredient.getVitamin_e_alpha_tocopherol();
        this.vitamin_k = ingredient.getVitamin_k();
        this.vitamin_c_ascorbic_acid = ingredient.getVitamin_c_ascorbic_acid();
        this.cholesterol = ingredient.getCholesterol();
        this.sodium = ingredient.getSodium();
        this.potassium = ingredient.getPotassium();
        this.calcium = ingredient.getCalcium();
        this.copper = ingredient.getCopper();
        this.phosphorus_p = ingredient.getPhosphorus_p();
        this.magnesium = ingredient.getMagnesium();
        this.iron = ingredient.getIron();
        this.zinc = ingredient.getZinc();
        this.manganese = ingredient.getManganese();
        this.selenium = ingredient.getSelenium();
        this.recipeModels= ingredient.getRecipeModels();
    }
}
