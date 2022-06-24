package com.example.recipe2.dao;

import com.example.recipe2.models.entity.CategoryModel;
import com.example.recipe2.models.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryDAO extends JpaRepository<CategoryModel,Integer> {
    CategoryModel findCategoryModelById (int id);

    @Query("select c from CategoryModel c join fetch c.recipe where c.id=:id")
    List<CategoryModel> customQueryCategoryWithFetch_Recipe(int id);
}
