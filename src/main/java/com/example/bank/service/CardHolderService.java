package com.example.bank.service;

import com.example.bank.domain.entity.Card;
import com.example.bank.domain.entity.CardHolder;
import com.example.bank.exeptoion.NotEnough;
import com.example.bank.exeptoion.RecursNotFound;
import com.example.bank.repository.CardHolderRepository;
import com.example.bank.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@SuppressWarnings("ALL")
@Service
public class CardHolderService {
    @Autowired
    private CardHolderRepository cardHolderRepository;
    @Autowired
    private CardRepository cardRepository;

    public CardHolder getById(Long id) {
        return this.cardHolderRepository.findById(id).get();
    }

    public List<CardHolder> getAll(CardHolder cardHolder) {
        return this.cardHolderRepository.findAll();
    }

    public CardHolder create(CardHolder cardHolder) {
        return cardHolderRepository.save(cardHolder);
    }

    public CardHolder update(CardHolder cardHolder) {
        return cardHolderRepository.save(cardHolder);
    }

    public void delete(Long id) {
        cardHolderRepository.delete(cardHolderRepository.findById(id).get());
    }

    public Set<Card> findCardsByCardHolder(Long cardHolderID) {
        return cardRepository.findCardByCardHolderId(cardHolderID);
    }

    public void card2Card(long money, String cardNumberFrom, String cardNumberTo) {
        Optional<Card> cardFrom = cardRepository.findCardByCardNumber(cardNumberFrom);
        Optional<Card> cardTo = cardRepository.findCardByCardNumber(cardNumberTo);
        if (cardFrom.isEmpty()) {
            throw new RecursNotFound(cardNumberFrom + " card number does not exist");
        }
        if (cardTo.isEmpty()) {
            throw new RecursNotFound(cardNumberTo + " card number does not exist");
        }
        if (cardFrom.get().getBalance() < money) {
            throw new NotEnough("Balance not enough");
        }
        Card cardFr = cardFrom.get();
        Card cardT = cardTo.get();
        cardFr.setBalance(cardFr.getBalance() - money);
        cardT.setBalance(cardT.getBalance() + money);
    }
}
