package com.example.bank.service;

import com.example.bank.domain.entity.Card;
import com.example.bank.domain.enumType.CardStatus;
import com.example.bank.repository.CardRepository;
import com.example.bank.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card getById(Long id){
        return this.cardRepository.findById(id).get();
    }
    public List<Card> getAll(Card card){
        return this.cardRepository.findAll();
    }
    public void activeCard(Long id){
        Card card = cardRepository.findById(id).get();
        card.setStatus(CardStatus.ACTIVE);
        cardRepository.save(card);
    }
    public void blockCard(Long id){
        Card card = cardRepository.findById(id).get();
        card.setStatus(CardStatus.BLOCKED);
        cardRepository.save(card);
    }
    public Card create(Card card) {
        card.setCvc(MyUtil.encodedCvc());
        card.setPin(MyUtil.encodedPin());
        card.setCardNumber(MyUtil.cardGenerator());
        return cardRepository.save(card);
    }
    public Card update(Card card) {
        return cardRepository.save(card);
    }
    public void delete(Long id){
        cardRepository.delete(cardRepository.findById(id).get());
    }
}
