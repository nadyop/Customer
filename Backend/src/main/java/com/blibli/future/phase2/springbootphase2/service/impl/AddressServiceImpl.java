package com.blibli.future.phase2.springbootphase2.service.impl;

import com.blibli.future.phase2.springbootphase2.model.Address;
import com.blibli.future.phase2.springbootphase2.model.Customer;
import com.blibli.future.phase2.springbootphase2.repository.AddressRepository;
import com.blibli.future.phase2.springbootphase2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address addAddress(String country, String province, String city, String street, String customerId) {
        Address address = new Address();
        Customer customer = new Customer();

        customer.setId(customerId);

        address.setId(UUID.randomUUID().toString());
        address.setCountry(country);
        address.setProvince(province);
        address.setCity(city);
        address.setStreet(street);
        address.setCustomer(customer);

        return addressRepository.save(address);
    }

    @Override
    public Address getAddress(String id, String customerId) {
        return addressRepository.findAddressByIdAndCustomerId(id, customerId);
    }

    @Override
    public List<Address> getAllAddresses(String customerId) {
        return addressRepository.findAllByCustomerId(customerId);
    }

    @Override
    public Boolean deleteAddress(String id, String customerId) {
        Boolean isSuccess = true;

        try {
            addressRepository.deleteAddressByIdAndCustomerId(id, customerId);
        } catch (Exception e) {
            isSuccess = false;
        }

        return isSuccess;
    }

    @Override
    public Address editAddress(Address address) {
        return addressRepository.existsAddressByIdAndCustomerId(address.getId(), address.getCustomer().getId()) ?
                addressRepository.save(address) : null;
    }
}
