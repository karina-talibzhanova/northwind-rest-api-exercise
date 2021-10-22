package com.sparta.kt.session3.controllers;

import com.sparta.kt.session3.dtos.CustomerDTO;
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
import java.util.stream.Collectors;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<CustomerDTO> getAllCustomers(@RequestParam(required = false) String contactName) {
        if (contactName == null) {
            return customerRepository.findAll().stream().map(CustomerDTO::new).collect(Collectors.toList());
        }

        List<CustomerDTO> foundCustomers = new ArrayList<>();
        for (CustomerEntity customerEntity : customerRepository.findAll()) {
            if (customerEntity.getContactName().contains(contactName)) {
                foundCustomers.add(new CustomerDTO(customerEntity));
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
    public List<CustomerDTO> getAllCustomersByContactTitle(@RequestParam String contactTitle) {
        List<CustomerDTO> foundCustomers = new ArrayList<>();

        for (CustomerEntity customerEntity : customerRepository.findAll()) {
            if (customerEntity.getContactTitle().equalsIgnoreCase(contactTitle)) {
                foundCustomers.add(new CustomerDTO(customerEntity));
            }
        }

        return foundCustomers;
    }

    @GetMapping("/customers/location")
    @ResponseBody
    public List<CustomerDTO> getAllCustomersInSpecificLocation(@RequestParam(required = false) String region, @RequestParam(required = false) String country, @RequestParam(required = false) String city) {
        if (region == null && country == null && city == null) {
            // something has gone wrong here, need to report an error
            return new ArrayList<>();
        }
        List<CustomerDTO> foundCustomers = new ArrayList<>();

        if (region != null) {
            for (CustomerEntity customerEntity : customerRepository.findAll()) {
                if (customerEntity.getRegion()!=null && customerEntity.getRegion().equalsIgnoreCase(region)) {
                    foundCustomers.add(new CustomerDTO(customerEntity));
                }
            }
        }

        if (country != null) {
            if (foundCustomers.size() > 0) {
                foundCustomers.removeIf(customerDTO -> !customerDTO.getCountry().equalsIgnoreCase(country));
            } else {
                for (CustomerEntity customerEntity : customerRepository.findAll()) {
                    if (customerEntity.getCountry() != null && customerEntity.getCountry().equalsIgnoreCase(country)) {
                        foundCustomers.add(new CustomerDTO(customerEntity));
                    }

                }
            }
        }

        if (city != null) {
            if (foundCustomers.size() > 0) {
                foundCustomers.removeIf(customerDTO -> !customerDTO.getCity().equalsIgnoreCase(city));
            } else {
                for (CustomerEntity customerEntity : customerRepository.findAll()) {
                    if (customerEntity.getCity() != null && customerEntity.getCity().equalsIgnoreCase(city)) {
                        foundCustomers.add(new CustomerDTO(customerEntity));
                    }
                }
            }
        }
        return foundCustomers;
    }
}
