package com.sparta.kt.session3.repositories;

import com.sparta.kt.session3.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}