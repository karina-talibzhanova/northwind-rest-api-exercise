package com.sparta.kt.session3.controllers;

import com.sparta.kt.session3.entities.CategoryEntity;
import com.sparta.kt.session3.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/categories/{name}")
    @ResponseBody
    public Optional<CategoryEntity> getCategoryByName(@PathVariable String name) {
        Optional<CategoryEntity> category = Optional.empty();

        for (CategoryEntity categoryEntity : categoryRepository.findAll()) {
            if (categoryEntity.getCategoryName().equalsIgnoreCase(name)) {
                category = Optional.of(categoryEntity);
                break;
            }
        }
        return category;
    }

}
