package TaskSet04;

// Imports

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
    private static int LUNCH_START = 1200;
    private static int LUNCH_END = 1300;
    private static String LOGICAL_HEADER = "*Using compound logical expression*";
    private static String NESTED_IF_HEADER = "*Using nested if statements*";
    private static String IS_LUNCH = "It is currently lunchtime!";
    private static String NOT_LUNCH = "It is not currently lunchtime.";

    public static void main(String[] args) {

        // Declare variables

    }
    
}