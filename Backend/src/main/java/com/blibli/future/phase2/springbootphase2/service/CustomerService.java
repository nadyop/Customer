package com.blibli.future.phase2.springbootphase2.service;

import com.blibli.future.phase2.springbootphase2.model.Address;
import com.blibli.future.phase2.springbootphase2.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer register(String name, Address address);
    Customer getCustomer(String id);
    List<Customer> getAllCustomers();
    Boolean deleteCustomer(String id);
    Customer editCustomer(Customer customer);
}
