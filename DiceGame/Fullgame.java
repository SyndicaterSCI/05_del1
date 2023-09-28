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
        System.out.println("Welcome to THE DICE GAME! \n To play the game type Roll\n Rule 1 first to 40 point wins");
        System.out.println("Enter the name of Player 1");
        player1 = new Player(input.nextLine());

        System.out.println("Welcome to the table " + player1.getName() + "\n Enter the name of Player 2");
        player2 = new Player(input.nextLine());
        System.out.println("Welcome to the table " + player2.getName());
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

    /*
     * magi call static til
     * boolean (flag = true)
     * die
     * player
     */

    /*
     * Scanner for game rule
     * 
     * 
     * for loop med flag "skift mellem player 1 og player 2"
     * 
     * 
     * 
     * 
     * gameplay loop
     */

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
                        //Double 1's sets your current points to 0
                        System.out.println(
                                "Snake eyyyyeeeeees you encountered the Dungeons Snake!" + "\nIT ATE all ya points!");
                        player.totalScore = 0;
                        playFlag = false;

                    } else if (areEqual) {
                        int equalsix = 0;
                        System.out.println("Congratulations Adventurer you rolled EQUALS");
                        if (die1.faceValue == 6) {
                            equalsix++;
                        } else {
                            equalsix = 0;
                        }
                        if (equalsix == 2 || player.totalScore >= 40){
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

   