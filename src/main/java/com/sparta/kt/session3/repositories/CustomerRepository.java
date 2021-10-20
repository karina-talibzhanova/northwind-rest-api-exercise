package com.sparta.kt.session3.repositories;

import com.sparta.kt.session3.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}