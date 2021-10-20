package com.sparta.kt.session3.repositories;

import com.sparta.kt.session3.entities.CustomerCustomerDemoEntity;
import com.sparta.kt.session3.entities.CustomerCustomerDemoEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCustomerDemoRepository extends JpaRepository<CustomerCustomerDemoEntity, CustomerCustomerDemoEntityId> {
}