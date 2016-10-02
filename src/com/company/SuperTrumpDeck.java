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
            cards.add(new SuperTrumpCard(i));
            //google how to create random array of integers. Non repeating integers
        }
    }

    public void buildDeck() {
//
//        try {
//            File cardsMaster = new File("project_mineral_super_trumps_game-master/CardsXml.xml");
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(cardsMaster);
//
//            doc.getDocumentElement().normalize();
//
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//            NodeList nList = doc.getElementsByTagName("cards");
//            System.out.println("----------------------------");
//
//            for (int temp = 0; temp < nList.getLength(); temp++) {
//                Node nNode = nList.item(temp);
//                System.out.println("\nCurrent Element :" + nNode.getNodeName());
//                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                }
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }}
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
}


