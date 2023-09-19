class Game {

    public static void main(String[] args) {

    var s = new java.util.Scanner(System.in);

    var die1 = new Die();
    var die2 = new Die();
    System.out.println("Welcome, player. Type 'roll' to make your move, mutherfuckar");
    while (s.hasNextLine()) {
        var roll = s.nextLine();
        switch(roll) { 
            case "roll" -> {
                var value1 = die1.getValue();
                var value2 = die2.getValue();
                var sum = value1 + value2;
                System.out.println("Value of first die is " + value1 + "\nValue of second die is " + value2 + "\nThe sum of both dice is " + sum);
            }
            default -> {
                System.out.println("Are you stupid?...\nIf you wanna make another roll, type 'roll'");
            }
        } 
    }

    s.close();

    }
}

