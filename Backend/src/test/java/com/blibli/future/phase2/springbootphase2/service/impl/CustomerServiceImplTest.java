package com.blibli.future.phase2.springbootphase2.service.impl;

import com.blibli.future.phase2.springbootphase2.model.Customer;
import com.blibli.future.phase2.springbootphase2.repository.CustomerRepository;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;

public class CustomerServiceImplTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Test
    public void testRegisterSuccess() {
//        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).then(new Answer<Customer>() {
//
//            @Override
//            public Customer answer(InvocationOnMock invocationOnMock) throws Throwable {
//                return (Customer) invocationOnMock.getArguments()[0];
//            }
//        });
//
//        Customer customer = customerServiceImpl.register("Faza Zulfika P P");
//
//        assertNotNull(customer.getId());
//        assertEquals("Faza Zulfika P P", customer.getName());
//
//        Mockito.verify(customerRepository, Mockito.times(1)).save(Mockito.any(Customer.class));
    }

    @Test
    public void testRegisterError() {

    }
}