package com.sparta.kt.session3.repositories;

import com.sparta.kt.session3.entities.EmployeeTerritoryEntity;
import com.sparta.kt.session3.entities.EmployeeTerritoryEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTerritoryRepository extends JpaRepository<EmployeeTerritoryEntity, EmployeeTerritoryEntityId> {
}