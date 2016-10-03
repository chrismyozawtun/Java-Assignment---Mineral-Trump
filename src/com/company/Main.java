package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean menuScreen = true;
        System.out.println("Welcome to Super Trumps: The Mineral Card Game");
        while (menuScreen) {
            int userOption = welcomeMessage();
            switch (userOption) {
                case 1: {
                    int numPlayers = getInt("How many players are playing");
                    while (numPlayers > 7 || numPlayers == 0) {
                        numPlayers = getInt("How many players are playing. (Max 7)");
//                        // TODO: 3/10/16 if many players, need to reshuffle cards into de
                    }
                    menuScreen = false;
                    startNewGame(numPlayers);
                    break;
                }
                case 2: {
                    System.out.println("The options don't work yet");
                    break;
                }
                case 3: {
                    int exitOptions;
                    exitOptions = getInt("Are you sure you want to exit?\n1. Yes\n2. No");
                    if (exitOptions == 1) {
                        System.out.println("Bye!");
                        System.exit(0);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private static void startNewGame(int playerCount) {
        SuperTrump game = new SuperTrump(playerCount);
        game.buildDeck();
        game.assignPositions(playerCount);
        game.dealCards();
        game.selectHumanPlayer();
        int humanPlayer = game.getHumanPlayer();
        showHumanPlayer(humanPlayer);
//        game.showPlayerCards(humanPlayer.getPosition());

//        int getCardsofPlayer = getInt("What ID do you want to cheat");
//        game.showPlayerCards(getCardsofPlayer);

        game.gamePlay();
    }

    private static void showHumanPlayer(int humanPlayer){
        if (humanPlayer == 1){
            System.out.println("You are in position " + humanPlayer + " and you are also the dealer.");
        }
        else  {
            System.out.println("You are in position " + humanPlayer + ".");
        }
    }

    private static int welcomeMessage() {
        System.out.println("Menu");
        System.out.println("1. Start game\n2. Options\n3. Exit");
        int userOption = getInt("What would you like to do?");
        return userOption;
    }

    private static int getInt(String inputMessage){
        int number;
        Scanner input = new Scanner(System.in);
        System.out.println(inputMessage +": ");
        number = input.nextInt();
        return number;
    }
}


