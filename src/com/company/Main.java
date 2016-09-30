package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int menuScreen = 0;
        System.out.println("Welcome to Super Trumps: The Mineral Card Game");

        while (menuScreen == 0) {
            int userOption = welcomeMessage();
            switch (userOption) {
                case 1: {
                    int numPlayers = getInt("How many players are playing");
                    while (numPlayers > 10 || numPlayers == 0) {
                        numPlayers = getInt("How many players are playing. (Max 10)");
                    }
                    menuScreen = 1;
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
        SuperTrumpPlayers humanPlayer = game.getHumanPlayer();
        showPlayer(humanPlayer);
//        game.showPlayerCards(humanPlayer.getPosition());

        int getCardsofPlayer = getInt("What position do you want to cheat");
        game.showPlayerCards(getCardsofPlayer);

        game.gamePlay();


//// TODO: 30/09/16 32 min
    }

    private static void showPlayer(SuperTrumpPlayers humanPlayer){
        System.out.println("Human player " + humanPlayer);
    }

    private static int welcomeMessage() {
        System.out.println("\nMenu");
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


