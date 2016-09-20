package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jc320588 on 20/09/16.
 */
public class SuperTrump {
    private int playerCount;
    private static final int DEAL_AMOUNT = 8;

    private SuperTrumpPlayers[] players;
    private SuperTrumpDeck deck;



    public SuperTrump (int playerCount){
        this.playerCount = playerCount;

    }


    public void assignPositions() {
        int x = 0;
        while (x < playerCount){
        Random rand = new Random();
        int positions = rand.nextInt(playerCount);
        System.out.println(positions);
        x++;
        }
        
        //// TODO: 20/09/16 Finish assign postiions. Need to set each player a number that hasn't been done yet.

    }

    public void dealCards(int playerCount) {
        players = new SuperTrumpPlayers[playerCount];

        for (SuperTrumpPlayers player : players) {
            ArrayList <SuperTrumpCard> card = deck.dealCards(DEAL_AMOUNT);
            player.setCards();
        }

        
    }
}
