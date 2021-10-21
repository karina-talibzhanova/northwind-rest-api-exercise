package com.sparta.kt.session3.controllers;

import com.sparta.kt.session3.entities.CustomerEntity;
import com.sparta.kt.session3.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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

    @GetMapping("customers/title")
    @ResponseBody
    public List<String> getAllContactTitles() {
        HashSet<String> contactTitles = new HashSet<>();
        for (CustomerEntity customerEntity : customerRepository.findAll()) {
            contactTitles.add(customerEntity.getContactTitle());
        }

        return contactTitles.stream().toList();
    }

    @GetMapping(value="/customers/title", params = {"contactTitle"})
    @ResponseBody
    public List<CustomerEntity> getAllCustomersByContactTitle(@RequestParam String contactTitle) {
        List<CustomerEntity> foundCustomers = new ArrayList<>();

        for (CustomerEntity customerEntity : customerRepository.findAll()) {
            if (customerEntity.getContactTitle().equalsIgnoreCase(contactTitle)) {
                foundCustomers.add(customerEntity);
            }
        }

        return foundCustomers;
    }

    @GetMapping("/customers/location")
    @ResponseBody
    public List<CustomerEntity> getAllCustomersInSpecificLocation(@RequestParam(required = false) String region, @RequestParam(required = false) String country, @RequestParam(required = false) String city) {
        if (region == null && country == null && city == null) {
            // something has gone wrong here, need to report an error
            return new ArrayList<>();
        }
        List<CustomerEntity> foundCustomers = new ArrayList<>();

        if (region != null) {
            for (CustomerEntity customerEntity : customerRepository.findAll()) {
                if (customerEntity.getRegion()!=null && customerEntity.getRegion().equalsIgnoreCase(region)) {
                    foundCustomers.add(customerEntity);
                }
            }
        }

        if (country != null) {
            if (foundCustomers.size() > 0) {
                foundCustomers.removeIf(customerEntity -> !customerEntity.getCountry().equalsIgnoreCase(country));
            } else {
                for (CustomerEntity customerEntity : customerRepository.findAll()) {
                    if (customerEntity.getCountry() != null && customerEntity.getCountry().equalsIgnoreCase(country)) {
                        foundCustomers.add(customerEntity);
                    }

                }
            }
        }

        if (city != null) {
            if (foundCustomers.size() > 0) {
                foundCustomers.removeIf(customerEntity -> !customerEntity.getCity().equalsIgnoreCase(city));
            } else {
                for (CustomerEntity customerEntity : customerRepository.findAll()) {
                    if (customerEntity.getCity() != null && customerEntity.getCity().equalsIgnoreCase(city)) {
                        foundCustomers.add(customerEntity);
                    }
                }
            }
        }
        return foundCustomers;
    }
}
