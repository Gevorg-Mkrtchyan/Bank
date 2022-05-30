package com.example.bank.cotroller;

import com.example.bank.domain.entity.Card;
import com.example.bank.domain.entity.CardHolder;
import com.example.bank.service.CardHolderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@Api
public class CardHolderController {
    @Autowired
    private CardHolderService cardHolderService;

    @GetMapping("/cardholders/{id}")
    @ApiOperation("get cardholder by id")
    public CardHolder getById(@PathVariable("id") Long id) {
        return cardHolderService.getById(id);
    }

    @GetMapping("/cardholders/{cards}")
    @ResponseStatus(HttpStatus.FOUND)
    @ApiOperation("get all cards by id")
    public Set<Card> getAllCards(@PathVariable("cards") Long id) {
        return cardHolderService.findCardsByCardHolder(id);
    }

    @GetMapping("/cardholders")
    @ApiOperation("get all cardholders")
    public List<CardHolder> getAll(CardHolder cardHolder) {
        return cardHolderService.getAll(cardHolder);
    }

    @PostMapping("/cardholders")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("create cardholder")
    public CardHolder create(@Valid @RequestBody CardHolder cardHolder) {
        return cardHolderService.create(cardHolder);
    }

    @PutMapping("/cardholders")
    @ApiOperation("update cardholder")
    public CardHolder update(@Valid @RequestBody CardHolder cardHolder) {
        return cardHolderService.update(cardHolder);
    }

    @DeleteMapping("/cardholders/{id}")
    @ApiOperation("delete cardholder by id")
    public void delete(@PathVariable("id") Long id) {
        cardHolderService.delete(id);
    }
    @PostMapping("/cardholders/{money,cardNumberFrom,cardNumberTo}")
    @ApiOperation("transfer card to card")
      public void cardToCard(@RequestBody @PathVariable long money, String cardNumberFrom, String cardNumberTo){
        cardHolderService.cardToCard(money,cardNumberFrom,cardNumberTo);
      }
}
