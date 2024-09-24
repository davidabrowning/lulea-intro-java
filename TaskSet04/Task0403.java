package TaskSet04;

// Imports
import java.util.Scanner;

/**
 * TASK:
 * A kiosk sells scoops of ice cream in variants one, two, or three scoops. 
 * A girl who wants to buy one of the variants has a limited weekly allowance. 
 * She can therefore buy one of the three variants only if she has enough money. 
 * Create a program that gives the girl's weekly allowance, and the prices below 
 * show which variants the girl can buy. Your program when a weekly allowance is 
 * entered, can print which option she can buy.
 * Prices:
 *      1 scoop- 10 kr
 *      2 scoops - 15 kr
 *      3 scoops - 20 kr
 * 
 * PROGRAM DESCRIPTION:
 * 1. Ask user for weekly allowance amount
 * 2. Validate user input
 * 3. Print which option user can buy
 * 
 * @author David Browning (davbro-4)
 */
public class Task0403 {

    // Declare constants
    private static String MENU_QUIT_KEY = "Q";
    private static String USER_INPUT_PROMPT = "Please enter your weekly allowance in kronor (q to quit): ";
    private static String INVALID_INPUT_TEXT = "Invalid weekly allowance.";
    private static String MENU_EXIT_TEXT = "Exiting program.";
    private static int SINGLE_SEK = 10;
    private static int DOUBLE_SEK = 15;
    private static int TRIPLE_SEK = 20;
    private static String ZERO_STATEMENT = "You cannot afford any ice cream this week.";
    private static String SINGLE_STATEMENT = "You can buy a single scoop!";
    private static String DOUBLE_STATEMENT = "You can buy a double scoop!";
    private static String TRIPLE_STATEMENT = "You can buy a triple scoop!";

    public static void main(String[] args) {

        // Declare local variables
        Scanner userInput = new Scanner(System.in);
        int weeklyAllowance = 0;
        String purchaseAnnouncement = "";

        // Menu loop
        while (true) {

            // 1. Ask user for weekly allowance amount
            System.out.printf(USER_INPUT_PROMPT);

            // 2. Validate user input
            if (!userInput.hasNextInt()) {
                if (userInput.next().toUpperCase().equals(MENU_QUIT_KEY)) {
                    System.out.printf("%s%n", MENU_EXIT_TEXT);
                    userInput.close();
                    return;
                }
                System.out.printf("%s%n", INVALID_INPUT_TEXT);
                continue;
            }
            weeklyAllowance = userInput.nextInt();
            userInput.nextLine();

            // 3. Print which option the user can buy
            if (weeklyAllowance < SINGLE_SEK) {
                purchaseAnnouncement = ZERO_STATEMENT;
            } else if (weeklyAllowance < DOUBLE_SEK) {
                purchaseAnnouncement = SINGLE_STATEMENT;
            } else if (weeklyAllowance < TRIPLE_SEK) {
                purchaseAnnouncement = DOUBLE_STATEMENT;
            } else {
                purchaseAnnouncement = TRIPLE_STATEMENT;
            }
            System.out.printf("%s%n", purchaseAnnouncement);

        }

    }
    
}
