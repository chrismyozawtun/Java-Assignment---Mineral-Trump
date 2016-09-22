package com.company;

import com.company.SuperTrump;

import java.util.ArrayList;

/**
 * Created by jc320588 on 20/09/16.
 */
public class SuperTrumpPlayers {
    private int playerCount;
    private int position;
    private ArrayList<SuperTrumpCard> cards;

    public SuperTrumpPlayers(int playerCount){
        this.playerCount = playerCount;

    }


    public void setCards(ArrayList<SuperTrumpCard> cards) {
        this.cards = cards;
    }

    public void setPosition(int position){
        this.position = position;
    }
}
