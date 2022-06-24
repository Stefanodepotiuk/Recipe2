package com.example.recipe2.dao;

import com.example.recipe2.models.entity.IngredientModel;
import com.example.recipe2.models.entity.IngredientQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientDAO extends JpaRepository<IngredientModel,Integer> {
    IngredientModel findIngredientById (int id);
}
