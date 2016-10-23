package com.company;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by jc320588 on 23/10/16.
 */
public class GuiSuperTrumpPlayers extends JPanel{

    SuperTrumpPlayers human;
    GuiSuperTrumpCard cardview;
//    JLabel playername = new JLabel("Humans position is " + String.valueOf(human.getId()));
    JLabel playername = new JLabel("Your \n Hand");

    public GuiSuperTrumpPlayers(SuperTrumpPlayers human) {
        this.human = human;

        add(playername);
        
        addAllCards();
        repaint();
    }

    private void addAllCards() {
        ArrayList<SuperTrumpCard> cards = human.getCards();

        for (int i = 0; i < cards.size(); i++) {
            SuperTrumpCard card = cards.get(i);
            cardview = new GuiSuperTrumpCard(i, card, human);
            System.out.println(card);
            add(cardview);
            repaint();
        }

    }

    public int getcardInput(){
        return cardview.getInput();
    }
}
