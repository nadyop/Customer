package com.blibli.future.phase2.springbootphase2.service;

import com.blibli.future.phase2.springbootphase2.model.Address;

import java.util.List;

public interface AddressService {

    Address addAddress(String country, String province, String city, String street, String customerId);
    Address getAddress(String id, String customerId);
    List<Address> getAllAddresses(String customerId);
    Boolean deleteAddress(String id, String customerId);
    Address editAddress(Address address);
}
