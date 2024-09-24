package TaskSet04;

// Imports
import java.util.Scanner;

/**
 * TASK:
 * For a particular program, you want to use an entered time value to 
 * tell whether it is lunchtime or not. Lunchtime is defined as the 
 * interval between the times 1200 -1300.
 *      -   Think about how the combination of logical operators and 
 *          comparison operators can describe a compound logical 
 *          expression to decide about whether it is lunch or not for 
 *          the entered time. In this case, you can represent the 
 *          time as an integer, given that you do not use a colon. 
 *          1200 is entered and not 12:00
 *      -   Show an alternative solution where you replace your 
 *          logical operator with a nested if statement (one if 
 *          statement inside another if statement)
 * 
 * PROGRAM DESCRIPTION:
 * 1. Ask user for current time
 * 2. Validate input
 * 3. Check if lunchtime (compound logical expression)
 * 4. Check if lunchtime (nested if statement)
 * 
 * @author David Browning (davbro-4)
 */
public class Task0404 {

    // Declare constants
    private static String INPUT_PROMPT = "Please enter the current time (HHMM, q to quit): ";
    private static String INVALID_INPUT_MESSAGE = "Invalid time.";
    private static String MENU_EXIT_STRING = "Q";
    private static String MENU_EXIT_MESSAGE = "Now exiting program.";
    private static String INPUT_CONFIRMATION_MESSAGE = "You entered: ";
    private static int LUNCH_START = 1200;
    private static int LUNCH_END = 1300;
    private static String LOGICAL_HEADER = "*Using compound logical expression*";
    private static String NESTED_IF_HEADER = "*Using nested if statements*";
    private static String IS_LUNCH = "It is currently lunchtime!";
    private static String NOT_LUNCH = "It is not currently lunchtime.";

    public static void main(String[] args) {

        // Declare variables
        Scanner userInput = new Scanner(System.in);
        int currentTime = 0;
        String lunchtimeAnnouncement = "";

        // Menu loop
        while (true) {

            // 1. Ask user for current time
            System.out.printf("%n%s", INPUT_PROMPT);

            // 2. Validate input
            if (userInput.hasNextInt()) {
                currentTime = userInput.nextInt();
            } else {
                // Check if user wishes to exit the program
                if (userInput.next().toUpperCase().equals(MENU_EXIT_STRING)) {
                    System.out.printf("%s%n", MENU_EXIT_MESSAGE);
                    userInput.close();
                    System.exit(0);
                }
                System.out.printf("%s%n", INVALID_INPUT_MESSAGE);
                continue;
            }

            // 2b. Validate clock time
            if (currentTime < 0 || currentTime > 2359 || currentTime % 100 > 59) {
                System.out.printf("%s%n", INVALID_INPUT_MESSAGE);
                continue;
            }

            // 2c. Confirm input for user
            System.out.printf("%s%d%n", INPUT_CONFIRMATION_MESSAGE, currentTime);

            // 3. Check if lunchtime (compound logical expression)
            System.out.printf("%s%n", LOGICAL_HEADER);
            if (currentTime >= LUNCH_START && currentTime < LUNCH_END) {
                lunchtimeAnnouncement = IS_LUNCH;
            } else {
                lunchtimeAnnouncement = NOT_LUNCH;
            }
            System.out.printf("%s%n", lunchtimeAnnouncement);

            // 4. Check if lunchtime (nested if statement)
            System.out.printf("%s%n", NESTED_IF_HEADER);
            

        }

    }
    
}