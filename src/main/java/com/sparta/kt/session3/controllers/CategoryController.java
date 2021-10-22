package com.sparta.kt.session3.controllers;

import com.sparta.kt.session3.dtos.CategoryDTO;
import com.sparta.kt.session3.dtos.CategoryProductDTO;
import com.sparta.kt.session3.entities.CategoryEntity;
import com.sparta.kt.session3.entities.ProductEntity;
import com.sparta.kt.session3.repositories.CategoryRepository;
import com.sparta.kt.session3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/categories")
    @ResponseBody
    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryRepository.findAll()) {
            categories.add(categoryEntity.getCategoryName());
        }
        return categories;
    }

    @GetMapping("/categories/{name}")
    @ResponseBody
    public Optional<CategoryDTO> getCategoryByName(@PathVariable String name) {
        Optional<CategoryDTO> category = Optional.empty();

        for (CategoryEntity categoryEntity : categoryRepository.findAll()) {
            if (categoryEntity.getCategoryName().equalsIgnoreCase(name)) {
                category = Optional.of(new CategoryDTO(categoryEntity));
                break;
            }
        }

        return category;
    }

    @GetMapping("/categories/{name}/products")
    @ResponseBody
    public List<CategoryProductDTO> getAllProductsInCategory(@PathVariable String name) {
        List<CategoryProductDTO> categoryProductDTOs = new ArrayList<>();

        for (ProductEntity productEntity : productRepository.findAll()) {
            if (productEntity.getCategoryID().getCategoryName().equalsIgnoreCase(name)) {
                categoryProductDTOs.add(new CategoryProductDTO(productEntity));
            }
        }

        return categoryProductDTOs;
    }

}
