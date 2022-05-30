package com.example.bank.cotroller;

import com.example.bank.domain.entity.Card;
import com.example.bank.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/cards/{id}")
    @ApiOperation("get card by id")
    public Card getById(@PathVariable("id") Long id) {
        return cardService.getById(id);
    }

    @GetMapping("/cards")
    @ApiOperation("get all cards")
    public List<Card> getAll(Card card) {
        return cardService.getAll(card);
    }

    @PostMapping("/cards")
    @ApiOperation("create card")
    public Card create(@Valid @RequestBody Card card) {
        return cardService.create(card);
    }

    @PostMapping("/cards/{active}")
    @ApiOperation("active card")
    public void activeCard(@Valid @PathVariable("active") Long id) {
        cardService.activeCard(id);
    }

    @PostMapping("/cards/{blocked}")
    @ApiOperation("blocked card")
    public void blockedCard(@Valid @PathVariable("blocked") Long id) {
        cardService.blockCard(id);
    }

    @PutMapping("/cards")
    @ApiOperation("update card")
    public Card update(@Valid @RequestBody Card card) {
        return cardService.update(card);
    }

    @DeleteMapping("/cards/{id}")
    @ApiOperation("delete card by id")
    public void delete(@PathVariable("id") Long id) {
        cardService.delete(id);
    }
}
