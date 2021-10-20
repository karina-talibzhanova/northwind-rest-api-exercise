package com.sparta.kt.session3.repositories;

import com.sparta.kt.session3.entities.OrderDetailEntity;
import com.sparta.kt.session3.entities.OrderDetailEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailEntityId> {
}