package com.example.recipe2.controllers;

import com.example.recipe2.models.dto.RecipeDTO;
import com.example.recipe2.models.entity.RecipeModel;
import com.example.recipe2.services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@AllArgsConstructor
public class RecipeController {
    RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> getAll() {
        return new ResponseEntity<>(recipeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> findById(@PathVariable int id) {
        return new ResponseEntity<>(recipeService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> upDate(@RequestBody RecipeModel recipe) {
        return new ResponseEntity<>(recipeService.createRecipe(recipe), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RecipeDTO> upDate(@PathVariable int id, @RequestBody RecipeModel recipe) {
        return new ResponseEntity<>(recipeService.upDateRecipe(id,recipe), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<List<RecipeDTO>> delete(@PathVariable int id) {
        return new ResponseEntity<>(recipeService.deleteRecipe(id), HttpStatus.OK);
    }
}
