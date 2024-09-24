package TaskSet04;

// Imports
import java.util.Scanner;

/**
 * TASK: 
 * Construct a loop executed until the user enters a number that is not greater than zero.
 * Modify the loop so the number must be less than zero to achieve termination.
 * 
 * PROGRAM DESCRIPTION:
 * 1. Print instructions
 * 2. Validate input
 * 3. Collect input
 * 4. Check criterion for exiting loop
 * 
 * @author David Browning (davbro-4)
 */

public class Task0406 {

    // Constants
    private static String INPUT_INSTRUCTIONS = "Enter a number not greater than zero to exit this loop: ";

    public static void main(String[] args) {

        // Variables
        Scanner userInput = new Scanner(System.in);
        int enteredNum = 0;

        do {

            // 1. Print instructions
            System.out.printf("%s", INPUT_INSTRUCTIONS);

            // 2. Validate input
            if (!userInput.hasNextInt()) {
                userInput.nextLine();
                continue;
            }

            // 3. Collect input
            enteredNum = userInput.nextInt();

        } while (enteredNum > 0);

    }
    
}
