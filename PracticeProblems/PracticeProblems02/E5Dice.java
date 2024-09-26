package PracticeProblems.PracticeProblems02;

// Imports
import java.util.Scanner;
import java.util.Random;

/**
 * TASK:
 * Write a program where the user is first asked to enter the number of dice
 * rolls desired. The program must then print how many times a dice number
 * appeared, that is, show the number of 1s, 2s, etc. Instead of a count,
 * one should show the #s of characters.
 * 
 * PROGRAM DESCRIPTION:
 * 1. Ask user for number of time to roll dice
 * 2. Validate user input
 * 3. Roll dice
 * 4. Display result
 * 5. Close and exit
 * 
 * @author David Browning (davbro-4)
 */
public class E5Dice {

    // Constants
    private static String INPUT_PROMPT = "How many times would you like"
        + " to roll?";
    private static String INVALID_INPUT_MESSAGE = "Invalid input. Exiting.";
    private static Random rand = new Random();
    private static int DIE_MIN = 1;
    private static int DIE_MAX = 6;

    public static void main(final String[] args) {

        // Variables
        int timesToRoll = 0;        // User's desired number of dice rolls
        int thisRoll = 0;           // Stores the current roll's value
        int count1 = 0;             // Number of 1s rolled
        int count2 = 0;             // Number of 2s rolled
        int count3 = 0;             // Number of 3s rolled
        int count4 = 0;             // Number of 4s rolled
        int count5 = 0;             // Number of 5s rolled
        int count6 = 0;             // Number of 6s rolled
        int thisFrequency = 0;      // Number of times to print #

        // Declare Scanner
        Scanner userInput = new Scanner(System.in);
        
        // 1. Ask user for number of time to roll dice
        System.out.printf("%s ", INPUT_PROMPT);

        // 2. Validate user input
        if (userInput.hasNextInt()) {
            timesToRoll = userInput.nextInt();
        } else {
            System.out.printf("%s%n", INVALID_INPUT_MESSAGE);
            System.exit(0);
        }
        if (timesToRoll < 1) {
            System.out.printf("%s%n", INVALID_INPUT_MESSAGE);
            System.exit(0);
        }

        // 3. Roll dice
        for (int i = 0; i < timesToRoll; i++) {
            thisRoll = rand.nextInt(DIE_MIN, DIE_MAX + 1);
            System.out.printf("%d ", thisRoll);
            switch (thisRoll) {
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
                case 5:
                    count5++;
                    break;
                case 6:
                    count6++;
                    break;
                default:
                    break;
            }
        }

        // 4. Display result
        System.out.printf("%n");
        for (int i = 1; i < 7; i++) {
            System.out.printf("%n%d: ", i);
            switch (i) {
                case 1:
                    thisFrequency = count1;
                    break;
                case 2:
                    thisFrequency = count2;
                    break;
                case 3:
                    thisFrequency = count3;
                    break;
                case 4:
                    thisFrequency = count4;
                    break;
                case 5:
                    thisFrequency = count5;
                    break;
                case 6:
                    thisFrequency = count6;
                    break;
                default:
                    break;
            }
            for (int j = 0; j < thisFrequency; j++) {
                System.out.print("#");
            }
        }

        // 5. Close and exit
        userInput.close();

    }

    
}