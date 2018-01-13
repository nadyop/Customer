package com.gdn.future.restapispringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Table(name = "customer")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "customer")
    @MapKey(name = "id")
    private Map<String, Address> addressMap = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAddress(Address address){
        addressMap.put(address.getId(), address);
        address.setCustomer(this);
    }

    public Address getAddress(String id){
        return addressMap.containsKey(id) ? addressMap.get(id) : null;
    }

    public Address removeAddress(String id){
        return addressMap.containsKey(id) ? addressMap.remove(id) : null;
    }

//    public Map<String, Address> getAddress() {
//        return addressMap;
//    }

    public void setAddress(Map<String, Address> address) {
        this.addressMap = address;
    }
}
