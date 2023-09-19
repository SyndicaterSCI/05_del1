import java.util.Random;

class Die {
    public int faceValue;

    // Generate a random number between 1 and 6, and sets the variable "faceValue" to that number. 
    // It simulates a dice roll.
    public void roll(){
        int min = 1;
        int max = 6;
        Random rand = new Random();
        faceValue = rand.nextInt((max - min) + 1) + min;
    }

    // "Rolls" the die and returns the number of the face value of the die, as an integer.
    public int getValue(){
        roll();
        return faceValue;
    }
}

