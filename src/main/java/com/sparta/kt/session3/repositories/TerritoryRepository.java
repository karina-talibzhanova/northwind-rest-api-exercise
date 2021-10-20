package com.sparta.kt.session3.repositories;

import com.sparta.kt.session3.entities.TerritoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoryRepository extends JpaRepository<TerritoryEntity, String> {
}