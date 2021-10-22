package com.sparta.kt.session3.dtos;

import com.sparta.kt.session3.entities.CategoryEntity;

public class CategoryDTO {
    private String name;
    private String description;

    public CategoryDTO(CategoryEntity categoryEntity) {
        name = categoryEntity.getCategoryName();
        description = categoryEntity.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
