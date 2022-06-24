package com.example.recipe2.controllers;


import com.example.recipe2.models.dto.IngredientDTO;
import com.example.recipe2.models.dto.RecipeWithgredientDTO;
import com.example.recipe2.models.entity.IngredientModel;
import com.example.recipe2.services.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
@AllArgsConstructor
public class IngredientController {
    IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<IngredientDTO>> getAll() {
        return new ResponseEntity<>(ingredientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientDTO> findById(@PathVariable int id) {
        return new ResponseEntity<>(ingredientService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IngredientDTO> create(@RequestBody IngredientModel ingredient) {
        return new ResponseEntity<>(ingredientService.createIngredient(ingredient), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<IngredientDTO> update(@PathVariable int id, @RequestBody IngredientModel ingredient) {
        return new ResponseEntity<>(ingredientService.upDateIngredient(id, ingredient), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<IngredientDTO>> delete(@PathVariable int id) {
        return new ResponseEntity<>(ingredientService.deleteIngredient(id), HttpStatus.OK);
    }

    @GetMapping("/ingredient/{id}")
    public ResponseEntity<HashSet<RecipeWithgredientDTO>> findRecipesByIngredient(@PathVariable int id){
        return ingredientService.findRecipesByIngredient(id);
    }

}
