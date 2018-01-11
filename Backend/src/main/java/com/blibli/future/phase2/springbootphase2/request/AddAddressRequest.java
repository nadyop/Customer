package com.blibli.future.phase2.springbootphase2.request;

import org.hibernate.validator.constraints.NotBlank;

public class AddAddressRequest {

    @NotBlank
    private String country;

    @NotBlank
    private String province;

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
