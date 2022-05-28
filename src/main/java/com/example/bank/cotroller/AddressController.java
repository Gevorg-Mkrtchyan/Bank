package com.example.bank.cotroller;

import com.example.bank.domain.entity.Address;
import com.example.bank.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{id}")
    public Address getById(@PathVariable("id") Long id) {
        return addressService.getByID(id);
    }

    @GetMapping("/address")
    public List<Address> getAll(Address address) {
        return addressService.getAll(address);
    }

    @PostMapping("/address")
    public Address create(@Valid @RequestBody Address address) {
        return addressService.create(address);
    }

    @PutMapping("/address")
    public Address update(@Valid @RequestBody Address address) {
        return addressService.update(address);
    }

    @DeleteMapping("/address/{id}")
    public void delete(@PathVariable("id") Long id) {
        addressService.delete(id);
    }
}
