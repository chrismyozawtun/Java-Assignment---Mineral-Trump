package com.company;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by jc320588 on 23/10/16.
 */
public class GuiSuperTrumpCard extends JPanel {

    SuperTrumpCard card;
    SuperTrumpPlayers human;
    int id;
    JLabel cardName;


    public GuiSuperTrumpCard(int id, SuperTrumpCard card, SuperTrumpPlayers human) {
        this.card = card;
        this.id = id;
        this.human = human;

        cardName = new JLabel(card.gettittle());

        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                cardName.setText("I cliced");
                playCard();
                super.mouseClicked(e);
            }
        });
        add(cardName);
    }

    private int playCard() {
        System.out.println("the card played was " + card.gettittle() + " and its id was " + card.getID() + " and its index was " + id);
        return card.getID();
    }

    public int getInput(){
        return id;
    }


}
