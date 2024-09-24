package TaskSet04;

// Imports

/**
 * TASK:
 * Try to implement a while loop that prints the love message 
 * "love, love everywhere" 10 times by updating the index 
 * inside the while block, by directly updating with pre-
 * increment in the condition statement.  
 * 
 * Does it matter if you use pre-increment (++i) or post-
 * increment (i++) in the condition? Try changing how you 
 * make the increments and test rerun your program with the 
 * new implementation.
 * 
 * @author David Browning (davbro-4)
 */

public class Task0408 {

    // Constants
    private static String MESSAGE = "love, love everywhere";

    public static void main(String[] args) {

        // Variables
        int counter = 1;

        while (counter <= 10) {
            System.out.printf("%d. %s%n", counter++, MESSAGE);
        }

    }
    
}
