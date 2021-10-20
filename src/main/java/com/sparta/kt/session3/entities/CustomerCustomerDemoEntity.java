package com.sparta.kt.session3.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "customercustomerdemo")
@Entity
public class CustomerCustomerDemoEntity {
    @EmbeddedId
    private CustomerCustomerDemoEntityId id;

    public CustomerCustomerDemoEntityId getId() {
        return id;
    }

    public void setId(CustomerCustomerDemoEntityId id) {
        this.id = id;
    }
}