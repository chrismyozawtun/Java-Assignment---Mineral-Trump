package com.company;

import java.util.ArrayList;

/**
 * Created by jc320588 on 20/09/16.
 */
public class SuperTrumpPlayers {
    private int playerCount;
    private int position;
    private int id;
    private ArrayList<SuperTrumpCard> cards;
    private boolean skipTurn = false;

    public SuperTrumpPlayers(int id) {
        this.id = id;
    }

    public void setCards(ArrayList<SuperTrumpCard> cards) {
        this.cards = cards;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void drawCard(SuperTrumpCard drewCard) {
        cards.add(drewCard);
        System.out.println("Player drew a card");
        skipTurn = true;
    }

    public int getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public ArrayList getCards() {
        return cards;
    }

    public SuperTrumpCard getOneCard(int index) {
        return cards.get(index);
    }

    public boolean getSkip() {
        return skipTurn;
    }

    public void printCardsforPlay() {
        System.out.println("You are position " + position + " and ID is " + id + "\nYour hand is: ");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println("#" + i + " = " + String.valueOf(cards.get(i)) + "   Hardness: " + cards.get(i).getHardness() + " Specific gravity: " + cards.get(i).getSpecifc_gravity() + " Cleavage: " + cards.get(i).getCleavage() + " Crustal Abundance: " + cards.get(i).getCrustal_abundance() + " Economic value: " + cards.get(i).getEconomic_value());
        }
    }

    public SuperTrumpCard playCard(int index) {
        SuperTrumpCard removedCard;
        System.out.println("The card is: " + cards.get(index).gettittle());
        removedCard = cards.remove(index);
        return removedCard;
    }

    public String toString() {
        return "position = " + position;

    }
}
