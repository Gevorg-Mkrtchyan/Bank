package com.example.bank.cotroller;

import com.example.bank.domain.entity.Issuer;
import com.example.bank.service.IssuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IssuerController {
    @Autowired
    private IssuerService issuerService;

    @GetMapping("/issuers/{id}")
    public Issuer getById(@PathVariable("id") Long id) {
        return issuerService.getById(id);
    }

    @GetMapping("/issuers")
    public List<Issuer> getAll(Issuer issuer) {
        return issuerService.getAll(issuer);
    }

    @PostMapping("/issuers")
    public Issuer create(@Valid @RequestBody Issuer issuer) {
        return issuerService.create(issuer);
    }

    @PutMapping("/issuers")
    public Issuer update(@Valid @RequestBody Issuer issuer) {
        return issuerService.update(issuer);
    }

    @DeleteMapping("/issuers/{id}")
    public void delete(@PathVariable("id") Long id) {
        issuerService.delete(id);
    }
}
