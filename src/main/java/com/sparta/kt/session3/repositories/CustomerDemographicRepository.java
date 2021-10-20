package com.sparta.kt.session3.repositories;

import com.sparta.kt.session3.entities.CustomerDemographicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDemographicRepository extends JpaRepository<CustomerDemographicEntity, String> {
}