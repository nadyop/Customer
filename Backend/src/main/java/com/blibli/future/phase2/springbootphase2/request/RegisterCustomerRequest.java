package com.blibli.future.phase2.springbootphase2.request;

import com.blibli.future.phase2.springbootphase2.model.Address;
import org.hibernate.validator.constraints.NotBlank;

public class RegisterCustomerRequest {

    @NotBlank
    private String name;

    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
