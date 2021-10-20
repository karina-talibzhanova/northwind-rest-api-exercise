package com.sparta.kt.session3.controllers;

import com.sparta.kt.session3.entities.CustomerEntity;
import com.sparta.kt.session3.entities.ProductEntity;
import com.sparta.kt.session3.repositories.CustomerRepository;
import com.sparta.kt.session3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class NorthwindController {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public NorthwindController(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")  // in-line parameter (placeholder)
    public Optional<ProductEntity> getProductsById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<CustomerEntity> getAllCustomers(@RequestParam(required = false) String name) {
        if (name == null) {
            return customerRepository.findAll();
        }

        List<CustomerEntity> foundCustomers = new ArrayList<>();
        for (CustomerEntity customerEntity : customerRepository.findAll()) {
            if (customerEntity.getContactName().contains(name)) {
                foundCustomers.add(customerEntity);
            }
        }
        return foundCustomers;
    }
}
