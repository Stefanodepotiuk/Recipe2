package com.example.recipe2.models.dto;

import com.example.recipe2.models.entity.CategoryModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CategoryDTO {

    private int id;
    private String category;

//    private List<RecipeDTO> recipe = new ArrayList<>();



    public CategoryDTO(CategoryModel category) {
        this.id = category.getId();
        this.category = category.getCategory();

        System.out.println(this.category);
        System.out.println(this.id);
        System.out.println(category);
//        this.recipe = category.getRecipe()
//                .stream()
//                .map(RecipeDTO::new)
//                .collect(Collectors.toList());
    }


}
