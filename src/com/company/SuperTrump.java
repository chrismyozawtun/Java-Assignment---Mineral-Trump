package com.company;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static sun.audio.AudioPlayer.player;

public class SuperTrump {
    private int playerCount;
    private static final int DEAL_AMOUNT = 8;
    private SuperTrumpPlayers[] players;
    private SuperTrumpDeck deck;
    private SuperTrumpTable table;
    private int humanPlayerID;


    public SuperTrump(int playerCount) {
        this.playerCount = playerCount;
        deck = new SuperTrumpDeck();
        table = new SuperTrumpTable();
    }

    public void buildDeck(){
        deck.buildDeck();
    }

    public void assignPositions(int playerCount) {
        ArrayList<Integer> playerPositions = new ArrayList<Integer>();
        for (int i = 1; i < playerCount + 1; i++) {
            playerPositions.add(i);
        }
        Collections.shuffle(playerPositions);
//                                                    for (int i = 0; i < playerCount; i++) {
//                                                        System.out.println(playerPositions.get(i));
//                                                    }

        players = new SuperTrumpPlayers[playerCount];
        for (int i = 0; i < playerCount ; i++) {
            players[i] = new SuperTrumpPlayers(i);
            players[i].setPosition(playerPositions.get(i));
        }
    }

    public void dealCards() {
        for (SuperTrumpPlayers player : players) {
            ArrayList<SuperTrumpCard> cards = deck.dealCards(DEAL_AMOUNT);
            player.setCards(cards);
//                                                    System.out.println("id = " + player.getId() + " Player position " + player.getPosition() + " hand is " + cards);
        }
        for (int i = 0; i < players.length; i++) {
            if (players[i].getPosition() == 1){
                System.out.println("\nCards have been dealt by player " + players[i].getId() + " in position " + players[i].getPosition() + ".");
            }
        }
    }

    public void showPlayerCards(int id) {
        System.out.println("Player " + players[id] + " cards are " + players[id].getCards());
    }

    public int selectHumanPlayer() {
        humanPlayerID = new Random().nextInt(playerCount);
        return humanPlayerID;
    }

    public int getHumanPlayer() {
        return players[humanPlayerID].getPosition();
//// TODO: 1/10/16 Fix human player postion/id saying
    }

    public void gamePlay(){
        boolean playGame = true;
        int positionsToPlay = 2;
        int playerID = 0;
        int playerlistLimit = playerCount - 1;
        int randomCardAI;

        ArrayList<Integer> playOrder = new ArrayList<>();
        for (int i = 1; i < playerCount + 1; i++) {
            playOrder.add(i);
//                                                    System.out.println("play order = " + i);
        }

        System.out.println("\nLeft of the dealer (Position 2) goes first." );
        while (playGame){
            if (players[playerID].getPosition() == positionsToPlay){
                int number;
                Scanner input = new Scanner(System.in);
                if (players[humanPlayerID].getPosition() == players[playerID].getPosition()) {
                                                    System.out.println("position = " + players[playerID].getPosition() + " id = " + players[playerID].getId());
                    players[playerID].printCardsforPlay();
                    System.out.println("enter a card you wanna eat OR '40' to skip turn and draw");
                    number = input.nextInt();
//                                                    System.out.println(number + " was inputted");
                    switch (number) {
                        case 40: {
                            players[playerID].drawCard(deck.getOneCard());
                            break;
                        }
                        default: {
                            table.addCard(players[playerID].playCard(number));
                            break;
////                        // TODO: 3/10/16 Show name of card, have player select trump and show that trump. Same for AI
////                        // TODO: 3/10/16 Check if the card played is higher than the card previous in trump
                        }
                    }
                }
                else {
                    for (int i = 0; i < players[playerID].getCards().size(); i++) {

                    }


                    System.out.println("position = " + players[playerID].getPosition() + " id = " + players[playerID].getId());

                    randomCardAI = new Random().nextInt(players[playerID].getCards().size());
                    System.out.println("Player " + players[playerID].getPosition() + " played card "  + players[playerID].getCards().get(randomCardAI));
                    table.addCard(players[playerID].playCard(randomCardAI));
                }
                positionsToPlay++;
                table.cardInPlay();
            }
            if (positionsToPlay > playerCount){
                positionsToPlay = 1;
            }
            if (playerID < playerlistLimit){
                playerID++;
            }
            else {
                playerID = 0;
            }
        }
    }
}