package com.example.recipe2.controllers;

import com.example.recipe2.dao.IngredientDAO;
import com.example.recipe2.models.IngredientModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@AllArgsConstructor
public class IngredientController {
    private IngredientDAO ingredientDAO;

    @GetMapping
    public ResponseEntity<List<IngredientModel>> getAll() {
        return new ResponseEntity<>(ingredientDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientModel> findById(@PathVariable int id) {
        IngredientModel model = ingredientDAO.findById(id).orElse(new IngredientModel());
        if (model.getId() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(model,HttpStatus.OK);
    }

    @PostMapping
    public List<IngredientModel> create(@RequestBody IngredientModel model) {
        ingredientDAO.save(model);
        return ingredientDAO.findAll();
    }

    @PatchMapping("/{id}")
    public IngredientModel update(@PathVariable int id, @RequestBody IngredientModel model) {
        model.setId(id);
        ingredientDAO.save(model);
        return model;
    }

    @DeleteMapping("/{id}")
    public List<IngredientModel> delete(@PathVariable int id) {
        ingredientDAO.deleteById(id);
        return ingredientDAO.findAll();
    }

}
