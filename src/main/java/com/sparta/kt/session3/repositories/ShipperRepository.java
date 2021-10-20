package com.sparta.kt.session3.repositories;

import com.sparta.kt.session3.entities.ShipperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<ShipperEntity, Integer> {
}