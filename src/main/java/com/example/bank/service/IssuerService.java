package com.example.bank.service;

import com.example.bank.domain.entity.Issuer;
import com.example.bank.repository.IssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class IssuerService {
    @Autowired
    private IssuerRepository issuerRepository;

    public Issuer getById(Long id) {
        return this.issuerRepository.findById(id).get();
    }

    public List<Issuer> getAll(Issuer issuer) {
        return this.issuerRepository.findAll();
    }

    public Issuer create(Issuer issuer) {
        return issuerRepository.save(issuer);
    }

    public Issuer update(Issuer issuer) {
        return issuerRepository.save(issuer);
    }

    public void delete(Long id) {
        issuerRepository.delete(issuerRepository.findById(id).get());
    }
}
