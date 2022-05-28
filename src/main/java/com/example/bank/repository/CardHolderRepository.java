package com.example.bank.repository;

import com.example.bank.domain.entity.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardHolderRepository extends JpaRepository<CardHolder,Long> {

}
