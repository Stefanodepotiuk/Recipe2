package com.example.recipe2.services;

import com.example.recipe2.dao.RecipeDAO;
import com.example.recipe2.models.dto.RecipeDTO;
import com.example.recipe2.models.entity.RecipeModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeService {
    private RecipeDAO recipeDAO;

    public List<RecipeDTO> getAll() {
        List<RecipeModel> recipe = recipeDAO.findAll();
        return recipe.stream().map(RecipeDTO::new).collect(Collectors.toList());
    }

    public RecipeDTO getById(int id) {
        RecipeModel recipe = recipeDAO.findById(id).orElse(new RecipeModel());
        return new RecipeDTO(recipe);
    }

    public RecipeDTO createRecipe(RecipeModel recipe) {
        RecipeModel saveRecipe = recipeDAO.save(recipe);
        return new RecipeDTO(saveRecipe);
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
