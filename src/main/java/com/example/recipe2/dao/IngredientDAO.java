package com.example.recipe2.dao;

import com.example.recipe2.models.entity.IngredientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDAO extends JpaRepository<IngredientModel,Integer> {
    IngredientModel findIngredientById (int id);
}
