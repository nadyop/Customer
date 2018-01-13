package com.gdn.future.restapispringboot.service.impl;

import com.gdn.future.restapispringboot.model.Address;
import com.gdn.future.restapispringboot.model.Customer;
import com.gdn.future.restapispringboot.repositories.AddressRepository;
import com.gdn.future.restapispringboot.request.RegisterAddressRequest;
import com.gdn.future.restapispringboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address addAddress(String idCustomer, RegisterAddressRequest request) {
        Address address = new Address();
        Customer customer = new Customer();

        customer.setId(idCustomer);

        address.setId(UUID.randomUUID().toString());
        address.setCity(request.getCity());
        address.setStreet(request.getStreet());
        address.setCountry(request.getCountry());
        address.setProvince(request.getProvince());
        address.setCustomer(customer);

        return addressRepository.save(address);
    }

    @Override
    public Address getAddress(String idCustomer, String idAddress) {
        return addressRepository.findAddressByIdAndCustomerId(idAddress, idCustomer);
    }

    @Override
    public List<Address> getAllAddress(String idCustomer) {
        return addressRepository.findAddressByCustomerId(idCustomer);
    }

    @Override
    public void deleteAddress(String idCustomer, String idAddress) {
        addressRepository.deleteAddressByIdAndCustomerId(idAddress, idCustomer);
    }

    @Override
    public Address updateAddress(String idCustomer, String idAddress, RegisterAddressRequest request) {
        Address address = new Address();
        Customer customer = new Customer();

        customer.setId(idCustomer);

        address.setId(idAddress);
        address.setCity(request.getCity());
        address.setStreet(request.getStreet());
        address.setCountry(request.getCountry());
        address.setProvince(request.getProvince());
        address.setCustomer(customer);

        return addressRepository.existsAddressByIdAndCustomerId(idAddress, idCustomer) ? addressRepository.save(address) : null;
    }
}
