package com.example.recipe2.dao;

import com.example.recipe2.models.entity.RecipeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeDAO extends JpaRepository<RecipeModel,Integer> {
}
