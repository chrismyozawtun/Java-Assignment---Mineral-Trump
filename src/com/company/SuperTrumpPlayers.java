package com.company;

import java.util.ArrayList;

/**
 * Created by jc320588 on 20/09/16.
 */
public class SuperTrumpPlayers {
    private int playerCount;
    private int position;
//    private int dealerPosition = 1;
    private int id;
    private ArrayList<SuperTrumpCard> cards;
    private boolean skipTurn = false;
    
//    // TODO: 3/10/16 Skip turn if draw card 

    public SuperTrumpPlayers(int id){
        this.id = id;
    }

    public void setCards(ArrayList<SuperTrumpCard> cards) {
        this.cards = cards;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public void drawCard(SuperTrumpCard drewCard){
        cards.add(drewCard);
        System.out.println("Player drew a card");
        skipTurn = true;
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

    public SuperTrumpCard getOneCard(int index){
        return cards.get(index);
    }

    public boolean getSkip(){
        return skipTurn;
    }

    public void printCards(){
        for (int i = 0; i < cards.size() ; i++) {
            System.out.println("#" + i + " = " + String.valueOf(cards.get(i)) + " ");
        }
    }

    public void printCardsforPlay(){
        System.out.println("You are position " + position + " and ID is " + id + "\nYour hand is: ");
        for (int i = 0; i < cards.size() ; i++) {
            System.out.println("#" + i + " = " + String.valueOf(cards.get(i)));
        }
    }

    public SuperTrumpCard playCard(int index){
        SuperTrumpCard removedCard;
        System.out.printf("The card is: " + cards.get(index).getID());
        removedCard = cards.remove(index);
        return removedCard;
    }

    public void setPlayerCount(int playerCount){
        this.playerCount = playerCount;
    }

    public String toString(){
        return "position = " + position;

    }
}
