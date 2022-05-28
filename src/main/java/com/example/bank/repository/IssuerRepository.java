package com.example.bank.repository;

import com.example.bank.domain.entity.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IssuerRepository extends JpaRepository<Issuer,Long> {
}
