package com.pushkar.deckofcards.controller;

import com.pushkar.deckofcards.model.Card;
import com.pushkar.deckofcards.service.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class DeckController {

    @Autowired
    Deck deck;

    @GetMapping("/shuffle")
    @ResponseBody
    public ResponseEntity shuffleCard() {
        deck.shuffle();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/deal")
    public Card dealOneCard() {
        return deck.dealOneCard();
    }
}
