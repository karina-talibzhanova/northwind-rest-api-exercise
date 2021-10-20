package com.sparta.kt.session3.repositories;

import com.sparta.kt.session3.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}