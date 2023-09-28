import java.util.Scanner;

class testProgram{

    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);
        boolean flag = true;
        boolean flag2 = true;
        testClass tester = new testClass();

        while(flag){
            System.out.println("How many throws do you wish to test?");
            int numberOfThrow = input.nextInt();
            tester.setNumberOfThrow(numberOfThrow);
            tester.printInfo();
            System.out.println("Would you like to run another test? [Y/N]");
            flag2 = true;
            while(flag2){
                String testAnswer = answer.nextLine();
                switch (testAnswer.toLowerCase()){
                    case "y" ->{
                        flag2 = false;
                    }
                    case "n" ->{
                        System.out.println("Testing finished");
                        flag2 = false;
                        flag = false;
                    }
                    default -> {
                        System.out.println("Please enter 'Y' for new test or 'N' to exit");
                    }
                }
            }
            tester.testNumberIncrement();
        }
        
        input.close();
        answer.close();
    }
}