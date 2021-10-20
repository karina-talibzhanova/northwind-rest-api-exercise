package com.sparta.kt.session3.repositories;

import com.sparta.kt.session3.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}