package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by jc320588 on 23/10/16.
 */
public class GuiSuperTrumpCard extends JPanel {

    SuperTrumpCard card;
    SuperTrumpPlayers human;
    int id;
    JLabel cardView;


    public GuiSuperTrumpCard(int id, SuperTrumpCard card, SuperTrumpPlayers human) {
        this.card = card;
        this.id = id;
        this.human = human;

        cardView = new JLabel(card.gettittle());
        cardView.setPreferredSize(new Dimension(175, 250));
        try {
            Image buttomImage = ImageIO.read(getClass().getResource(card.getFileName()));
            Image buttonImageRescalred = buttomImage.getScaledInstance(175,250,1);
            cardView.setIcon( new ImageIcon(buttonImageRescalred));
        }
        catch (IOException ex){
            System.out.println("Didn't get the image");
        }

        cardView.addMouseListener(new myMouse());
        add(cardView);
    }

    public void actionPerformed(ActionEvent e)
    {

    }

    class myMouse extends MouseInputAdapter{
        public void mouseClicked(MouseEvent e) {
            cardView.setText("I cliced");
            human.playCard(id);

            if (cardView != null){
                remove(cardView);
            }






            repaint();
            super.mouseClicked(e);
        }


    }

    public int playCard() {
        System.out.println("the card played was " + card.gettittle() + " and its id was " + card.getID() + " and its index was " + id);
        return card.getID();
    }

    public int getInput(){

        return id;
    }


}
