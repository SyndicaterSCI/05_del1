import java.util.Scanner;

class Fullgame {


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