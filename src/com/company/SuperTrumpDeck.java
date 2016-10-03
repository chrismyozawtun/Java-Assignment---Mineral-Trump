package com.company;

import jdk.nashorn.internal.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
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
        cards = new ArrayList<>();

        for (int i = 0; i < INITIAL_NUM_CARDS; i++) {
            cards.add(new SuperTrumpCard(i, "Slide01.jpg","Slide01","play","Quartz","SiO_2","tectosilicate","hexagonal",7,2.65,"poor/none","high","moderate","igneous, metamorphic, sedimentary"));
            //google how to create random array of integers. Non repeating integers
        }
    }

    public ArrayList getCards(){
        return cards;
    }

    public void buildDeck() {

    }

    public SuperTrumpCard getOneCard(){
        int indx = new Random().nextInt(cards.size());
        return(cards.remove(indx));
    }

    public ArrayList<SuperTrumpCard> dealCards(int numCards) {

        ArrayList<SuperTrumpCard> retn = new ArrayList<SuperTrumpCard>();
        for (int i = 0; i < numCards; i++){
            int indx = new Random().nextInt(cards.size());
            SuperTrumpCard card = cards.remove(indx);
            retn.add(card);
        }
        return retn;
    }

    public void shuffleInTableCards(ArrayList<SuperTrumpCard> tableCards) {
        for (int i = 0; i < tableCards.size(); i++) {
            cards.add(tableCards.get(i));
        }
    }
}


