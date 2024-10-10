package MarkedAssignments.Assignment02RandomNumbers;

// Imports
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.OutOfMemoryError;

/**
 * PROGRAM DESCRIPTION
 * 1. User enters how many random numbers are needed (1 - Integer.MAX_VALUE)
 * 1b. Initialize arrays that will hold results
 * 2. Randomize the specified numbers
 * 3. Print the numbers in the order in which they were randomized
 * 4. Sort the integers into evens and odds
 * 5. Order the even integers ascending
 * 7. Order the odd integers descending
 * 8. Print the numbers with a punctuation mark between even and odd
 * 8a. Print the even numbers
 * 8b. Print the punctuation mark
 * 8c. Print the odd numbers
 * 9. Print a summary of how many even and odd numbers were present
 * 10. Close the Scanner and exit
 * 
 * @author David Browning (davbro-4)
 * @version 1.0
 */
class Main {

    // Declare constants
    static final String USER_INPUT_PROMPT = "How many random numbers in the"
        + " range 0 - 999 are desired?";
    static final String RANDOM_NUMBERS_LIST_MESSAGE = "Here are the random"
        + " numbers:";
    static final String RANDOM_NUMBERS_SORTED_MESSAGE = "Here are the random"
        + " numbers arranged:";
    static final String NO_ODD_NUMBERS_MESSAGE = "No Odd Numbers";
    static final String NO_EVEN_NUMBERS_MESSAGE = "No Even Numbers";
    static final String INVALID_INPUT_MESSAGE = "Invalid Input";
    static final String PUNCTUATION_MARK = "-";
    static final int RANDOM_INTEGER_MIN = 0;
    static final int RANDOM_INTEGER_MAX = 999;

    public static void main(final String[] args) {

        // Declare variables
        Scanner userInput = new Scanner(System.in); // Reads user input
        int numRandomNumbersToGenerate = 0;         // How many ints to create
        int[] randomNumbers = null;                 // Holds random numbers
        int[] evenNumbers = null;                    // Holds even numbers
        int[] oddNumbers = null;                    // Holds odd numbers
        int evenNumberCount = 0;                    // Holds even number count
        int oddNumberCount = 0;                     // Holds odd number count
        boolean foundSwap = false;                  // Tracks if ints swapped
        int swapPlaceholder = 0;                    // Helps swap integers

        // 1. User enters how many random numbers are needed (1 - Integer.MAX_VALUE)
        System.out.print(USER_INPUT_PROMPT + " ");
        try {
            numRandomNumbersToGenerate = userInput.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT_MESSAGE);
            System.exit(0);
        }
        if (numRandomNumbersToGenerate > Integer.MAX_VALUE) {
            System.out.println(INVALID_INPUT_MESSAGE);
            System.exit(0);
        }

        // 1b. Initialize arrays that will hold results
        try {
            randomNumbers = new int[numRandomNumbersToGenerate];
            evenNumbers = new int[numRandomNumbersToGenerate];
            oddNumbers = new int[numRandomNumbersToGenerate];
        } catch (OutOfMemoryError e) {
            System.out.println(INVALID_INPUT_MESSAGE);
            System.exit(0);            
        }

        // 2. Randomize the specified numbers
        for (int i = 0; i < randomNumbers.length; i++) {
            int randomNum = (int) (Math.random() * (RANDOM_INTEGER_MAX + 1));
            randomNumbers[i] = randomNum;
        }

        // 3. Print the numbers in the order in which they were randomized
        System.out.printf("%n%s%n", RANDOM_NUMBERS_LIST_MESSAGE);
        for (int i = 0; i < randomNumbers.length; i++) {
            if (i > 0) {                
                // If not the first element, print a leading space                
                System.out.print(" ");
            }
            System.out.print(randomNumbers[i]);
        }
        System.out.printf("%n");

        // 4. Sort the integers into evens and odds
        for (int i = 0; i < randomNumbers.length; i++) {
            if (randomNumbers[i] % 2 == 0) {
                evenNumbers[evenNumberCount] = randomNumbers[i];
                evenNumberCount++;
            } else {
                oddNumbers[oddNumberCount] = randomNumbers[i];
                oddNumberCount++;
            }
        }

        // 5. Order the even integers ascending
        for (int i = 0; i < evenNumberCount; i++) {
            foundSwap = false;
            for (int j = 1; j < evenNumberCount; j++) {
                if (evenNumbers[j] < evenNumbers[j-1]) {
                    foundSwap = true;
                    swapPlaceholder = evenNumbers[j];
                    evenNumbers[j] = evenNumbers[j-1];
                    evenNumbers[j-1] = swapPlaceholder;
                }
            }
            if (!foundSwap) {
                break;
            }
        }

        // 7. Order the odd integers descending
        for (int i = 0; i < oddNumberCount; i++) {
            foundSwap = false;
            for (int j = 1; j < oddNumberCount; j++) {
                if (oddNumbers[j] > oddNumbers[j-1]) {
                    foundSwap = true;
                    swapPlaceholder = oddNumbers[j];
                    oddNumbers[j] = oddNumbers[j-1];
                    oddNumbers[j-1] = swapPlaceholder;
                }
            }
            if (!foundSwap) {
                break;
            }
        }        

        // 8. Print the numbers with a punctuation mark between even and odd
        System.out.printf("%n%s%n", RANDOM_NUMBERS_SORTED_MESSAGE);

        // 8a. Print the even numbers
        if (evenNumberCount == 0) {
            System.out.print(NO_EVEN_NUMBERS_MESSAGE);
        } else {
            for (int i = 0; i < evenNumberCount; i++) {
                System.out.print(evenNumbers[i]);
                if (i < evenNumberCount - 1) {
                    // If not the last item, print a buffer space
                    System.out.print(" ");
                }
            }
        }

        // 8b. Print the punctuation mark
        System.out.printf(" %s ", PUNCTUATION_MARK);

        // 8c. Print the odd numbers
        if (oddNumberCount == 0) {
            System.out.print(NO_ODD_NUMBERS_MESSAGE);
        } else {
            for (int i = 0; i < oddNumberCount; i++) {
                System.out.print(oddNumbers[i]);
                if (i < oddNumberCount - 1) {
                    // If not the last item, print a buffer space
                    System.out.print(" ");
                }
            }
        }
        System.out.printf("%n");

        // 9. Print a summary of how many even and odd numbers were present
        System.out.printf("%n");
        if (numRandomNumbersToGenerate == 1) {
            System.out.printf("Of the above %d number", numRandomNumbersToGenerate);
        } else {
            System.out.printf("Of the above %d numbers", numRandomNumbersToGenerate);
        }
        System.out.printf(", ");
        if (evenNumberCount == 1) {
            System.out.printf("%d was even and %d odd", evenNumberCount, 
                oddNumberCount);
        } else {
            System.out.printf("%d were even and %d odd", evenNumberCount, 
                oddNumberCount);            
        }

        // 10. Close the Scanner and exit
        userInput.close();
    }
} // end class
