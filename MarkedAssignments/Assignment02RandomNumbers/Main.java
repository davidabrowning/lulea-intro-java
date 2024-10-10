package MarkedAssignments.Assignment02RandomNumbers;

// Imports
import java.util.Scanner;

/**
 * PROGRAM DESCRIPTION
 * 1. User enters how many random numbers are needed (1 - Integer.MAX_VALUE)
 * 2. Randomize the specified numbers
 * 3. Print the numbers in the order in which they were randomized
 * 4. Order the even integers ascending
 * 5. Order the odd integers descending
 * 6. Print the numbers with a punctuation mark between even and odd
 * 7. Print a summary of how many even and odd numbers were present
 * 8. Close the Scanner and exit
 * 
 * @author David Browning (davbro-4)
 * @version 1.0
 */
class Main {

    // Declare constants
    static final String USER_INPUT_PROMPT = "How many random numbers in the range 0 - 999 are desired?";
    static final String RANDOM_NUMBERS_LIST_MESSAGE = "Here are the random numbers:";
    static final String RANDOM_NUMBERS_SORTED_MESSAGE = "Here are the random numbers arranged:";
    static final String NO_ODD_NUMBERS_MESSAGE = "No Odd Numbers";
    static final String NO_EVEN_NUMBERS_MESSAGE = "No Even Numbers";
    static final String INVALID_INPUT_MESSAGE = "Invalid Input";    

    public static void main(final String[] args) {

        // Declare variables
        Scanner userInput = new Scanner(System.in); // Used for reading user input
        int[] randomNumbers = null;                 // Holds all random numbers
        int[] evenNumers = null;                    // Holds the even numbers calculated
        int[] oddNumbers = null;                    // Holds the odd numbers calculated
        int evenNumberCount = 0;                    // Stores the number of even numbers calculated
        int oddNumberCount = 0;                     // Stores the number of odd numbers calculated

        System.out.println("Hello world!");
    }
} // end class
