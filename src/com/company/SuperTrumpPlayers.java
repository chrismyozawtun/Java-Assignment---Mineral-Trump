package com.company;

import com.company.SuperTrump;

import java.util.ArrayList;

/**
 * Created by jc320588 on 20/09/16.
 */
public class SuperTrumpPlayers {
    private int playerCount;
    private int position;
    private int dealerPosition = 1;
    private int id;
    private ArrayList<SuperTrumpCard> cards;

    public SuperTrumpPlayers(int id){
        this.id = id;
    }

    public void setCards(ArrayList<SuperTrumpCard> cards) {
        this.cards = cards;
    }

    public void setPosition(int position){
        this.position = position;
    }


    public int getPosition(){
        return position;
    }

    public int getId(){
        return id;
    }

    public ArrayList getCards(){
        return cards;
    }

    public void printCards(){
        for (int i = 0; i < cards.size() ; i++) {
            System.out.println("#" + i + " = " + String.valueOf(cards.get(i)) + " ");
        }
    }

    public void playCard(int index){
        SuperTrumpCard removedCard;
        removedCard = cards.remove(index);
//        return removedCard;
    }

    public void setPlayerCount(int playerCount){
        this.playerCount = playerCount;
    }

    public String toString(){
        return "position = " + position;

    }
}
