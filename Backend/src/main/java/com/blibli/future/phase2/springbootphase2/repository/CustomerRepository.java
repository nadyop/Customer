package com.blibli.future.phase2.springbootphase2.repository;

import com.blibli.future.phase2.springbootphase2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {


}
