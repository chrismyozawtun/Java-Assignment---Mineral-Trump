package com.company;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by jc320588 on 23/10/16.
 */
public class GuiSuperTrumpCard extends JPanel {

    SuperTrumpCard card;

    JLabel cardName;


    public GuiSuperTrumpCard(SuperTrumpCard card) {
        this.card = card;

        cardName = new JLabel(card.gettittle());

        add(cardName);

        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {



                cardName.setText("I cliced");

                human

                        
//                        // TODO: 23/10/16 last 5 minutes of screencast p1

                playCard();

                super.mouseClicked(e);

            }


        });

    }

    private int playCard() {
        System.out.println("the card played was " + card.gettittle());
        return card.getID();
    }


}
