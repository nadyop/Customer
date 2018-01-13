package com.gdn.future.restapispringboot.repositories;

import com.gdn.future.restapispringboot.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

    List<Address> findAddressByCustomerId(String customerId);
    Address findAddressByIdAndCustomerId(String id, String customerId);
    boolean existsAddressByIdAndCustomerId(String id, String customerId);
    void deleteAddressByIdAndCustomerId(String id, String customerId);
}
