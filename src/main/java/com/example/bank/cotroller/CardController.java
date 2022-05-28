package com.example.bank.cotroller;

import com.example.bank.domain.entity.Card;
import com.example.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/cards/{id}")
    public Card getById(@PathVariable("id") Long id) {
        return cardService.getById(id);
    }

    @GetMapping("/cards")
    public List<Card> getAll(Card card) {
        return cardService.getAll(card);
    }

    @PostMapping("/cards")
    public Card create(@Valid @RequestBody Card card) {
        return cardService.create(card);
    }

    @PostMapping("/cards/{active}")
    public void activeCard(@Valid @PathVariable("active") Long id) {
        cardService.activeCard(id);
    }

    @PostMapping("/cards/{blocked}")
    public void blockedCard(@Valid @PathVariable("blocked") Long id) {
        cardService.blockCard(id);
    }

    @PutMapping("/cards")
    public Card update(@Valid @RequestBody Card card) {
        return cardService.update(card);
    }

    @DeleteMapping("/cards/{id}")
    public void delete(@PathVariable("id") Long id) {
        cardService.delete(id);
    }
}
