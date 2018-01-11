package com.blibli.future.phase2.springbootphase2.service.impl;

import com.blibli.future.phase2.springbootphase2.model.Address;
import com.blibli.future.phase2.springbootphase2.model.Customer;
import com.blibli.future.phase2.springbootphase2.repository.CustomerRepository;
import com.blibli.future.phase2.springbootphase2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer register(String name, Address address) {
        Customer customer = new Customer();

        address.setId(UUID.randomUUID().toString());

        customer.setId(UUID.randomUUID().toString());
        customer.setName(name);
        customer.addAddress(address);

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(String id) {
        return customerRepository.findOne(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Boolean deleteCustomer(String id) {
        Boolean isSuccess = true;

        try {
            customerRepository.delete(id);
        } catch (Exception e) {
            isSuccess = false;
        }

        return isSuccess;
    }

    @Override
    public Customer editCustomer(Customer customer) {
        return customerRepository.exists(customer.getId()) ? customerRepository.save(customer) : null;
    }
}
