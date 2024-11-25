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
    public static final String MENU_CHOICE_PROMPT = "Your selection: ";
    public static final String MENU_PROMPT_NUM_ITEMS_TO_ADD = "How many items to add? ";

    // Constants for menu selection numbers
    public static final int MENU_ITEM_UNSELECTED = 0;
    public static final int MENU_ITEM_1 = 1;
    public static final int MENU_ITEM_2 = 2;
    public static final int MENU_ITEM_3 = 3;
    public static final int MENU_ITEM_4 = 4;
    public static final int MENU_ITEM_5 = 5;
    public static final int MENU_ITEM_6 = 6;
    public static final int MENU_ITEM_Q = -1;

    // Other constants
    public static final int INITIAL_ITEM_NUMBER = 999;
    public static final int NEW_ITEM_BATCH_MIN_SIZE = 1;
    public static final int NEW_ITEM_BATCH_MAX_SIZE = 10;
    public static final int NEW_ITEM_MIN_PRICE = 100;
    public static final int NEW_ITEM_MAX_PRICE = 1000;
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

    /**
     * The program's main method. The entry point for the application.
     * @param args not used by the program
     */
    public static void main(final String[] args) {

        // Variables
        int userMenuSelection = MENU_ITEM_UNSELECTED; // Stores user's menu selection
        int[][] items = new int[INITIAL_ITEM_SIZE][ITEM_COLUMN_SIZE]; // Data structure to store items (itemId, itemCount, itemPrice)
        int[][] sales = new int[MAX_SALES][SALE_COLUMN_SIZE]; // Data structure to store sales (itemId, numberOfItems, sum)
        Date[] saleDates = new Date[MAX_SALES]; // Data structure to store sale dates
        int lastItemNumber = INITIAL_ITEM_NUMBER; // Keep track of last added ItemNumber

        // Print assignment title
        System.out.println("This is Marked Assignment 4");

        // Print menu and handle user menu selection
        while (userMenuSelection != MENU_ITEM_Q) {
            userMenuSelection = menu();
            switch(userMenuSelection) {

                // Insert items and increment lastItemNumber
                case MENU_ITEM_1:
                    int numNewItems = 0;
                    System.out.print(MENU_PROMPT_NUM_ITEMS_TO_ADD);
                    numNewItems = input();
                    items = insertItems(items, lastItemNumber, numNewItems);
                    lastItemNumber += numNewItems;
                    break;

                // Remove an item
                case MENU_ITEM_2:

                // Display a list of items
                case MENU_ITEM_3:
                    printItems(items);
                    break;

                // Register a sale
                case MENU_ITEM_4:

                // Display sales history
                case MENU_ITEM_5:

                // Sort and display sales history table
                case MENU_ITEM_6:

                // Quit
                case MENU_ITEM_Q:
                    System.out.println("Thank you for using the cash register.");
                    break;
                default:
                    System.out.println("Unexpected menu behavior.");
                    break;
            }
        }
    }

    /**
     * Return a randomly selected int between min and max, inclusive.
     * @param min lower bound, inclusive
     * @param max upper bound, inclusive
     * @return randomly selected int within range
     */
    public static int selectRandomInt(final int min, final int max) {
        int selectedInt = 0;
        selectedInt = (int) (Math.random() * (max - min + 1) + min);
        return selectedInt;
    }

    /**
     * Present menu. Collect and return user's selection.
     * @return user's menu selection
     */
    public static int menu() {

        // Variables
        int userMenuSelection = 0; // Stores user's menu selection

        // Print menu options
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n", 
            MENU_CHOICE_1, MENU_CHOICE_2, MENU_CHOICE_3, 
            MENU_CHOICE_4, MENU_CHOICE_5, MENU_CHOICE_6, 
            MENU_CHOICE_Q);

        // Collect and return user menu selection
        while(true) {
            System.out.print(MENU_CHOICE_PROMPT);
            userMenuSelection = input();
            if (userMenuSelection == MENU_ITEM_1 
                || userMenuSelection == MENU_ITEM_2 
                || userMenuSelection == MENU_ITEM_3
                || userMenuSelection == MENU_ITEM_4 
                || userMenuSelection == MENU_ITEM_5 
                || userMenuSelection == MENU_ITEM_6
                || userMenuSelection == MENU_ITEM_Q
            ) {
                return userMenuSelection;
            }
        }
    }

    /**
     * Collect user input. Valid inputs are integers and q to quit.
     * Repeat until valid input is received.
     * @return valid user input
     */
    public static int input() {

        // Declare variables
        int userIntegerInput = 0;
        String userNonIntegerInput = "";

        // Collect and validate user input
        // If integer input, return integer
        // If non-integer input, check for valid "quit" menu input
        // Otherwise, ask user to try again
        while(true) {
            if (userInputScanner.hasNextInt()) {
                userIntegerInput = userInputScanner.nextInt();
                return userIntegerInput;
            } else {
                userNonIntegerInput = userInputScanner.next();
                if (userNonIntegerInput.equals("q")) {
                    return MENU_ITEM_Q;
                } else {
                    System.out.printf("Invalid input. Please try again: ");
                }
            }
        }
    }

    public static int checkNumEmptyRows(final int[][] items) {
        int numEmptyRows = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i][ITEM_ID] == 0) {
                numEmptyRows++;
            }
        }
        return numEmptyRows;
    }

    public static boolean checkFull(final int[][] items, final int noOfItems) {
        int numEmptyRows = 0;
        numEmptyRows = checkNumEmptyRows(items);
        return numEmptyRows < noOfItems;
    }

    public static int[][] extendArray(final int[][]items, final int noOfItems) {
        int[][] workingItemsArray = null;
        workingItemsArray = new int[items.length + noOfItems][ITEM_COLUMN_SIZE];
        for (int i = 0; i < items.length; i++) {
            workingItemsArray[i][ITEM_ID] = items[i][ITEM_ID];
            workingItemsArray[i][ITEM_COUNT] = items[i][ITEM_COUNT];
            workingItemsArray[i][ITEM_PRICE] = items[i][ITEM_PRICE];
        }
        return workingItemsArray;
    }

    public static int[][] insertItems(final int[][] items, final int lastItemId, final int noOfItems) {
        System.out.println("Now adding " + noOfItems + " items.");

        // Variables
        int nextItemId = lastItemId + 1;
        int[][] workingItemsArray = items;

        // Extend the workingItemsArray if necessary
        if (checkFull(items, noOfItems)) {
            workingItemsArray = extendArray(items, noOfItems);
        }

        // Add all of the new items
        for (int newItemNum = 0; newItemNum < noOfItems; newItemNum++) {
            int newItemId = nextItemId;
            int newItemCount = selectRandomInt(NEW_ITEM_BATCH_MIN_SIZE, NEW_ITEM_BATCH_MAX_SIZE);
            int newItemPrice = selectRandomInt(NEW_ITEM_MIN_PRICE, NEW_ITEM_MAX_PRICE);

            // Insert this item into an empty row
            for (int itemRowNum = 0; itemRowNum < workingItemsArray.length; itemRowNum++) {
                if (workingItemsArray[itemRowNum][ITEM_ID] == 0) {
                    System.out.println("Item " + newItemId + " added.");
                    workingItemsArray[itemRowNum][ITEM_ID] = newItemId;
                    workingItemsArray[itemRowNum][ITEM_COUNT] = newItemCount;
                    workingItemsArray[itemRowNum][ITEM_PRICE] = newItemPrice;
                    break;
                }
            }

            // Increment nextItemId counter
            nextItemId++;
        }
        
        return workingItemsArray;
    }

    public static int removeItem(final int[][] items, final int itemId) {
        return 0;
    }

    /**
     * Prints item number, number, and price for all items that have an item number. 
     * The printout is sorted into ascending item numbers.
     * @param items an array of items
     */
    public static void printItems(final int[][] items) {
        for (int i = 0; i < items.length; i++) {
            if (items[i][ITEM_ID] != 0 ) {
                System.out.printf("%d %d %d%n", items[i][ITEM_ID], items[i][ITEM_COUNT], items[i][ITEM_PRICE]);
            }
        }
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