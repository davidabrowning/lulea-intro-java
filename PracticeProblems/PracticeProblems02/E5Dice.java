package PracticeProblems.PracticeProblems02;

// Imports
import java.util.Scanner;

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

    public static void main(final String[] args) {

        // Variables
        int timesToRoll = 0;        // User's desired number of dice rolls
        int count1 = 0;             // Number of 1s rolled
        int count2 = 0;             // Number of 2s rolled
        int count3 = 0;             // Number of 3s rolled
        int count4 = 0;             // Number of 4s rolled
        int count5 = 0;             // Number of 5s rolled
        int count6 = 0;             // Number of 6s rolled

        // Declare Scanner
        Scanner userInput = new Scanner(System.in);

        // 5. Close and exit
        userInput.close();

    }

    
}