package com.example.bank.cotroller;

import com.example.bank.domain.entity.Card;
import com.example.bank.domain.entity.CardHolder;
import com.example.bank.service.CardHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CardHolderController {
    @Autowired
    private CardHolderService cardHolderService;

    @GetMapping("/cardholders/{id}")
    public CardHolder getById(@PathVariable("id") Long id) {
        return cardHolderService.getById(id);
    }

    @GetMapping("/cardholders/{cards}")
    @ResponseStatus(HttpStatus.FOUND)
    public Set<Card> getAllCards(@PathVariable("cards") Long id) {
        return cardHolderService.findCardsByCardHolder(id);
    }

    @GetMapping("/cardholders")
    public List<CardHolder> getAll(CardHolder cardHolder) {
        return cardHolderService.getAll(cardHolder);
    }

    @PostMapping("/cardholders")
    @ResponseStatus(HttpStatus.CREATED)
    public CardHolder create(@Valid @RequestBody CardHolder cardHolder) {
        return cardHolderService.create(cardHolder);
    }

    @PutMapping("/cardholders")
    public CardHolder update(@Valid @RequestBody CardHolder cardHolder) {
        return cardHolderService.update(cardHolder);
    }

    @DeleteMapping("/cardholders/{id}")
    public void delete(@PathVariable("id") Long id) {
        cardHolderService.delete(id);
    }
}
