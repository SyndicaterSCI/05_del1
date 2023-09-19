class 05_del1 {

    public static void main(String[] args) {

    var s = new java.util.scanner(System.in);

    var die1 = new Die();
    var die2 = new Die();

    while (s.hasNextLine()) {
        var roll = s.nextLine();
        switch(roll) { 
            case "roll" -> {
                var value1 = die1.getValue();
                var value2 = die2.getValue();
                var sum = value1 + value2;
                System.out.println("Value of die 1 is " + value1 + " Value of die 2 is " + value2 + " The sum of both dice is " + sum);
            }
            default -> {
                System.out.println("If you wanna make another roll, type 'roll'");
            }
        } 
    }

    s.close();

    }
}

