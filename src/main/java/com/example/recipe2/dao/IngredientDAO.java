package com.example.recipe2.dao;

import com.example.recipe2.models.IngredientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDAO extends JpaRepository<IngredientModel,Integer> {
}
