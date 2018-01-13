package com.gdn.future.restapispringboot.service.impl;

import com.gdn.future.restapispringboot.model.Customer;
import com.gdn.future.restapispringboot.repositories.CustomerRepository;
import com.gdn.future.restapispringboot.request.RegisterCustomerRequest;
import com.gdn.future.restapispringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer register(RegisterCustomerRequest request) {
        Customer customer = new Customer();

        customer.setId(UUID.randomUUID().toString());
        customer.setName(request.getName());

        return customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    @Override
    public Customer getCustomer(String id) {
        return customerRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer updateCustomer(String id, RegisterCustomerRequest request){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(request.getName());
        return customerRepository.save(customer);
    }
}