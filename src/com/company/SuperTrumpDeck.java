package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jc320588 on 20/09/16.
 */
public class SuperTrumpDeck {
    private static final int INITIAL_NUM_CARDS = 60;
    private ArrayList<SuperTrumpCard> cards;

    //// TODO: 20/09/16 List of all the cards

    public SuperTrumpDeck(){
        cards = new ArrayList<SuperTrumpCard>();

        for (int i = 0; i < INITIAL_NUM_CARDS; i++) {
             cards.add(new SuperTrumpCard(i));
            //google how to create random array of integers. Non repeating integers
        }
    }
    public ArrayList<SuperTrumpCard> dealCards(int numCards) {

        ArrayList<SuperTrumpCard> retn = new ArrayList<SuperTrumpCard>();
        for (int i = 0; i < numCards; i++){
            int indx = new Random().nextInt(cards.size());
            SuperTrumpCard card = cards.remove(indx);
            retn.add(card);
        }
//        System.out.println("Hand is " +retn);
        return retn;
    }
}
