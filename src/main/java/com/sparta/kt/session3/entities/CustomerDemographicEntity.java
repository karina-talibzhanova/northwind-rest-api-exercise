package com.sparta.kt.session3.entities;

import javax.persistence.*;

@Table(name = "customerdemographics")
@Entity
public class CustomerDemographicEntity {
    @Id
    @Column(name = "CustomerTypeID", nullable = false, length = 10)
    private String id;

    @Lob
    @Column(name = "CustomerDesc")
    private String customerDesc;

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}