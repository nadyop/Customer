package com.gdn.future.restapispringboot.controller;

import com.gdn.future.restapispringboot.model.Customer;
import com.gdn.future.restapispringboot.request.RegisterCustomerRequest;
import com.gdn.future.restapispringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(
            value = "/customers",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer register(@Valid @RequestBody RegisterCustomerRequest request){
        return customerService.register(request);
    }

    @RequestMapping(
            value = "/customers/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }

    @RequestMapping(
            value = "/customers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @RequestMapping(
            value = "/customers/{id}",
            method = RequestMethod.DELETE
    )
    public void deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
    }

    @RequestMapping(
            value = "/customers/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer updateObject(@PathVariable String id, @Valid @RequestBody RegisterCustomerRequest request){
        return customerService.updateCustomer(id, request);
    }
}