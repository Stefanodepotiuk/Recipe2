package com.example.recipe2.controllers;

import com.example.recipe2.models.dto.CategoryDTO;
import com.example.recipe2.models.dto.CategoryWithFetch_RecipeDTO;
import com.example.recipe2.models.entity.CategoryModel;
import com.example.recipe2.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO>  findById(@PathVariable int id){
        return new ResponseEntity<>(categoryService.getById(id), HttpStatus.FOUND);
    }

    @PostMapping
    public  ResponseEntity<CategoryDTO> upDate(@RequestBody CategoryModel category){
        return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryDTO> Update(@PathVariable int id, @RequestBody CategoryModel category) {
        return new ResponseEntity<>(categoryService.UpdateCategory(id, category), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<CategoryDTO>> delete(@PathVariable int id){
        return new ResponseEntity<>(categoryService.deleteCategory(id),HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public List<CategoryWithFetch_RecipeDTO> search_CategoryWithFetch_Recipe(@PathVariable int id){
        return categoryService.search_CategoryWithFetch_Recipe(id);
    }
}

