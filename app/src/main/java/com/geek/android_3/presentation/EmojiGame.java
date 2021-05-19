package com.geek.android_3.presentation;

import com.geek.android_3.domain.Card;
import com.geek.android_3.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class EmojiGame {
    private final Game<String> game;

    public EmojiGame(){
        List<String> cardContent = new ArrayList<>();
        cardContent.add("\uD83E\uDDDF\u200D♂️");//4
        cardContent.add("\uD83E\uDDDC");//4
        cardContent.add("\uD83C\uDF55");//4
        cardContent.add("\uD83C\uDF69");
        cardContent.add("\uD83C\uDF4E");//4
        cardContent.add("\uD83C\uDF40");
        game = new Game<>(cardContent);
    }
 public void cardClick(Card<String> card){
       game.cardClick(card);
 }
 public List<Card<String>> getCards(){
        return  game.getCards();
 }
}
