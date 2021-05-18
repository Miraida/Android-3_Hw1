package com.geek.android_3.domain;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Game<CardContent> {

    private final List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> cardContents) {
        for (int i = 0; i < cardContents.size(); i++) {
            cards.add(new Card<>(i + 1, false, false, cardContents.get(i)));
            cards.add(new Card<>((i + 1) * 2, false, false, cardContents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void cardClick(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        for (Card<CardContent> currentCard: cards) {
            if (currentCard.getId() != card.getId() && currentCard.isFaceUp()
                    && card.getContent().equals(currentCard.getContent())) {
                card.setMatched(true);
                currentCard.setMatched(true);
            }
            if (currentCard.getId() != card.getId() && currentCard.isFaceUp()
                    && !card.getContent().equals(currentCard.getContent())){
                currentCard.setFaceUp(false);
            }
        }
    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }
}
