package PracticeProblems.PracticeProblems02;

// Imports
import java.util.Scanner;

/**
 * TASK:
 * Write a Java program that divides the user's amount into 20-kronor, 
 * 10-kronor, 5-kronor, and 1-kronor
 * 
 * PROGRAM DESCRIPTION:
 * 1. Ask user for amount of money to exchange
 * 2. Validate user input
 * 2. Separate into kronor amounts
 * 3. Display results
 * 4. Close and exit
 * 
 * @author David Browning (davbro-4)
 */
public class C3Money {

    // Constants
    private static String INPUT_PROMPT = "What amount would you like"
        + " to exchange?";
    private static String INVALID_INPUT_MESSAGE = "Invalid amount to"
        + " exchange. Exiting program.";
    private static int CAT_1 = 20;
    private static int CAT_2 = 10;
    private static int CAT_3 = 5;
    private static int CAT_4 = 1;
    private static String COL_H1 = "Exchange";
    private static String COL_UNITS = "kronor";

    public static void main(final String[] args) {

        // Variables
        int totalAmount = 0;        // Total amount to exchange
        int remainingAmount = 0;    // Remaining amount to exchange
        int numCat1 = 0;            // Amount of denom 1
        int numCat2 = 0;            // Amount of denom 2
        int numCat3 = 0;            // Amount of denom 3
        int numCat4 = 0;            // Amount of denom 4

        // Declare Scanner
        Scanner userInput = new Scanner(System.in);

        // 1. Ask user for amount of money to exchange
        System.out.printf("%s ", INPUT_PROMPT);

        // 2. Validate user input
        if (userInput.hasNextInt()) {
            totalAmount = userInput.nextInt();
        } else {
            System.out.printf("%s%n", INVALID_INPUT_MESSAGE);
            System.exit(0);
        }

        // 3. Separate into kronor amounts
        remainingAmount = totalAmount;
        numCat1 = remainingAmount / CAT_1;
        remainingAmount = remainingAmount % CAT_1;
        numCat2 = remainingAmount / CAT_2;
        remainingAmount = remainingAmount % CAT_2;
        numCat3 = remainingAmount / CAT_3;
        remainingAmount = remainingAmount % CAT_3;
        numCat4 = remainingAmount / CAT_4;
        remainingAmount = remainingAmount % CAT_4;
        
        // 4. Display results
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%n", COL_H1, 
            CAT_1 + COL_UNITS, CAT_2 + COL_UNITS, CAT_3 + COL_UNITS, 
            CAT_4 + COL_UNITS);
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%n", totalAmount,
            numCat1, numCat2, numCat3, numCat4);
        
        // 5. Close and exit
        userInput.close();
    }

}