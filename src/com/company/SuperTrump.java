package com.company;

import java.util.*;

import static sun.audio.AudioPlayer.player;

public class SuperTrump {
    private int playerCount;
    private static final int DEAL_AMOUNT = 8;

    private SuperTrumpPlayers[] players;
    private SuperTrumpDeck deck;
    private int yourPlayerID;


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
//        players = new SuperTrumpPlayers[playerCount];
//        for (int i = 0; i < playerCount ; i++) {
//            players[i] = new SuperTrumpPlayers(i);

//            System.out.println("dealing cards bit " + players[i].getId());
//        }
        for (SuperTrumpPlayers player : players) {
            ArrayList<SuperTrumpCard> cards = deck.dealCards(DEAL_AMOUNT);
            player.setCards(cards);
            System.out.println("id = " + player.getId() + " Player position " + player.getPosition() + " hand is " + cards);
        }
    }

    public void showPlayerCards(int position) {
        System.out.println("Player " + players[position] + " cards are " + players[position].getCards());
    }

    public void selectHumanPlayer() {
//// TODO: 30/09/16 random human player 
        yourPlayerID = new Random().nextInt(playerCount);
    }
    public SuperTrumpPlayers getHumanPlayer() {
        return players[yourPlayerID];
    }

    public void gamePlay(){
        boolean playGame = true;
        int positionsPlay;
        int positionsToPlay = 2;
        int playerList = 0;
        ArrayList<Integer> playOrder = new ArrayList<>();
        for (int i = 1; i < playerCount + 1; i++) {
            playOrder.add(i);
            System.out.println("play order = " + i);
        }
        positionsPlay = playOrder.size() +1;

        while (playGame == true){
//            for (int i : playOrder){
            if (players[playerList].getPosition() == positionsToPlay){
                int number;
                Scanner input = new Scanner(System.in);
                System.out.println("position = " + players[playerList].getPosition() + " id = " + players[playerList].getId() + " cards = " + players[playerList].getCards());
//                    playerList = 0;
                System.out.println("enter a card you wanna eat");
                number = input.nextInt();
                System.out.println(number + " was inputted");
//                    playerList = 0;
                positionsToPlay++;
            }

            if (positionsToPlay > playerCount){
                positionsToPlay = 1;
            }

            if (playerList > (playerCount-1)){
                playerList = 0;
            }
            else {
                playerList++;
            }
        }
    }
}



//            }


//            for (int i = 1; i < positionsPlay; i++) {
//                if (players[i].getPosition() == positionsToPlay){
//                    int number;
//                    Scanner input = new Scanner(System.in);
//                    System.out.println("position = " + players[i].getPosition() + " id = " + players[i].getId() + " cards = " + players[i].getCards());
//                    System.out.println("enter a card you wanna eat");
//                    number = input.nextInt();
//                    System.out.println(number + " was inputted");
//                    positionsToPlay++;
//                }
//            }

//    public void showPlayerCards(int position) {
//        System.out.println(players[3]);;
//
//    }




