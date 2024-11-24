package MarkedAssignments.Assignment04CashRegister;

// Imports
import java.util.Scanner;
import java.util.Date;

/**
 * PROGRAM DESCRIPTION
 * Print menu
 * Collect and validate user input
 * If user chooses "1. Insert items"
 * If user chooses "2. Remove an item"
 * If user chooses "3. Display a list of items"
 * If user chooses "4. Register a sale"
 * If user chooses "5. Display sales history"
 * If user chooses "6. Sort and display sales history table"
 * If user chooses "q. Quit"
 * SWITCH menu choice
 * 
 * END SWITCH
 *
 * @author David Browning (davbro-4)
 * @version 1.0
 */
public class Main {

    // Constants for the item array
    public static final int ITEM_ID = 0;
    public static final int ITEM_COUNT = 1;
    public static final int ITEM_PRICE = 2;
    public static final int ITEM_COLUMN_SIZE = 3;
    public static final int INITIAL_ITEM_SIZE = 10;

    // Constants for the sales array
    public static final int SALE_ITEM_ID = 0;
    public static final int SALE_ITEM_COUNT = 1;
    public static final int SALE_ITEM_PRICE = 2;
    public static final int SALE_COLUMN_SIZE = 3;
    public static final int MAX_SALES = 1000;

    // Constants for menu options
    public static final String MENU_CHOICE_1 = "1. Insert items";
    public static final String MENU_CHOICE_2 = "2. Remove an item";
    public static final String MENU_CHOICE_3 = "3. Display a list of items";
    public static final String MENU_CHOICE_4 = "4. Register a sale";
    public static final String MENU_CHOICE_5 = "5. Display sales history";
    public static final String MENU_CHOICE_6 = "6. Sort and display sales history table";
    public static final String MENU_CHOICE_Q = "q. Quit";
    public static final String MENU_CHOICE_PROMPT = "Your Selection:";

    // Constants for menu selection numbers
    public static final int MENU_ITEM_1 = 1;
    public static final int MENU_ITEM_2 = 2;
    public static final int MENU_ITEM_3 = 3;
    public static final int MENU_ITEM_4 = 4;
    public static final int MENU_ITEM_5 = 5;
    public static final int MENU_ITEM_6 = 6;
    public static final int MENU_ITEM_Q = -1;

    // Other constants
    public static final int INITIAL_ITEM_NUMBER = 999;
    private static Scanner userInputScanner = new Scanner(System.in);

    /**
     * This method should be used only for unit testing on CodeGrade. Do not change this method!
     * Swaps userInputScanner with a custom scanner object bound to a test input stream
     *
     * @param inputScanner  test scanner object
     */
    public static void injectInput(final Scanner inputScanner) {
        userInputScanner = inputScanner;
    }

    public static void main(final String[] args) {

        // Constants
        int[][] items = new int[INITIAL_ITEM_SIZE][ITEM_COLUMN_SIZE]; // Data structure to store items
        int[][] sales = new int[MAX_SALES][SALE_COLUMN_SIZE]; // Data structure to store sales
        Date[] saleDates = new Date[MAX_SALES]; // Data structure to store sale dates
        int lastItemNumber = INITIAL_ITEM_NUMBER; // Keep track of last added ItemNumber

        // Print assignment title
        System.out.println("This is Marked Assignment 4");

        // Print menu
        while (lastItemNumber != MENU_ITEM_Q) {
            lastItemNumber = menu();
        }
    }

    /**
     * Present menu. Collect and return user's selection.
     * @return user's menu selection
     */
    public static int menu() {
        int userSelection = 0;  // Stores user's menu selection
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n", MENU_CHOICE_1, MENU_CHOICE_2, MENU_CHOICE_3, MENU_CHOICE_4, MENU_CHOICE_5, MENU_CHOICE_6, MENU_CHOICE_Q);
        userSelection = input();
        return userSelection;
    }

    /**
     * Collect user input. Valid inputs are integers representing valid menu choices and q to quit. Repeat until valid input is received.
     * @return valid user input
     */
    public static int input() {
        int userIntegerInput = 0;
        String userNonIntegerInput = "";
        int userSelection = 0;
        boolean validInput = false;

        // Collect and validate user input
        while(validInput == false) {
            System.out.printf("%s ", MENU_CHOICE_PROMPT);
            if (userInputScanner.hasNextInt()) {
                userIntegerInput = userInputScanner.nextInt();
                if (userIntegerInput == MENU_ITEM_1 || userIntegerInput == MENU_ITEM_2 || userIntegerInput == MENU_ITEM_3
                    || userIntegerInput == MENU_ITEM_4 || userIntegerInput == MENU_ITEM_5 || userIntegerInput == MENU_ITEM_6) {
                    userSelection = userIntegerInput;
                    validInput = true;
                }
            } else {
                userNonIntegerInput = userInputScanner.next();
                if (userNonIntegerInput.equals("q")) {
                    userSelection = MENU_ITEM_Q;
                    validInput = true;
                }
            }
        }

        return userSelection;
    }

    public static boolean checkFull(final int[][] items, final int noOfItems) {
        return false;
    }

    public static int[][] extendArray(final int[][]items, final int noOfItems) {
        return null;
    }

    public static int[][] insertItems(final int[][] items, final int lastItemId, final int noOfItems) {
        return null;
    }

    public static int removeItem(final int[][] items, final int itemId) {
        return 0;
    }

    public static void printItems(final int[][] items) {
        return;
    }

    public static int sellItem(final int[][] sales, final Date[] salesDate, final int[][] items, final int itemIdToSell, final int amountToSell) {
        return 0;
    }

    public static void printSales(final int[][] sales, final Date[] salesDate) {
        return;
    }

    public static void sortedTable(final int[][] sales,  final Date[] salesDate) {
        return;
    }
}