package com.example.recipe2.dao;

import com.example.recipe2.models.entity.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<CategoryModel,Integer> {
    CategoryModel findCategoryModelById (int id);
}
