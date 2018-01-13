package com.gdn.future.restapispringboot.service;


import com.gdn.future.restapispringboot.model.Customer;
import com.gdn.future.restapispringboot.request.RegisterCustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    Customer register(RegisterCustomerRequest request);
    Customer getCustomer(String id);
    List<Customer> getAllCustomer();
    void deleteCustomer(String id);
    Customer updateCustomer(String id, RegisterCustomerRequest request);
}
