package PracticeProblems.PracticeProblems03;

// Imports
import java.util.Random;
import java.util.Scanner;

/**
 * === Task description ===
 * Modify the dice program from the previous module on logic so that the
 * frequency calculation is done using an array.
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
public class PP0301Dice {

    // Constants
    private static String INPUT_PROMPT = "How many times would you like"
        + " to roll?";
    private static String INVALID_INPUT_MESSAGE = "Invalid input. Exiting.";
    private static Random rand = new Random();
    private static int DIE_MIN = 1;
    private static int DIE_MAX = 6;

    public static void main(final String[] args) {

        // Variables
        int timesToRoll = 0;            // User's desired number of dice rolls
        int thisRoll = 0;               // Stores the current roll's value
        int[] rollCount = new int[6];   // Count of each number rolled

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
            rollCount[thisRoll - 1]++;
        }

        // 4. Display result
        System.out.printf("%n");
        for (int i = 1; i < 7; i++) {
            System.out.printf("%n%d: ", i);
            for (int j = 0; j < rollCount[i - 1]; j++) {
                System.out.print("#");
            }
        }

        // 5. Close and exit
        userInput.close();
    }
}