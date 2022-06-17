package com.example.recipe2.services;


import com.example.recipe2.dao.RecipeDAO;

import com.example.recipe2.models.dto.RecipeDTO;

import com.example.recipe2.models.dto.RecipeWithId;
import com.example.recipe2.models.entity.CategoryModel;
import com.example.recipe2.models.entity.IngredientModel;
import com.example.recipe2.models.entity.RecipeModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeService {
    private RecipeDAO recipeDAO;
    IngredientService ingredientService;
    CategoryService categoryService;

    public List<RecipeDTO> getAll() {
        List<RecipeModel> recipe = recipeDAO.findAll();
        return recipe.stream().map(RecipeDTO::new).collect(Collectors.toList());
    }

    public RecipeDTO getById(int id) {
        RecipeModel recipe = recipeDAO.findById(id).orElse(new RecipeModel());
        return new RecipeDTO(recipe);
    }

    public RecipeDTO createRecipe(RecipeWithId recipe) {
        RecipeModel newRecipe = new RecipeModel(recipe.getTitle(), recipe.getDescription(),
                recipe.getImage(), recipe.getRating());

        newRecipe.getCategory()
                .addAll(recipe
                        .getCategory()
                        .stream()
                        .map(ing -> {
                            System.out.println(ing.getId());
                            System.out.println(ing);

                            CategoryModel fullCategory = categoryService.findFullCategory(ing.getId());
                            fullCategory.getRecipe().add(newRecipe);
                            System.out.println(fullCategory);
                            return fullCategory;

                        }).collect(Collectors.toList()));
//        recipe.getCategory()
//                .forEach(item -> {
//                    CategoryModel fullCategory = categoryService.findFullCategory(item.getId());
//                    //newRecipe.setCategory(category);
//                });

        recipe.getIngredients()
                .forEach(item -> {
                    IngredientModel ingredient = ingredientService.findFullIngredient(item.getIngredient_id());
                    newRecipe.setIngredient(ingredient, item.getQuantity());
                });
        System.out.println(newRecipe);
        return new RecipeDTO(recipeDAO.save(newRecipe));

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
