package com.blibli.future.phase2.springbootphase2.repository;

import com.blibli.future.phase2.springbootphase2.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

    List<Address> findAllByCustomerId(String customerId);
    Address findAddressByIdAndCustomerId(String id, String customerId);
    boolean existsAddressByIdAndCustomerId(String id, String customerId);
    void deleteAddressByIdAndCustomerId(String id, String customerId);
}
