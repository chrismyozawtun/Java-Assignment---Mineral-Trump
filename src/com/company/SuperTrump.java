package com.company;

import java.util.*;

import static sun.audio.AudioPlayer.player;

public class SuperTrump {
    private int playerCount;
    private static final int DEAL_AMOUNT = 8;

    private SuperTrumpPlayers[] players;
    private SuperTrumpDeck deck;
    private int yourPlayerID;
    private SuperTrumpTable table;


    public SuperTrump(int playerCount) {
        this.playerCount = playerCount;
        deck = new SuperTrumpDeck();
//        new SuperTrumpCard(1);
//        new SuperTrumpCard(1, "Slide01.jpg", "Slide01", "Play", "Quarts", "Si02", "Tectosilicate", "Hexagonal", ArrayList<String>["Igneous", "Metamorphic", "Sedunebtary"] );
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
        for (int i = 0; i < playerCount; i++) {
            System.out.println(playerPositions.get(i));
        }

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
            System.out.println("id = " + player.getId() + " Player position " + player.getPosition() + " hand is " + cards);
        }
    }

    public void showPlayerCards(int id) {
        System.out.println("Player " + players[id] + " cards are " + players[id].getCards());
    }

    public void selectHumanPlayer() {
        yourPlayerID = new Random().nextInt(playerCount);
    }

    public int getHumanPlayer() {
        return players[yourPlayerID].getPosition();
//// TODO: 1/10/16 Fix human player postion/id saying
    }

    public void gamePlay(){
        boolean playGame = true;
        int positionsToPlay = 2;
        int playerID = 0;
        int playerlistLimit = playerCount - 1;

        ArrayList<Integer> playOrder = new ArrayList<>();
        for (int i = 1; i < playerCount + 1; i++) {
            playOrder.add(i);
            System.out.println("play order = " + i);
        }

        while (playGame == true){
//            for (int i : playOrder){
            if (players[playerID].getPosition() == positionsToPlay){
                int number;
                Scanner input = new Scanner(System.in);
                if (yourPlayerID == players[playerID].getPosition()) {
                    System.out.println("position = " + players[playerID].getPosition() + " id = " + players[playerID].getId());
                    players[playerID].printCards();
                    System.out.println("enter a card you wanna eat");
                    number = input.nextInt();
                    System.out.println(number + " was inputted");
                    players[playerID].playCard(number);












                }
                else {
                    System.out.println("position = " + players[playerID].getPosition() + " id = " + players[playerID].getId());
                }

                positionsToPlay++;
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



