package com.sparta.kt.session3.dtos;

import com.sparta.kt.session3.entities.CustomerEntity;

public class CustomerDTO {
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;

    public CustomerDTO(CustomerEntity customerEntity) {
        companyName = customerEntity.getCompanyName();
        contactName = customerEntity.getContactName();
        contactTitle = customerEntity.getContactTitle();
        address = customerEntity.getAddress();
        city = customerEntity.getCity();
        region = customerEntity.getRegion();
        postalCode = customerEntity.getPostalCode();
        country = customerEntity.getCountry();
        phone = customerEntity.getPhone();
        fax = customerEntity.getFax();
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }
}
