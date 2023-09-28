import java.util.Scanner;

class Fullgame {

    static boolean flag = true;
    static Die die1 = new Die();
    static Die die2 = new Die();
    static Player player1;
    static Player player2;

    public static void main(String[] args) {
        // Vi skal have lavet et stykke kode for at skifte mellem de to spil!
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome adventures!\n\nYou have entered the perilous Dice Dungeon of Doom - here awaits glory, as well as damnation.");
        System.out.println("You have one task: to gather enough magical power, to slay the much feared Dice Demon.");
        System.out.println("Your weapon: this set of magical dice, which will grow your magical power.");
        System.out.println("\nTo slay the Demon, you will have to gather 40 power points or more, and land an awesome double roll.");
        System.out.println("\nThere is another mythical way to slay the Demon.");
        System.out.println("If you land a double roll of two 6's twice in a row, the awesomeness of your roll is enough to make the Demon instantaneously burst up in flames.");
        System.out.println("None have accomplished this, but you may be the first.");
        System.out.println("\nBut beware! Within the Dice Dungeon of Doom, another dangerous creature lies dormant:\nThe big Snake Uroboros.");
        System.out.println("This creature is attracted by double 1's, so if you land such a roll, he will suck all your magical power, and your power points will reset to 0.");
        System.out.println("\nBut glorious gifts, also awaits you adcenturer.\nIf you land a double roll which is not the feared double 1's, you will be gifted another roll.");
        System.out.println("\nDuring your travels, you will have the option of:\n- Rolling the dice to increase your magical power by typing 'Roll'.");
        System.out.println("- Seeing the total magical power of you and you fellow adventure, by typing 'show points'. Don't worry you will still be able to roll.");
        System.out.println("- Aborting the Dice Dungeon of Doom by typing 'exit', if the travels whould prove too frightening.");
        System.out.println("\nKnowing the risk of stepping into this dungeon, what is your name first adventurer?");
        player1 = new Player(input.nextLine());
        System.out.println("\nAnd what is your name second adventurer?");
        player2 = new Player(input.nextLine());
        // System.out.println("Type 'Roll' to Roll THEM DICE! " + "Its " +
        // player1.getName() + " turn"); Has been made into comment to fix a bug
        // This for loop is for switching between the two players.
        for (int i = 1; flag; i++) {
            if ((i % 2) != 0) {
                play2(player1);
            } else if ((i % 2) == 0) {
                play2(player2);
            }
        }

    }

    static void standardPro(int sum, Player player) {
        player.setTotalScore(sum);
        System.out
                .println("\nValue of first die is " + die1.getValue() + "\nValue of second die is " + die2.getValue());
        System.out.println("Total point of " + player.getName() + ": " + player.getTotalScore());
    }

    static void play2(Player player) {
        System.out.println("\nTurn of: " + player.getName()
                + "\nEnter one of the following commands: 'Roll'To ROLL THEM DICE or 'Show points' or 'Exit'");
        boolean playFlag = true;
        while (playFlag) {
            Scanner input = new Scanner(System.in);
            var playCommand = input.nextLine();
            switch (playCommand.toLowerCase()) {
                case "roll" -> {
                    die1.roll();
                    die2.roll();
                    int sum = die1.faceValue + die2.faceValue;
                    boolean areEqual = (die1.faceValue == die2.faceValue);
                    if (die1.faceValue == 1 && die2.faceValue == 1) {
                        // Double 1's sets your current points to 0
                        System.out.println(
                                "Snake eyyyyeeeeees you encountered the Dungeons Snake!" + "\nIT ATE all ya points!");
                        player.totalScore = 0;
                        playFlag = false;

                    } else if (areEqual) {
                        int equalsix = 0;

                        if (die1.faceValue == 6) {
                            equalsix++;
                        } else {
                            equalsix = 0;
                        }
                        if (equalsix == 2 || player.totalScore >= 40) {
                            System.out.println("CONGRATULATIONS" + player.name
                                    + "Adventurer you have escaped the Dungeon, ya mate got left behind!");

                            playFlag = false;
                            flag = false;
                        } else {
                            standardPro(sum, player);
                            System.out.println("You get another Roll Adventurer, use it wisely");
                            System.out.println("Its " + player.name + " turn");
                        }
                    } else {
                        standardPro(sum, player);
                        playFlag = false;
                    }

                }
                case "show points" -> {
                    System.out.println("\nTotal points of " + player1.name + ": " + player1.totalScore);
                    System.out.println("Total points of " + player2.name + ": " + player2.totalScore);
                }
                case "exit" -> {
                    System.out.println("Thank you for playing ADVENTURES!");
                    playFlag = false;
                    flag = false;
                }
                default -> {
                    System.out.println("You seem to be drunk on adventure, I did not understand you. Try again!");
                }
            }

        }

    }

    static void verifyWin(Player player) {
        if (player.getTotalScore() >= 40) {
            System.out.println("Congratulations! " + player.getName() + " has won the game with "
                    + player.getTotalScore() + " points");
            flag = false;
        }
    }

}
