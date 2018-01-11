package com.blibli.future.phase2.springbootphase2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

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

    public void addAddress(Address address) {
        addresses.add(address);
        address.setCustomer(this);
    }

    public Address getAddress(String id) {
        int index = addresses.indexOf(id);
        return index != -1 ? addresses.get(index) : null;
    }

    public Address removeAddress(String id) {
        int index = addresses.indexOf(id);
        return index != -1 ? addresses.remove(index) : null;
    }

    public Address removeAddress(Address address) {
        return removeAddress(address.getId());
    }

//    public List<Address> getAddresses() {
//        return addresses;
//    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Customer && ((Customer) obj).getId().equals(id);
    }
}
