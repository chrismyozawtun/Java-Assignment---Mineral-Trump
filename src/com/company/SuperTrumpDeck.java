package com.company;

import java.util.ArrayList;

/**
 * Created by jc320588 on 20/09/16.
 */
public class SuperTrumpDeck {
    private static final int INITIAL_NUM_CARDS = 60;
    private ArrayList<SuperTrumpCard> cards;


    //// TODO: 20/09/16 List of all the cards
    public SuperTrumpDeck(){
        cards = new ArrayList<SuperTrumpCard>(cards.size());

        for (int i = 0; i < cards.size(); i++) {
             cards.add(new SuperTrumpCard());
            //google how to create random array of integers. Non repeating integers
            
        }
    }
    public ArrayList<SuperTrumpCard> dealCards(int amountToDeal) {
        return null;
    }
}
