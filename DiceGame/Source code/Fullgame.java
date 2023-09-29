import java.util.Scanner;

class Fullgame {

    static boolean flag = true;
    static Die die1 = new Die();
    static Die die2 = new Die();
    static Player player1;
    static Player player2;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Vi skal have lavet et stykke kode for at skifte mellem de to spil!
        startGame();
      
        /*
        This for loop is for switching between the two players.
        The switch between players happens when inside the loop, 'if' statements check if i is divisible by 2 or not. In case it isn't
        it is player1's turn. In case it is, it's player2's turn.
        Takes a boolean flag (initially true) as condition, which will be broken inside the play2() function in case 
        player exits game or win conditions are met.
        */

        for (int i = 1; flag; i++) {
            if ((i % 2) != 0) {
                play2(player1);
            } else if ((i % 2) == 0) {
                play2(player2);
            }
        }
        input.close();

    }

    // Adds the total point from dice sum to players totalscore, and prints each die value and total score of player
    static void standardPro(int sum, Player player) {
        player.setTotalScore(sum);
        System.out.println("\nValue of first die is " + die1.getValue() + "\nValue of second die is " + die2.getValue());
        System.out.println("Total point of " + player.getName() + ": " + player.getTotalScore());
    }


    // Central game function. 
    // Parameter: Player object 
    // Allows the player to enter "roll", "show points" or "exit" commands.
    static void play2(Player player) {
        System.out.println("\nTurn of: " + player.getName() + "\nEnter one of the following commands: \n- 'roll' to ROLL THEM DICE!  \n- 'show points' \n- 'exit'");
        // We create 'boolean flag' and set it to 'true', so that we can break the while loop inside the nested switch statement.
        boolean playFlag = true;
        while (playFlag) {
            // Takes en input and sets it as a variable, to be checked inside switch statment. This is the players command.
            var playCommand = input.nextLine();
            //switch (playCommand.toLowerCase()) {
                if(playCommand.toLowerCase().equals("roll")) {
                    // We roll both dice, create a variable of their sum and a boolean based on if their value is equal or not aka. a double roll.
                    die1.roll();
                    die2.roll();
                    int sum = die1.getValue() + die2.getValue();
                    boolean areEqual = (die1.getValue() == die2.getValue());
                    //If statement: we check if double 1's. Player total score is set to 0. Turn ends by declaring boolean flag false.
                    if (die1.getValue() == 1 && die2.getValue() == 1) {
                        System.out.println("\nSnake eyyyyeeeeees you encountered the Dungeons Snake!" + "\nIT ATE all ya points!");
                        player.resetTotalScore();
                        playFlag = false;
                    
                    //Else if: we check if it's a double rolled (not 1's).
                    } else if (areEqual) {
                        // We create a counter and for each double 6's, the counter goes up 1.
                        int equalsix = 0;
                        if (die1.getValue() == 6) {
                            equalsix++;
                        // If it's not a double 6's, counter goes to 0 again.
                        } else {
                            equalsix = 0;
                        }
                        // Checks to see if it's second double 6's in a row, and if player points are 40 or above
                        if (equalsix == 2 || player.getTotalScore() >= 40) {
                            System.out.println("\nCONGRATULATIONS " + player.getName() + " Adventurer you have escaped the Dungeon, ya mate got left behind!");
                            // Both boolean flag are set to false, so both the for and while loop ends, thus terminating the game.
                            playFlag = false;
                            flag = false;
                        
                        } 
                        
                        // If not 2 double 6's in a row, the points will be added to player totalscore, while loop is not broken, and player get another turn 
                        else {
                            standardPro(sum, player);
                            System.out.println("\nYou get another Roll Adventurer, use it wisely");
                            System.out.println("Its " + player.getName() + " turn");
                        }
                    
                    // If a 'regular' roll, point will be added, boolean flag set to false, ending player turn.
                    } else {
                        standardPro(sum, player);
                        playFlag = false;
                    }

                }

                // Prints the total score of both players
                else if(playCommand.toLowerCase().equals("show points")){
                    System.out.println("\nTotal points of " + player1.getName() + ": " + player1.getTotalScore());
                    System.out.println("Total points of " + player2.getName() + ": " + player2.getTotalScore());
                }

                // End program, by setting both boolean flags to false
                else if(playCommand.toLowerCase().equals("exit")) {
                    System.out.println("\nThank you for playing Travelers!");
                    playFlag = false;
                    flag = false;
                }

                // Invalid input: loop continues and asks for another input
                else {
                    System.out.println("\nYou seem to be drunk on adventure, I did not understand you. Try again!");
                }
            //}

        }

    }

    //This function prints the rules, asks for input from each player and creates two Player object with given input.
    static void startGame(){
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
        
    }

}