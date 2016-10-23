package com.company;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

/**
 * Created by jc320588 on 22/10/16.
 */
public class GuiMain extends JFrame {

    JLabel question = new JLabel("How many players?: ");
    Font bigfont = new Font("Arial", Font.BOLD, 16);
    JTextField answer = new JTextField(10);
    JButton pressme = new JButton("New Game");
    JLabel playerInfo = new JLabel("");
    JLabel humanPlayertext = new JLabel("");
    final int WIDTH = 900;
    final int HEIGHT = 450;
    protected SuperTrump game;
    GuiSuperTrumpPlayers playerView;
    SuperTrumpPlayers human;
    GuiSuperTrumpTable talbeCard;



    public static void main(String[] args) {
        GuiMain frame = new GuiMain();
        frame.setVisible(true);
    }

    public GuiMain(){
        super("Super Trump Mineral Game");
        setSize(WIDTH, HEIGHT);
        question.setFont(bigfont);
        playerInfo.setFont(bigfont);

        JPanel panel1 = new JPanel();
        panel1.add(question, BorderLayout.NORTH);
        panel1.add(answer, BorderLayout.CENTER);
        panel1.add(playerInfo, BorderLayout.SOUTH);
        add(panel1, BorderLayout.NORTH);
        add(pressme, BorderLayout.SOUTH);
        pressme.setToolTipText("I did not get any info, sorry");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pressme.addActionListener(e -> {
            repaint();
            int numberOfPlayer = Integer.parseInt(answer.getText());

            System.out.println("You clicked new game");
            System.out.println("you entered " + numberOfPlayer );

            newGame(numberOfPlayer);
//            playerInfo.setText();
            if (playerView != null){
                remove(playerView);
            }

            playerView = new GuiSuperTrumpPlayers(human);
            add(playerView, BorderLayout.CENTER);

//            gameplayLoop();
//            game.gamePlay();
        });

    }

    private void showHumanPlayer(int humanPlayer) {
        if (humanPlayer == 1) {
            playerInfo.setText("You are in position " + humanPlayer + " and you are also the dealer.");
            System.out.println("You are in position " + humanPlayer + " and you are also the dealer.");
        } else {
            playerInfo.setText("You are in position " + humanPlayer + ".");
            System.out.println("You are in position " + humanPlayer + ".");
        }
    }

    private void newGame(int numberOfPlayer){
        game = new SuperTrump(numberOfPlayer);
        game.assignPositions(numberOfPlayer);
        game.dealCards();
        game.selectHumanPlayer();
        int humanPlayer = game.getHumanPlayerPosition();
        showHumanPlayer(humanPlayer);
        human = game.getHumanPlayer();

    }


    private void gameplayLoop(){
    boolean playGame = true;
    int positionsToPlay = 2;
    int playerID = 0;
    int playerlistLimit = game.playerCount - 1;

    ArrayList<Integer> playOrder = new ArrayList<>();
        for (int i = 1; i < game.playerCount + 1; i++) {
        playOrder.add(i);
    }
        System.out.println("\nLeft of the dealer (Position 2) goes first.");
    // TODO: 3/10/16 Do a giant try and catch exception? for w
// hen someone looses all their cards. Catch that error and playgame is false?

        while (playGame) {
        game.table.setTrump("cleavage");
//            if (!players[playerID].getSkip()) { // TODO: 3/10/16 DO the skip function in ful so it works
        if (game.players[playerID].getPosition() == positionsToPlay) {
            if (game.players[game.humanPlayerID].getPosition() == game.players[playerID].getPosition()) {
                humanTurnToPlay(playerID);
            } else {
                computerTurnToPlay(playerID);
            }
            positionsToPlay++;
            System.out.println("The card in play is " + game.table.cardInPlay() + " and its score is " + game.table.cardInPlay().getID());
            System.out.println("Number of skips is: " + game.numberOfSkips + " and the skip limit is: " + game.skipLIMIT);
            System.out.println("The deck has " + game.deck.getCards().size() + " cards left");

            talbeCard = new GuiSuperTrumpTable(game, game.table.cardInPlay());
            add(talbeCard);
        }

        if (game.deck.getCards().size() == 1) {
            game.deck.shuffleInTableCards(game.table.getTableCards());
            System.out.println("The table cards have been shuffled back into the deck");

        }

        if (positionsToPlay > game.playerCount) {
            positionsToPlay = 1;
        }
        if (playerID < playerlistLimit) {
            playerID++;
        } else {
            playerID = 0;
        }
    }
}

    private void computerTurnToPlay(int playerID) {
        int randomCardAI;
        boolean drawCard = true;

        System.out.println("\nposition = " + game.players[playerID].getPosition() + " id = " + game.players[playerID].getId());
        try {
            for (int i = 0; i < game.players[playerID].getCards().size(); i++) {
                if (game.players[playerID].getOneCard(i).getID() > game.table.cardInPlay().getID()) {
                    game.table.addCard(game.players[playerID].playCard(i));
                    drawCard = false;
                    break;
                }
            }
            if (drawCard){
                game.players[playerID].drawCard(game.deck.getOneCard());
                game.numberOfSkips++;
            }
        } catch (NullPointerException e) {
//                                This is if there is no card in play at the moment
            randomCardAI = new Random().nextInt(game.players[playerID].getCards().size());
            System.out.println("Player " + game.players[playerID].getPosition() + " played card RANDOM " + game.players[playerID].getCards().get(randomCardAI));
            game.table.addCard(game.players[playerID].playCard(randomCardAI));
//                break;
        }
    }

    private void humanTurnToPlay(int number) {
//        int number;
        Scanner input = new Scanner(System.in);
        System.out.println("\nposition = " + game.players[game.playerID].getPosition() + " id = " + game.players[game.playerID].getId());
        game.players[game.playerID].printCardsforPlay();
        System.out.println("enter a card you wanna eat OR '40' to skip turn and draw");
//        number = input.nextInt();
        number = playerView.getcardInput();
//        number =

//                        // TODO: 3/10/16 Need to do checking on what player can enter
        switch (number) {
            case 40: {
                game.players[game.playerID].drawCard(game.deck.getOneCard());
                game.numberOfSkips++;
                break;
            }
            default: {
//                            if (checkCard(playerID, number)) {
                game.table.addCard(game.players[game.playerID].playCard(number));
                break;
//                            }
////                        // TODO: 3/10/16 Show name of card, have player select trump and show that trump. Same for AI
////                        // TODO: 3/10/16 Check if the card played is higher than the card previous in trump
            }
        }
    }

















}
