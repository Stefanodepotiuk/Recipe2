package com.example.recipe2.models.pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipePage {
    private int page = 5;
    private int size = 5;
}
