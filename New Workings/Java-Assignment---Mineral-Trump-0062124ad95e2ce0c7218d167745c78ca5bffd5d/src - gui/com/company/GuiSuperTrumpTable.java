package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by jc320588 on 24/10/16.
 */
public class GuiSuperTrumpTable extends JPanel{

    SuperTrumpCard card;
    SuperTrumpPlayers human;
    SuperTrump game;
    JLabel tableCard;

    public GuiSuperTrumpTable(SuperTrump game, SuperTrumpCard card) {
        this.game = game;

        tableCard = new JLabel(card.gettittle());
        tableCard.setPreferredSize(new Dimension(175, 250));
        try {
            Image buttomImage = ImageIO.read(getClass().getResource(card.getFileName()));
            Image buttonImageRescalred = buttomImage.getScaledInstance(175,250,1);
            tableCard.setIcon( new ImageIcon(buttonImageRescalred));
        }
        catch (IOException ex){
            System.out.println("Didn't get the image");
        }
//        cardView.addActionListener(e -> {
//            cardView.setText("I cliced");
//            playCard();
//        });

//        addMouseListener(new myMouse());
        add(tableCard);
    }

    class myMouse extends MouseInputAdapter {
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
        }
    }

}


