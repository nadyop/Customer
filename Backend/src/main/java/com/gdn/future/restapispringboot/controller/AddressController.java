package com.gdn.future.restapispringboot.controller;

import com.gdn.future.restapispringboot.model.Address;
import com.gdn.future.restapispringboot.request.RegisterAddressRequest;
import com.gdn.future.restapispringboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping(
            value = "/customers/{id}/addresses",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Address register(@PathVariable(value = "id") String idCustomer, @Valid @RequestBody RegisterAddressRequest request){
        return addressService.addAddress(idCustomer, request);
    }

    @RequestMapping(
            value = "/customers/{id}/addresses/{addrId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Address getAddress(@PathVariable(value = "id") String id, @PathVariable(value = "addrId") String idAddress){
        return addressService.getAddress(id, idAddress);
    }

    @RequestMapping(
            value = "/customers/{id}/addresses",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Address> getAllAddress(@PathVariable String id){
        return addressService.getAllAddress(id);
    }

    @RequestMapping(
            value = "/customers/{id}/addresses/{addrId}",
            method = RequestMethod.DELETE
    )
    public void deleteAddress(@PathVariable(name = "id") String id, @PathVariable(name = "addrId") String idAddress){
        addressService.deleteAddress(id, idAddress);
    }

    @RequestMapping(
            value = "/customers/{id}/addresses/{addrId}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Address updateObject(@PathVariable(value = "id") String id, @PathVariable(value = "addrId") String idAddress, @Valid @RequestBody RegisterAddressRequest request){
        return addressService.updateAddress(id, idAddress, request);
    }

}
