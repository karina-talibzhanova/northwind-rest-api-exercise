package com.sparta.kt.session3.controllers;

import com.sparta.kt.session3.entities.EmployeeEntity;
import com.sparta.kt.session3.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    @ResponseBody
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) String name) {
        if (name == null) {
            return employeeRepository.findAll();
        }

        List<EmployeeEntity> foundEmployees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeRepository.findAll()) {
            if ((employeeEntity.getFirstName() + employeeEntity.getLastName()).contains(name)) {
                foundEmployees.add(employeeEntity);
            }
        }

        return foundEmployees;
    }

    @GetMapping("employees/title")
    @ResponseBody
    public List<String> getAllContactTitles() {
        HashSet<String> contactTitles = new HashSet<>();
        for (EmployeeEntity employeeEntity : employeeRepository.findAll()) {
            contactTitles.add(employeeEntity.getTitle());
        }

        return contactTitles.stream().toList();
    }

    @GetMapping(value="/employees/title", params = {"contactTitle"})
    @ResponseBody
    public List<EmployeeEntity> getAllEmployeesByContactTitle(@RequestParam String contactTitle) {
        List<EmployeeEntity> foundEmployees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeRepository.findAll()) {
            if (employeeEntity.getTitle().equalsIgnoreCase(contactTitle)) {
                foundEmployees.add(employeeEntity);
            }
        }

        return foundEmployees;
    }

    @GetMapping("/employees/location")
    @ResponseBody
    public List<EmployeeEntity> getAllEmployeesInSpecificLocation(@RequestParam(required = false) String region, @RequestParam(required = false) String country, @RequestParam(required = false) String city) {
        if (region == null && country == null && city == null) {
            // something has gone wrong here, need to report an error
            return new ArrayList<>();
        }
        List<EmployeeEntity> foundEmployees = new ArrayList<>();

        if (region != null) {
            for (EmployeeEntity employeeEntity : employeeRepository.findAll()) {
                if (employeeEntity.getRegion()!=null && employeeEntity.getRegion().equalsIgnoreCase(region)) {
                    foundEmployees.add(employeeEntity);
                }
            }
        }

        if (country != null) {
            if (foundEmployees.size() > 0) {
                foundEmployees.removeIf(employeeEntity -> !employeeEntity.getCountry().equalsIgnoreCase(country));
            } else {
                for (EmployeeEntity employeeEntity : employeeRepository.findAll()) {
                    if (employeeEntity.getCountry() != null && employeeEntity.getCountry().equalsIgnoreCase(country)) {
                        foundEmployees.add(employeeEntity);
                    }

                }
            }
        }

        if (city != null) {
            if (foundEmployees.size() > 0) {
                foundEmployees.removeIf(employeeEntity -> !employeeEntity.getCity().equalsIgnoreCase(city));
            } else {
                for (EmployeeEntity employeeEntity : employeeRepository.findAll()) {
                    if (employeeEntity.getCity() != null && employeeEntity.getCity().equalsIgnoreCase(city)) {
                        foundEmployees.add(employeeEntity);
                    }
                }
            }
        }
        return foundEmployees;
    }

    @GetMapping("/employees/hired")
    @ResponseBody
    public List<EmployeeEntity> getAllEmployeesHiredBetweenDates(@RequestParam(required = false) String lowerBound, @RequestParam(required = false) String upperBound) {
        if (lowerBound == null && upperBound == null) {
            // something has gone wrong
            return new ArrayList<>();
        }

        List<EmployeeEntity> foundEmployees = new ArrayList<>();
        LocalDate lowerDate = LocalDate.MIN;
        LocalDate upperDate = LocalDate.MAX;

        if (lowerBound != null) {
            lowerDate = LocalDate.parse(lowerBound);
        }
        if (upperBound != null) {
            upperDate = LocalDate.parse(upperBound);
        }

        for (EmployeeEntity employeeEntity : employeeRepository.findAll()) {
            if (employeeEntity.getHireDate().isAfter(lowerDate) && employeeEntity.getHireDate().isBefore(upperDate)) {
                foundEmployees.add(employeeEntity);
            }
        }

        return foundEmployees;
    }

}