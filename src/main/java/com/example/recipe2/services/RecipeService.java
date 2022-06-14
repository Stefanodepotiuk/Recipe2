package com.example.recipe2.services;


import com.example.recipe2.dao.IngredientDAO;
import com.example.recipe2.dao.RecipeDAO;

import com.example.recipe2.models.dto.RecipeDTO;

import com.example.recipe2.models.dto.RecipeWithIDhuk;
import com.example.recipe2.models.entity.IngredientModel;
import com.example.recipe2.models.entity.RecipeModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeService {
    private RecipeDAO recipeDAO;
    private IngredientDAO ingredientDAO;
    IngredientService ingredientService;

    public List<RecipeDTO> getAll() {
        List<RecipeModel> recipe = recipeDAO.findAll();
        return recipe.stream().map(RecipeDTO::new).collect(Collectors.toList());
    }

    public RecipeDTO getById(int id) {
        RecipeModel recipe = recipeDAO.findById(id).orElse(new RecipeModel());
        return new RecipeDTO(recipe);
    }

    public RecipeDTO createRecipe(RecipeWithIDhuk recipe) {
        ArrayList<IngredientModel> models = new ArrayList<>();

        System.out.println(recipe.getIds());

        for (Integer id : recipe.getIds()) {
            models.add(ingredientDAO.findById(id).get());
        }

        RecipeModel recipeModel = new RecipeModel();

        recipeModel.setTitle(recipe.getTitle());
        recipeModel.setDescription(recipe.getDescription());
        recipeModel.setCategory(recipe.getCategory());
        recipeModel.setRating(recipe.getRating());
        recipeModel.setIngredient(models);

        recipeDAO.save(recipeModel);
        System.out.println(recipeModel);
        System.out.println(models);

        return new RecipeDTO(recipeModel);
    }

    public RecipeDTO upDateRecipe(int id, RecipeModel recipe) {
        recipe.setId(id);
        RecipeModel saveRecipe = recipeDAO.save(recipe);
        return new RecipeDTO(saveRecipe);
    }

    public List<RecipeDTO> deleteRecipe(int id) {
        recipeDAO.deleteById(id);
        List<RecipeModel> all = recipeDAO.findAll();
        return all.stream().map(RecipeDTO::new).collect(Collectors.toList());
    }
}
