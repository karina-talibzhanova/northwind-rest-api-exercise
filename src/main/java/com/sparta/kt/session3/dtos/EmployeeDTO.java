package com.sparta.kt.session3.dtos;

import com.sparta.kt.session3.entities.EmployeeEntity;

import java.time.LocalDate;

public class EmployeeDTO {
    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private LocalDate hireDate;
    private String city;
    private String region;
    private String country;
    private String notes;
    private String reportsTo;

    public EmployeeDTO(EmployeeEntity employeeEntity) {
        lastName = employeeEntity.getLastName();
        firstName = employeeEntity.getFirstName();
        title = employeeEntity.getTitle();
        titleOfCourtesy = employeeEntity.getTitleOfCourtesy();
        hireDate = employeeEntity.getHireDate();
        city = employeeEntity.getCity();
        region = employeeEntity.getRegion();
        country = employeeEntity.getCountry();
        notes = employeeEntity.getNotes();
        reportsTo = employeeEntity.getReportsTo() == null ? null : employeeEntity.getReportsTo().getFirstName() + " " + employeeEntity.getReportsTo().getLastName();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getNotes() {
        return notes;
    }

    public String getReportsTo() {
        return reportsTo;
    }

}
