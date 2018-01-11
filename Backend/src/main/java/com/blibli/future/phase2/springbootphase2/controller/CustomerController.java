package com.blibli.future.phase2.springbootphase2.controller;

import com.blibli.future.phase2.springbootphase2.model.Customer;
import com.blibli.future.phase2.springbootphase2.request.RegisterCustomerRequest;
import com.blibli.future.phase2.springbootphase2.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, // Apa yang dikirim
            consumes = MediaType.APPLICATION_JSON_VALUE // Apa yang diterima
    )
    public Customer register(@Valid @RequestBody RegisterCustomerRequest request) {
        return customerService.register(request.getName(), request.getAddress());
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE // Apa yang dikirim
    )
    public Customer getCustomer(@PathVariable String id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE // Apa yang dikirim
    )
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE // Apa yang dikirim
    )
    public Boolean deleteCustomers(@PathVariable String id) {
        return customerService.deleteCustomer(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE, // Apa yang dikirim
            consumes = MediaType.APPLICATION_JSON_VALUE // Apa yang diterima
    )
    public Customer editCustomer(@PathVariable String id, @Valid @RequestBody RegisterCustomerRequest request) {
        Customer customer = new Customer();

        customer.setId(id);
        customer.setName(request.getName());

        return customerService.editCustomer(customer);
    }

}
