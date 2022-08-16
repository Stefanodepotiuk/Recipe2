package com.example.recipe2.services;

import com.example.recipe2.dao.RecipeDAO;

import com.example.recipe2.models.dto.RecipeDTO;

import com.example.recipe2.models.dto.RecipeWithId;
import com.example.recipe2.models.entity.CategoryModel;
import com.example.recipe2.models.entity.IngredientModel;
import com.example.recipe2.models.entity.RecipeModel;
import com.example.recipe2.models.pagination.RecipePage;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeService {
    private RecipeDAO recipeDAO;
    IngredientService ingredientService;
    CategoryService categoryService;

    final String path = System.getProperty("user.home") + File.separator + "imageMeals" + File.separator;

    public List<RecipeDTO> getAll(RecipePage recipePage) {
        Pageable of = PageRequest.of(recipePage.getPage(), recipePage.getSize());
        return recipeDAO.findAll(of).getContent().stream().map(RecipeDTO::new).collect(Collectors.toList());
    }


    public RecipeDTO getById(int id) {
        RecipeModel recipe = recipeDAO.findById(id).orElse(new RecipeModel());
        return new RecipeDTO(recipe);
    }

    public RecipeDTO createRecipe(RecipeWithId recipe, MultipartFile image) throws IOException {
        RecipeModel newRecipe = new RecipeModel(recipe.getTitle(),
                recipe.getDescription(),
                image.getOriginalFilename(),
                recipe.getRating());

        newRecipe.getCategory()
                .addAll(recipe
                        .getCategory()
                        .stream()
                        .map(ing -> {
                            CategoryModel fullCategory = categoryService.findFullCategory(ing.getId());
                            fullCategory.getRecipe().add(newRecipe);
                            return fullCategory;

                        }).collect(Collectors.toList()));

        recipe.getIngredients()
                .forEach(item -> {
                    IngredientModel ingredient = ingredientService.findFullIngredient(item.getIngredient_id());
                    newRecipe.setIngredient(ingredient, item.getQuantity());
                });

        image.transferTo(new File(path + image.getOriginalFilename()));

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
