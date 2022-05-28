package com.example.bank.service;

import com.example.bank.domain.entity.Address;
import com.example.bank.repository.AddressRepository;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address getByID(Long id) {
        return this.addressRepository.findById(id).get();
    }

    public List<Address> getAll(Address address) {
        return this.addressRepository.findAll();
    }

    public Address create(Address address) {
        return addressRepository.save(address);
    }

    public Address update(Address address) {
        return addressRepository.save(address);
    }

    public void delete(Long id) {
        addressRepository.delete(addressRepository.findById(id).get());
    }
}