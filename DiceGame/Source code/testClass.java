import java.time.Duration;
import java.time.Instant;

public class testClass{
    private Die die1 = new Die();
    private Die die2 = new Die();
    private Player player = new Player("test player");
    private long responsTime;
    private double[] realStat = new double[] {(1/36.0*100), (2/36.0*100), (3/36.0*100), (4/36.0*100), (5/36.0*100), (6/36.0*100), (5/36.0*100), (4/36.0*100), (3/36.0*100), (2/36.0*100), (1/36.0*100)};
    private int[] throwResult;
    private int[] occurence;
    private double[] throwStat;
    private double[] statDiffPercent;
    private double accuracy;
    private int numberOfThrow;
    private int testNumber = 1;
    private int doubleCounter;

    public void setNumberOfThrow(int numberOfThrow){
        this.numberOfThrow = numberOfThrow;
    }

    public void testNumberIncrement(){
        testNumber++;
    }

    public void testThrow(){
        doubleCounter = 0;
        throwResult = new int[numberOfThrow];
        for(int i = 0; i < throwResult.length; i++){
            die1.roll();
            die2.roll();
            if(die1.faceValue == die2.faceValue){
                doubleCounter++;
            }
            int sum = die1.faceValue + die2.faceValue;
            throwResult[i] = sum;
        }
    }

    public void info(){
        occurence = new int[11];
        for(int x : throwResult){
            occurence[x-2] += 1;
        }
    }

    public void statistic(){
        throwStat = new double[occurence.length];
        double number = numberOfThrow;
        for(int i = 0; i < occurence.length; i++){
            double percent = (occurence[i] / number) * 100;
            throwStat[i] = percent;
        }
    }

    public void statDiffPercent(){
        statDiffPercent = new double[throwStat.length];
        for(int i = 0; i < throwStat.length; i++){
            double percent = (Math.abs(throwStat[i]-realStat[i]) / realStat[i]) * 100;
            statDiffPercent[i] = percent;
        }
    }

    public void accuracy(){
        double sum = 0;
        for(double x : statDiffPercent){
            sum += x;
        }
        accuracy = 100 - (sum / statDiffPercent.length);
    }

    public String roundToString(double a){
        String b = "" + a;
        if(b.length()>4){
            b = b.substring(0, 4);
        }
        return b;
    }

    public void simulateRoll(){
        die1.roll();
        die2.roll();
        int sum = die1.faceValue + die2.faceValue;
        player.setTotalScore(sum);
        System.out.println("\nValue of first die is " + die1.faceValue + "\nValue of second die is " + die2.faceValue);
        System.out.println("Total point of " + player.name + ": " + player.totalScore);
    }

    public void generateArrays(){
        testThrow();
        info();
        statistic();
        statDiffPercent();
        accuracy();
    }

    public void printInfo(){
        
        // Generates necessary arrays for printing info
        generateArrays();
        
        // Shows an example of display in DiceGame, and calculates respons time
        String line = "_".repeat(140);
        System.out.println("\nTEST #" + testNumber + "\n" + line);
        System.out.println("\nSimulating one roll as in DiceGame (...)\n");
        System.out.println("\nAs shown in game:\n____");
        long start = System.currentTimeMillis();
        simulateRoll();
        long end = System.currentTimeMillis();
        System.out.println("____");
        long responsTime = end-start;
        
        //Creating boards for tabel and first column
        String tabelLine = "=".repeat(140);
        String header = "";
        String throwNumber = "";
        String realStat = "";
        header += String.format("|%-30s|", "Dice sum");
        throwNumber += String.format("|%-30s|", "Occurence of throw (%)");
        realStat += String.format("|%-30s|", "Deviation from probability (%)");
        
        // Creating rows showing the sum of dice, their occurence in test, and their respective deviation from statistical probability
        for(int i = 0; i < 11; i++){
            String sum = String.format("|%7s|", "'" + (i+2) + "'");
            header += sum;
        }
        for(double x : throwStat){
            String formatNumber = String.format("|%7s|", roundToString(x));
            throwNumber += formatNumber;
            }
        for(double x : statDiffPercent){
            String formatNumber = String.format("|%7s|", roundToString(x));
            realStat += formatNumber;
            }
        header += String.format("|%7s|", "Double");
        double number = numberOfThrow;
        double doubleStat = doubleCounter / number * 100;
        throwNumber += String.format("|%7s|", roundToString(doubleStat));
        double doubleTheory = 1/6.0*100;
        double doubleDiff = Math.abs(doubleStat-doubleTheory)/doubleTheory * 100;
        realStat += String.format("|%7s|", roundToString(doubleDiff));
        System.out.println("\nThrow statistics: ");
        System.out.println(tabelLine);
        System.out.println(header);
        System.out.println(throwNumber);
        System.out.println(realStat);
        System.out.println(tabelLine + "\n");

        // Displays info about the number of throws in test, the accuracy of the throws compared to probability, and response time of in game display
        String numberInfo = String.format("%-20s", "Number of throws: ") + numberOfThrow;
        String accurate = String.format("%-20s", "Accuracy: ") + roundToString(accuracy) + "%";
        String response = String.format("%-20s", "Response time: ") + responsTime + " milliseconds";
        System.out.println(numberInfo);
        System.out.println(accurate);
        System.out.println(response);
        System.out.println("\n" + line);

        
    }
}