package com.example.recipe2.services;

import com.example.recipe2.dao.CategoryDAO;
import com.example.recipe2.models.dto.CategoryDTO;
import com.example.recipe2.models.dto.CategoryWithFetch_RecipeDTO;
import com.example.recipe2.models.entity.CategoryModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryDAO categoryDAO;

    public List<CategoryDTO> getAll(){
        List<CategoryModel> category = categoryDAO.findAll();
        return category.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    public CategoryDTO getById(int id) {
        CategoryModel category = categoryDAO.findById(id).orElse(new CategoryModel());
        return new CategoryDTO(category);
    }

    public CategoryDTO createCategory(CategoryModel category){
        CategoryModel save = categoryDAO.save(category);
        return new CategoryDTO(save);
    }
    public CategoryDTO UpdateCategory(int id , CategoryModel category){
        category.setId(id);
        CategoryModel save = categoryDAO.save(category);
        return new CategoryDTO(save);
    }
    public List<CategoryDTO> deleteCategory(int id){
        categoryDAO.deleteById(id);
        List<CategoryModel> all = categoryDAO.findAll();
        return all.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    public CategoryModel findFullCategory (int id) {
        return categoryDAO.findCategoryModelById(id);
    }

    public List<CategoryWithFetch_RecipeDTO> search_CategoryWithFetch_Recipe(int id) {
        List<CategoryModel> categoryModelList = categoryDAO.customQueryCategoryWithFetch_Recipe(id);
        return  categoryModelList.stream().map(CategoryWithFetch_RecipeDTO::new).collect(Collectors.toList());

    }

}
