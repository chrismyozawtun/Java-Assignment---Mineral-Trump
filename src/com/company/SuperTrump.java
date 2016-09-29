package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import static sun.audio.AudioPlayer.player;

public class SuperTrump {
    private int playerCount;
    private static final int DEAL_AMOUNT = 8;

    private SuperTrumpPlayers[] players;
    private SuperTrumpDeck deck;


    public SuperTrump(int playerCount) {
        this.playerCount = playerCount;
        deck = new SuperTrumpDeck();

    }

    public void assignPositions(int playerCount) {
        ArrayList<Integer> playerPositions = new ArrayList<Integer>();
        for (int i = 1; i < playerCount + 1; i++) {
            playerPositions.add(i);
        }
        Collections.shuffle(playerPositions);
        for (int i = 0; i < playerCount; i++) {
            System.out.println(playerPositions.get(i));
        }

        players = new SuperTrumpPlayers[playerCount];
        for (int i = 0; i < playerCount ; i++) {
            players[i] = new SuperTrumpPlayers(playerPositions.get(i));
        }
    }



    public void dealCards() {
        for (SuperTrumpPlayers player : players) {
                ArrayList<SuperTrumpCard> cards = deck.dealCards(DEAL_AMOUNT);
                player.setCards(cards);
                System.out.println(player + "Player position " + player.getPosition() + " hand is " + cards);
            }
        }

    public void showPlayerCards(int position) {
        position = position - 1;
        System.out.println(players[position].getCards());
    }

    public void selectHumanPlayer() {

    }

//    public void showPlayerCards(int position) {
//        System.out.println(players[3]);;
//
//    }
}



