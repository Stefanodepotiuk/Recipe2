package com.example.recipe2.controllers;

import com.example.recipe2.models.dto.RecipeDTO;
import com.example.recipe2.models.dto.RecipeWithId;
import com.example.recipe2.models.entity.RecipeModel;
import com.example.recipe2.models.pagination.RecipePage;
import com.example.recipe2.services.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/recipes")
@AllArgsConstructor
public class RecipeController {
    RecipeService recipeService;

//    @GetMapping
//    public ResponseEntity<List<RecipeDTO>> getAll() {
//        return new ResponseEntity<>(recipeService.getAll(), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> getAll(@RequestBody RecipePage recipePage) {
        return new ResponseEntity<>(recipeService.getAll(recipePage), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> findById(@PathVariable int id) {
        return new ResponseEntity<>(recipeService.getById(id), HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<RecipeDTO> upDate(@RequestBody RecipeWithId recipe) {
//        return new ResponseEntity<>(recipeService.createRecipe(recipe), HttpStatus.OK);
//    }

    @PostMapping(value = "")
    public ResponseEntity<RecipeDTO> upDate(@RequestParam String recipe, @RequestParam(required = false) MultipartFile image) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        RecipeWithId recipeDTO = mapper.readValue(recipe, RecipeWithId.class);
        return new ResponseEntity<>(recipeService.createRecipe(recipeDTO, image), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RecipeDTO> upDate(@PathVariable int id, @RequestBody RecipeModel recipe) {
        return new ResponseEntity<>(recipeService.upDateRecipe(id, recipe), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<List<RecipeDTO>> delete(@PathVariable int id) {
        return new ResponseEntity<>(recipeService.deleteRecipe(id), HttpStatus.OK);
    }
}
