package com.example.recipe2.services;

import com.example.recipe2.dao.IngredientDAO;
import com.example.recipe2.models.dto.IngredientDTO;
import com.example.recipe2.models.dto.RecipeWithgredientDTO;
import com.example.recipe2.models.entity.IngredientModel;
import com.example.recipe2.models.entity.IngredientQuantity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IngredientService {

    private IngredientDAO ingredientDAO;

    public List<IngredientDTO> getAll() {
        List<IngredientModel> ingredients = ingredientDAO.findAll();
        return ingredients.stream().map(IngredientDTO::new).collect(Collectors.toList());
    }

    public IngredientDTO getById(int id) {
        IngredientModel ingredient = ingredientDAO.findById(id).orElse(new IngredientModel());
        return new IngredientDTO(ingredient);
    }

    public IngredientDTO createIngredient(IngredientModel ingredient) {
        IngredientModel savesIngredient = ingredientDAO.save(ingredient);
        return new IngredientDTO(savesIngredient);
    }

    public IngredientDTO upDateIngredient(int id, IngredientModel ingredient) {
        ingredient.setId(id);
        IngredientModel saveIngredient = ingredientDAO.save(ingredient);
        return new IngredientDTO(saveIngredient);
    }

    public List<IngredientDTO> deleteIngredient(int id) {
        ingredientDAO.deleteById(id);
        List<IngredientModel> all = ingredientDAO.findAll();
        return all.stream().map(IngredientDTO::new).collect(Collectors.toList());
    }

    public IngredientModel findFullIngredient(int id) {
        return ingredientDAO.findIngredientById(id);
    }


    public ResponseEntity<HashSet<RecipeWithgredientDTO>> findRecipesByIngredient(int id){
        IngredientModel ingredient = ingredientDAO.findById(id).orElse(new IngredientModel());

        if (ingredient.getIngredientQuantities().isEmpty()) new ResponseEntity<>(HttpStatus.NOT_FOUND);

        HashSet<RecipeWithgredientDTO> recipes = (HashSet<RecipeWithgredientDTO>) ingredient.getIngredientQuantities()
                .stream()
                .map(item -> new RecipeWithgredientDTO(item.getRecipe()))
                .collect(Collectors.toSet());

        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
}
