package com.example.bank.repository;

import com.example.bank.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    Set<Card> findCardByCardHolderId(Long cardHolderId);

    Optional<Card> findCardByCardNumber(String cardNumberFrom);
}
