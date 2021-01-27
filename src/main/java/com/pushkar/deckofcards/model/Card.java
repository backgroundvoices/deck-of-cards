package com.pushkar.deckofcards.model;

import org.springframework.stereotype.Repository;

@Repository
public class Card {

    private int value;
    private String name;
    private SuitEnum suit;

    public Card() {
    }

    public Card(int value, String name, SuitEnum suit) {
        this.value = value;
        this.name = name;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SuitEnum getSuit() {
        return suit;
    }

    public void setSuit(SuitEnum suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", suit='" + suit.toString() + '\'' +
                '}';
    }
}

