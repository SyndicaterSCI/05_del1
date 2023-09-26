import java.util.Scanner;

class Fullgame {

    static boolean flag = true;
    static Die die1 = new Die();
    static Die die2 = new Die();
    static Player player1;
    static Player player2;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to THE DICE GAME! \n To play the game type Roll\n Rule 1 first to 40 point wins");
        System.out.println("Enter the name of Player 1");
        player1 = new Player(input.nextLine());

        System.out.println("Welcome to the table " + player1.name + "\n Enter the name of Player 2");
        player2 = new Player(input.nextLine());
        System.out.println("Welcome to the table " + player2.name);
        System.out.println("Type 'Roll' to Roll THEM DICE! " + "Its " + player1.name + " turn");

        for (int i = 1; flag; i++) {
            if ((i % 2) != 0) {
                play(player1);
            } else if ((i % 2) == 0) {
                play(player2);
            }
        }

    }

/*
 magi call static til
 boolean (flag = true)
 die 
 player
 */

/*
Scanner for game rule


for loop med flag "skift mellem player 1 og player 2"




gameplay loop
 */
static void play(Player player){
    System.out.println("\nTurn of: " + player.name + "\nEnter one of the following commands: 'Roll' or 'Show points' or 'Exit'");
    boolean playFlag = true;
    while(playFlag){
        Scanner input = new Scanner(System.in);
        var playCommand = input.nextLine();
        switch(playCommand.toLowerCase()){
            case "roll" -> {
                die1.roll();
                die2.roll();
                int sum = die1.faceValue + die2.faceValue;
                player.addPoint(sum);

                System.out.println("\nValue of the first die is " + die1.faceValue + "\nValue of the second die is " + die2.faceValue);
                System.out.println("Total points of " + player.name + ": " + player.point);
                verifyWin(player);
                playFlag = false;
            }
            case "show points" -> {
                System.out.println("Total Points of " + player1.name + ": " + player1.point + "\nTotal Points of " + player2.name + ": " + player2.point);
            }
            case "exit" -> {
                System.out.println("Thank you for playing!");
                playFlag = false;
                flag = false;
            }
            default -> {
                System.out.println("\nCommand not understood. Try again");
            }
        }
    }
}

// features 

/*
verifyWin 

addPoint 


 */


 static void verifyWin(Player player){
    if(player.point >= 40){
        System.out.println("Congratulations! " + player.name + " has won the game with " + player.point + " points");
        flag = false;
    }
}

static void standardPro(int sum, Player player){
    player.addPoint (sum);
    System.out.println("\nValue of first die is " + die1.faceValue + "\nValue of second die is " + die2.faceValue);
    System.out.println("Total point of " + player.name + ": " + player.point);
    }

}