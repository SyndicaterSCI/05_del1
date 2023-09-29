public class Player {

    // Should make a integer that is "Totalscore"
    public int totalScore = 0;

    // Generate a string for a player name

    public String name;

    public Player(String name) {
        this.name = name;
    }

    // Gets the name from the current player and returns it
    public String getName() {
        return name;
    }

    // Should get the totalscore from the "Game" and then display it to the player
    public int getTotalScore() {
        return totalScore;
    }

    // Calculate the score, not return value

    public void setTotalScore(int score) {
        totalScore += score;
    }

    // Resets total score of player to 0
    public void resetTotalScore(){
        totalScore = 0;
    }

}
