package com.company;


import javax.swing.*;
import java.awt.*;

/**
 * Created by jc320588 on 22/10/16.
 */
public class GuiMain extends JFrame {

    JLabel question = new JLabel("How many players?: ");
    Font bigfont = new Font("Arial", Font.BOLD, 16);
    JTextField answer = new JTextField(10);
    JButton pressme = new JButton("New Game");
    JLabel greeting = new JLabel("");
    JLabel humanPlayertext = new JLabel("");
    final int WIDTH = 275;
    final int HEIGHT = 225;
    private SuperTrump game;
    GuiSuperTrumpPlayers playerView;


    public static void main(String[] args) {
        GuiMain frame = new GuiMain();
        frame.setVisible(true);
    }

    public GuiMain(){
        super("Super Trump Mineral Game");
        setSize(WIDTH, HEIGHT);
//        setLayout(new FlowLayout());
        question.setFont(bigfont);
        greeting.setFont(bigfont);
        add(question, BorderLayout.NORTH);
        add(answer, BorderLayout.WEST);
        add(pressme, BorderLayout.SOUTH);
        pressme.setToolTipText("I did not get any info, sorry");
        add(greeting, BorderLayout.EAST);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


//// TODO: 23/10/16 make buttons to for player numbers. have each button have a differnt number of play and that just triggers a case statement with that variable numb
        pressme.addActionListener(e -> {
            repaint();
            int numberOfPlayer = Integer.parseInt(answer.getText());

            System.out.println("You clicked new game");
            System.out.println("you entered " + numberOfPlayer );

            game = new SuperTrump(numberOfPlayer);
            game.assignPositions(numberOfPlayer);
            game.dealCards();
            game.selectHumanPlayer();
            int humanPlayer = game.getHumanPlayerPosition();
            showHumanPlayer(humanPlayer);
            SuperTrumpPlayers human = game.getHumanPlayer();

//            greeting.setText();

            if (playerView != null){
                remove(playerView);
            }


            playerView = new GuiSuperTrumpPlayers(human);
            add(playerView, BorderLayout.CENTER);

//            game.gamePlay();


        });

    }

    private void showHumanPlayer(int humanPlayer) {
        if (humanPlayer == 1) {
            greeting.setText("You are in position " + humanPlayer + " and you are also the dealer.");
            System.out.println("You are in position " + humanPlayer + " and you are also the dealer.");
        } else {
            greeting.setText("You are in position " + humanPlayer + ".");
            System.out.println("You are in position " + humanPlayer + ".");
        }
    }

















}
