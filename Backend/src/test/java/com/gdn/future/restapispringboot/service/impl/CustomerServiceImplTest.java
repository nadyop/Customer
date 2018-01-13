//package com.gdn.future.futureprogramwendy.service.impl;
//
//import com.gdn.future.restapispringboot.model.Customer;
//import com.gdn.future.restapispringboot.repositories.CustomerRepository;
//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnit;
//import org.mockito.junit.MockitoRule;
//
//public class CustomerServiceImplTest {
//
//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();
//
//    @Mock
//    private CustomerRepository customerRepository;
//
//    @InjectMocks
//    private CustomerServiceImpl customerService;
//
//    @Test
//    public void testRegisterSuccess(){
//        Mockito.when(customerRepository.save(Mockito.any(Customer.class)))
//                .then(invocation -> {
//                    return invocation.getArgumentAt(0, Customer.class);
//                });
//
//        Customer customer = customerService.register("Wendy", "Jakarta");
//
//        Assert.assertNotNull(customer.getId());
//        Assert.assertEquals("Wendy", customer.getName());
//        Assert.assertEquals("Jakarta", customer.getAddress());
//
//        Mockito.verify(customerRepository, Mockito.times(1))
//                .save(Mockito.any(Customer.class));
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void testRegisterError(){
//        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenThrow(new RuntimeException());
//
//        customerService.register("Wendy", "Jakarta");
//    }
//}