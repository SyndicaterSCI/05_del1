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

    // features

    /*
     * verifyWin
     * 
     * addPoint
     * 
     * 
     */

}