package com.sparta.kt.session3.dtos;

import com.sparta.kt.session3.entities.ProductEntity;

import java.math.BigDecimal;

public class CategoryProductDTO {
    private String productName;
    private String supplierName;
    private String quantityPerUnit;
    private BigDecimal unitPrice;
    private Integer unitsInStock;
    private Boolean discontinued;

    public CategoryProductDTO(ProductEntity productEntity) {
        productName = productEntity.getProductName();
        supplierName = productEntity.getSupplierID().getCompanyName();
        quantityPerUnit = productEntity.getQuantityPerUnit();
        unitPrice = productEntity.getUnitPrice();
        unitsInStock = productEntity.getUnitsInStock();
        discontinued = productEntity.getDiscontinued();
    }

    public String getProductName() {
        return productName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }
}
