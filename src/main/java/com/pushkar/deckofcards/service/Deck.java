package com.pushkar.deckofcards.service;

import com.pushkar.deckofcards.model.Card;
import com.pushkar.deckofcards.model.SuitEnum;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Class to represent a deck of cards.
 * maintains a list of cards and a dealer index where all cards before it have been already dealt
 */
@Service
public class Deck {

    private static final int CARD_IN_A_SUITE = 13;  //all suits should have equal cards

    private static final Map<Integer, String> FACE_VALUE_MAP = new HashMap<>(Map.of(
            1, "ACE",
            11, "JACK",
            12, "QUEEN",
            13, "KING"));

    //deck of cards
    private List<Card> cards = new ArrayList<>();

    private Random random = new Random();

    private int dealerIndex = 0;  //tracks the index number of cards already dealt

    /**
     * Default Constructor
     * Initialize Deck of cards
     */
    public Deck() {
        initializeDeck();
    }

    /**
     * Deck of cards is provided - if not initialize using default values
     * @param cards
     */
    public Deck(Stack<Card> cards) {
        if (cards == null || cards.size() < 1) {
            initializeDeck();
        } else {
            this.cards = cards;
        }
    }

    /**
     * Shuffle the deck
     * loop through the cards - at each index pick a random position and swap the cards
     * every card will be shuffled at least once
     */
    public void shuffle() {
        for (int i=0; i<cards.size(); i++) {
            int randomPos = random.nextInt(cards.size() - 1);
            Card tempCard = cards.get(i);
            cards.set(i, cards.get(randomPos));
            cards.set(randomPos, tempCard);
        }
        dealerIndex = 0; //reset dealer index
    }

    /**
     * Deal one card from the deck
     * Since the list is already shuffled and is in random order we will return the card sequentially
     * @return
     */
    public Card dealOneCard() {
        if (dealerIndex < cards.size()) {
            return cards.get(dealerIndex++);
        }
        return null;  //all cards have been dealt
    }

    /**
     * initialize the deck
     * add each card from each suit to the list
     */
    private void initializeDeck() {
        Arrays.stream(SuitEnum.values()).forEach(suit -> {
            IntStream.range(1, CARD_IN_A_SUITE + 1).forEach(val -> {
                String name = String.valueOf(val);
                if (FACE_VALUE_MAP.containsKey(val)) {
                    name = FACE_VALUE_MAP.get(val);
                }
                cards.add(new Card(val, name, suit));
            });
        });
    }
}

