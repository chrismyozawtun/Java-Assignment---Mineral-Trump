package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        welcomeMessage();
        int useroption = getInt("What would you like to do?");
        System.out.println(useroption);

        //// TODO: 20/09/16 Switch for selection options

        if (useroption == 1){
            int numPlayers = getInt("How many players are playing");
            while (numPlayers > 10 || numPlayers == 0) {
                numPlayers = getInt("How many players are playing. (Max 10)");
            }

            startNewGame(numPlayers);
        }

    }

    private static void startNewGame(int playerCount) {
        SuperTrump game = new SuperTrump(playerCount);
        SuperTrump.assignPositions(playerCount);
        SuperTrump.dealCards();

//        assignDealer();
    }

    private static void welcomeMessage() {
        System.out.println("Welcome to Super Trumps: The Mineral Card Game");
        System.out.println("1. Start game\n2. Options\n3. Exit");
    }

    private static int getInt(String inputMessage){
        int number;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter " + inputMessage +": ");
        number = input.nextInt();
        return number;
    }
}


