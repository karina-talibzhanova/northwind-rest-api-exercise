package com.sparta.kt.session3.repositories;

import com.sparta.kt.session3.entities.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<RegionEntity, Integer> {
}