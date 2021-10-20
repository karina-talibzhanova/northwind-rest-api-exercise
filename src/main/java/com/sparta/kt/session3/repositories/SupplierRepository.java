package com.sparta.kt.session3.repositories;

import com.sparta.kt.session3.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer> {
}