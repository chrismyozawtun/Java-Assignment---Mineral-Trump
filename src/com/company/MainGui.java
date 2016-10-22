package com.company;


import javax.swing.*;
import java.awt.*;

/**
 * Created by jc320588 on 22/10/16.
 */
public class MainGui extends JFrame {

    JLabel question = new JLabel("How many players?: ");
    Font bigfont = new Font("Arial", Font.BOLD, 16);
    JTextField answer = new JTextField(10);
    JButton pressme = new JButton("New Game");
    JLabel greeting = new JLabel("");
    final int WIDTH = 275;
    final int HEIGHT = 225;


    public static void main(String[] args) {
        MainGui frame = new MainGui();
        frame.setVisible(true);

    }

    public MainGui(){
        super("Super Trump Mineral Game");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        question.setFont(bigfont);
        greeting.setFont(bigfont);
        add(question, BorderLayout.NORTH);
        add(answer);
        add(pressme);
        pressme.setToolTipText("I did not get any info, sorry");
        add(greeting, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pressme.addActionListener(e -> {
            System.out.println("You clicked new game");
            String numberOfPlayer = answer.getText();
            int numPlayer = Integer.parseInt(numberOfPlayer);
            System.out.println("you entered " + numPlayer );
            SuperTrump newGame = new SuperTrump();
            newGame.
        });

    }















}
