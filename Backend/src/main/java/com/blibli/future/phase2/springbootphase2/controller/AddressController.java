package com.blibli.future.phase2.springbootphase2.controller;

import com.blibli.future.phase2.springbootphase2.model.Address;
import com.blibli.future.phase2.springbootphase2.model.Customer;
import com.blibli.future.phase2.springbootphase2.request.AddAddressRequest;
import com.blibli.future.phase2.springbootphase2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers/{customerId}/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, // Apa yang dikirim
            consumes = MediaType.APPLICATION_JSON_VALUE // Apa yang diterima
    )
    public Address register(@PathVariable String customerId, @Valid @RequestBody AddAddressRequest request) {
        return addressService.addAddress(request.getCountry(),
                request.getProvince(),
                request.getCity(),
                request.getStreet(),
                customerId);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE // Apa yang dikirim
    )
    public Address getAddress(@PathVariable String customerId, @PathVariable String id) {
        return addressService.getAddress(id, customerId);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE // Apa yang dikirim
    )
    public List<Address> getAllAddresses(@PathVariable String customerId) {
        return addressService.getAllAddresses(customerId);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE // Apa yang dikirim
    )
    public Boolean deleteAddresss(@PathVariable String customerId, @PathVariable String id) {
        return addressService.deleteAddress(id, customerId);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE, // Apa yang dikirim
            consumes = MediaType.APPLICATION_JSON_VALUE // Apa yang diterima
    )
    public Address editAddress(@PathVariable String customerId, @PathVariable String id,
                               @Valid @RequestBody AddAddressRequest request) {
        Address address = new Address();
        Customer customer = new Customer();

        customer.setId(customerId);

        address.setId(id);
        address.setCountry(request.getCountry());
        address.setProvince(request.getProvince());
        address.setCity(request.getCity());
        address.setStreet(request.getStreet());
        address.setCustomer(customer);

        return addressService.editAddress(address);
    }

}
