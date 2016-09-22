package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import static sun.audio.AudioPlayer.player;

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
        deck = new SuperTrumpDeck();

    }

    public void assignPositions(int playerCount) {
        ArrayList<Integer> playerPositions = new ArrayList<Integer>();
        for (int i=1; i<playerCount+1; i++) {
            playerPositions.add(i);
        }
        Collections.shuffle(playerPositions);
        for (int i=0; i<playerCount; i++) {
            System.out.print(playerPositions.get(i));
        }




        //// TODO: 20/09/16 Finish assign postiions. Need to set each player a number that hasn't been done yet.
    }

    public void dealCards() {
        players = new SuperTrumpPlayers[playerCount];
        for (SuperTrumpPlayers player : players) {
            ArrayList<SuperTrumpCard> cards = deck.dealCards(DEAL_AMOUNT);
            player.setCards(cards);
        }
        }
    }

//    public void dealCards() {
//        players = new SuperTrumpPlayers[playerCount];
//
//        for (SuperTrumpPlayers player : players) {
//            ArrayList <SuperTrumpCard> card = deck.dealCards(DEAL_AMOUNT);
//            player.setCards();
//        }
//    }

