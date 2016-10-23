package com.company;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by jc320588 on 23/10/16.
 */
public class GuiSuperTrumpPlayers extends JPanel{

    SuperTrumpPlayers human;
//    JLabel playername = new JLabel("Humans position is " + String.valueOf(human.getId()));
    JLabel playername = new JLabel("Random label");

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
            GuiSuperTrumpCard cardview = new GuiSuperTrumpCard(i, card, human);
            System.out.println(card);
            add(cardview);
            repaint();
        }

    }
}
