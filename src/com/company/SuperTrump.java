package com.company;

import java.util.*;

public class SuperTrump {
    private int playerCount;
    private static final int DEAL_AMOUNT = 8;
    private SuperTrumpPlayers[] players;
    private SuperTrumpDeck deck;
    private SuperTrumpTable table;
    private int humanPlayerID;
    private int skipLIMIT;
    private int numberOfSkips;
    private ArrayList<Integer> abundanceEconomicScoring;
    private ArrayList<String> abundanceTypes;
    private ArrayList<String> economicTypes;
    private ArrayList<Integer> cleavageScoring;
    private ArrayList<String> cleavageTypes;


    public SuperTrump(int playerCount) {
        this.playerCount = playerCount;
        deck = new SuperTrumpDeck();
        table = new SuperTrumpTable();
        buildScoreSheet();
    }

    private void buildScoreSheet() {
        abundanceEconomicScoring = new ArrayList<>();
        cleavageTypes = new ArrayList<>(Arrays.asList("none", "noor/none", "1 poor", "2 poor", "1 good", "1 good, 1 poor", "2 good", "3 good", "1 perfect", "1 perfect, 1 good", "1 perfect, 2 good", "2 perfect, 1 good", "3 perfect", "4 perfecct", "6 perfect"));
        cleavageScoring = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, 3, 4, 6, 9, 10, 13, 16, 23, 30, 40, 60));
        abundanceTypes = new ArrayList<>(Arrays.asList("ultratrace", "trace", "low", "moderate", "high", "very high"));
        economicTypes = new ArrayList<>(Arrays.asList("trivial", "low", "moderate", "high", "very high", "I'm rich!"));

        for (int i = 1; i < 7; i++) {
            abundanceEconomicScoring.add(i);
        }
    }

    public void assignPositions(int playerCount) {
        ArrayList<Integer> playerPositions = new ArrayList<Integer>();
        for (int i = 1; i < playerCount + 1; i++) {
            playerPositions.add(i);
        }
        Collections.shuffle(playerPositions);

        players = new SuperTrumpPlayers[playerCount];
        for (int i = 0; i < playerCount; i++) {
            players[i] = new SuperTrumpPlayers(i);
            players[i].setPosition(playerPositions.get(i));
        }

        skipLIMIT = playerCount - 1;
    }

    public void dealCards() {
        for (SuperTrumpPlayers player : players) {
            ArrayList<SuperTrumpCard> cards = deck.dealCards(DEAL_AMOUNT);
            player.setCards(cards);
        }
        for (int i = 0; i < players.length; i++) {
            if (players[i].getPosition() == 1) {
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
    }

    public void gamePlay() {
        boolean playGame = true;
        int positionsToPlay = 2;
        int playerID = 0;
        int playerlistLimit = playerCount - 1;
        int randomCardAI;

        ArrayList<Integer> playOrder = new ArrayList<>();
        for (int i = 1; i < playerCount + 1; i++) {
            playOrder.add(i);
        }
//                                                    System.out.println("play order = " + i);
        System.out.println("\nLeft of the dealer (Position 2) goes first.");

//        // TODO: 3/10/16 Do a giant try and catch exception? for when someone looses all their cards. Catch that error and playgame is false?

        while (playGame) {
            table.setTrump("cleavage");
//            if (!players[playerID].getSkip()) { // TODO: 3/10/16 DO the skip function in ful so it works
            if (players[playerID].getPosition() == positionsToPlay) {
                if (players[humanPlayerID].getPosition() == players[playerID].getPosition()) {
                    int number;
                    Scanner input = new Scanner(System.in);
                    System.out.println("\nposition = " + players[playerID].getPosition() + " id = " + players[playerID].getId());
                    players[playerID].printCardsforPlay();
                    System.out.println("enter a card you wanna eat OR '40' to skip turn and draw");
                    number = input.nextInt();

//                        // TODO: 3/10/16 Need to do checking on what player can enter
                    switch (number) {
                        case 40: {
                            players[playerID].drawCard(deck.getOneCard());
                            numberOfSkips++;
                            break;
                        }
                        default: {
                            if (checkCard(playerID, number)) {
                                table.addCard(players[playerID].playCard(number));
                                break;
                            }
////                        // TODO: 3/10/16 Show name of card, have player select trump and show that trump. Same for AI
////                        // TODO: 3/10/16 Check if the card played is higher than the card previous in trump
                        }
                    }
                } else {
                    System.out.println("\nposition = " + players[playerID].getPosition() + " id = " + players[playerID].getId());
//// TODO: 4/10/16 check all the cards in the hand
                    for (int i = 0; i < players[playerID].getCards().size(); i++) {
                        try {
                            if (players[playerID].getOneCard(i).getID() > table.cardInPlay().getID()) {
                                table.addCard(players[playerID].playCard(i));
                                break;
                            } else {
                                players[playerID].drawCard(deck.getOneCard());
                                numberOfSkips++;
                            }
                            break;
                        } catch (NullPointerException e) {
//                                This is if there is no card in play at the moment
                            randomCardAI = new Random().nextInt(players[playerID].getCards().size());
                            System.out.println("Player " + players[playerID].getPosition() + " played card " + players[playerID].getCards().get(randomCardAI));
                            table.addCard(players[playerID].playCard(randomCardAI));
//                            System.out.println("There is no card in play\n");
                            break;
                        }
                    }
                }
                positionsToPlay++;
                System.out.println("The card in play is " + table.cardInPlay());
                System.out.println("Number of skips is: " + numberOfSkips + " and the skip limit is: " + skipLIMIT);
                System.out.println("The deck has " + deck.getCards().size() + " cards left");
            }

            if (deck.getCards().size() == 1) {
                deck.shuffleInTableCards(table.getTableCards());
                System.out.println("The table cards have been shuffled back into the deck");
            }

            if (positionsToPlay > playerCount) {
                positionsToPlay = 1;
            }
            if (playerID < playerlistLimit) {
                playerID++;
            } else {
                playerID = 0;
            }
        }
    }

    private boolean checkCard(int playerID, int index) {
        try {
            int score = 0;
            int tableScore = 0;
            switch (table.getTrump()) {
                case "cleavage": {
                    String rankingCard = this.players[playerID].getOneCard(index).getCleavage();
                    String tableCard = this.table.cardInPlay().getCleavage();

                    int scoreIndex = cleavageTypes.indexOf(rankingCard);
                    score = cleavageScoring.get(scoreIndex);
                    System.out.println("Your cards score is: " + score);

                    int tableIndex = cleavageTypes.indexOf(tableCard);
                    tableScore = cleavageScoring.get(tableIndex);
                    System.out.println("The table cards score is: " + tableScore);

                    break;
                }
                case "crustal abundance": {
                    String rankingCard = this.players[playerID].getOneCard(index).getCrustal_abundance();
                    String tableCard = this.table.cardInPlay().getCrustal_abundance();

                    int scoreIndex = cleavageTypes.indexOf(rankingCard);
                    score = abundanceEconomicScoring.get(scoreIndex);
                    System.out.println("Your cards score is: " + score);

                    int tableIndex = cleavageTypes.indexOf(tableCard);
                    tableScore = abundanceEconomicScoring.get(tableIndex);
                    System.out.println("The table cards score is: " + tableScore);
                    break;
                }
                case "economic value": {
                    String rankingCard = this.players[playerID].getOneCard(index).getEconomic_value();
                    String tableCard = this.table.cardInPlay().getEconomic_value();

                    int scoreIndex = cleavageTypes.indexOf(rankingCard);
                    score = abundanceEconomicScoring.get(scoreIndex);
                    System.out.println("Your cards score is: " + score);

                    int tableIndex = cleavageTypes.indexOf(tableCard);
                    tableScore = abundanceEconomicScoring.get(tableIndex);
                    System.out.println("The table cards score is: " + tableScore);
                    break;
                }
            }
            return score > tableScore;
        } catch (NullPointerException e) {
            return true;
        }
    }
}
//// TODO: 3/10/16 Skip function. try making a variable that counts skips/draws. And then make a limimt variable which is just LIMIT_SKIPS = playercount - 1.
// todo: The first variable will increase everyime the draw function is called and then every loop of the game; the draw function is check with the limit and if the limit is reached,
//todo: Apparently the last player gets to choose the next trump category
//todo: To check if players can play; just at the start before each if or loop check if its true with players[playerID].getSkip

//todo: do a loop so all the players Skip boolean is taken back to false and they can play again??

////             TODO: 3/10/16 Need to random int or something to see if the Ai will draw a card maybs ?