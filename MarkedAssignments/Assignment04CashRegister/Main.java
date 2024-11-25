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
    public static final String MENU_PROMPT_ITEM_TO_REMOVE = "Which item ID to remove? ";
    public static final String MENU_PROMPT_ITEM_ID_TO_SELL = "Which item ID to sell? ";
    public static final String MENU_PROMPT_ITEM_COUNT_TO_SELL = "How many copies of item to sell? ";

    // Constants for confirmation messages
    public static final String CONFIRMATION_ITEM_REMOVED = "Item %d successfully removed.%n";

    // Constants for warning messages
    public static final String WARNING_REMOVAL_ITEM_NOT_FOUND = "Item %d not found.%n";

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
                    int removedItemNumber = 0;
                    System.out.print(MENU_PROMPT_ITEM_TO_REMOVE);
                    removedItemNumber = input();
                    removeItem(items, removedItemNumber);
                    break;

                // Display a list of items
                case MENU_ITEM_3:
                    printItems(items);
                    break;

                // Register a sale
                case MENU_ITEM_4:
                    int soldItemId = 0;
                    int soldItemCount = 0;
                    System.out.print(MENU_PROMPT_ITEM_ID_TO_SELL);
                    soldItemId = input();
                    System.out.print(MENU_PROMPT_ITEM_COUNT_TO_SELL);
                    soldItemCount = input();
                    sellItem(sales, saleDates, items, soldItemId, soldItemCount);
                    break;

                // Display sales history
                case MENU_ITEM_5:
                    printSales(sales, saleDates);
                    break;

                // Sort and display sales history table
                case MENU_ITEM_6:
                    sortedTable(sales, saleDates);
                    break;

                // Quit
                case MENU_ITEM_Q:
                    System.out.println("Thank you for using the cash register.");
                    break;

                // Other unexpected input
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

        // Remove item if it exists in items and return 0
        for (int i = 0; i < items.length; i++) {
            if (items[i][ITEM_ID] == itemId) {
                items[i][ITEM_ID] = 0;
                items[i][ITEM_COUNT] = 0;
                items[i][ITEM_PRICE] = 0;
                System.out.printf(CONFIRMATION_ITEM_REMOVED, itemId);
                return 0;
            }
        }

        // Otherwise print warning that item was not found and return -1
        System.out.printf(WARNING_REMOVAL_ITEM_NOT_FOUND, itemId);
        return -1;
    }

    /**
     * Prints item number, number, and price for all items that have an item number. 
     * The printout is sorted into ascending item numbers.
     * @param items an array of items
     */
    public static void printItems(final int[][] items) {
        int[][] sortedItemArray = items;
        int[] itemSwapHelper = new int[ITEM_COLUMN_SIZE];

        for (int i = 0; i < sortedItemArray.length; i++) {
            for (int j = 0; j < sortedItemArray.length - 1; j++) {
                if (sortedItemArray[j][ITEM_ID] > sortedItemArray[j+1][ITEM_ID]) {
                    itemSwapHelper[ITEM_ID] = sortedItemArray[j][ITEM_ID];
                    itemSwapHelper[ITEM_COUNT] = sortedItemArray[j][ITEM_COUNT];
                    itemSwapHelper[ITEM_PRICE] = sortedItemArray[j][ITEM_PRICE];
                    sortedItemArray[j][ITEM_ID] = sortedItemArray[j+1][ITEM_ID];
                    sortedItemArray[j][ITEM_COUNT] = sortedItemArray[j+1][ITEM_COUNT];
                    sortedItemArray[j][ITEM_PRICE] = sortedItemArray[j+1][ITEM_PRICE];
                    sortedItemArray[j+1][ITEM_ID] = itemSwapHelper[ITEM_ID];
                    sortedItemArray[j+1][ITEM_COUNT] = itemSwapHelper[ITEM_COUNT];
                    sortedItemArray[j+1][ITEM_PRICE] = itemSwapHelper[ITEM_PRICE];
                }
            }
        }

        for (int i = 0; i < sortedItemArray.length; i++) {
            if (sortedItemArray[i][ITEM_ID] != 0 ) {
                System.out.printf("%d %d %d%n", sortedItemArray[i][ITEM_ID], sortedItemArray[i][ITEM_COUNT], sortedItemArray[i][ITEM_PRICE]);
            }
        }
    }

    public static int getFirstEmptySalesRowIndex(final int[][] sales) {
        for (int i = 0; i < sales.length; i++) {
            if (sales[i][SALE_ITEM_ID] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void insertSale(final int[][] sales, final Date[] salesDate, final int itemIdToSell, final int amountToSell, final int unitPrice) {
        int firstEmptySalesRowIndex = 0;
        Date dateOfSale = null;
        int totalPrice = 0;

        firstEmptySalesRowIndex = getFirstEmptySalesRowIndex(sales);
        dateOfSale = new Date();
        totalPrice = amountToSell * unitPrice;

        sales[firstEmptySalesRowIndex][SALE_ITEM_ID] = itemIdToSell;
        sales[firstEmptySalesRowIndex][SALE_ITEM_COUNT] = amountToSell;
        sales[firstEmptySalesRowIndex][SALE_ITEM_PRICE] = totalPrice;
        salesDate[firstEmptySalesRowIndex] = dateOfSale;
    }

    public static int sellItem(final int[][] sales, final Date[] salesDate, final int[][] items, final int itemIdToSell, final int amountToSell) {

        int inventory = 0;
        int unitPrice = 0;

        // Find item in items array and sell desired count
        for (int i = 0; i < items.length; i++) {
            if (items[i][ITEM_ID] == itemIdToSell) {

                inventory = items[i][ITEM_COUNT];
                unitPrice = items[i][ITEM_PRICE];

                
                // If inventory exceeds sell amount, sell some of the inventory and return 0
                if (inventory > amountToSell) {
                    insertSale(sales, salesDate, itemIdToSell, amountToSell, unitPrice);
                    items[i][ITEM_COUNT] -= amountToSell;
                    return 0;
                }

                // If inventory equals sell amount, sell full inventory and return 0
                if (inventory == amountToSell) {
                    insertSale(sales, salesDate, itemIdToSell, amountToSell, unitPrice);
                    items[i][ITEM_ID] = 0;
                    items[i][ITEM_COUNT] = 0;
                    items[i][ITEM_PRICE] = 0;
                    return 0;
                }                

                // If inventory is less than sell amount, sell full inventory and return amount sold
                if (inventory < amountToSell) {
                    insertSale(sales, salesDate, itemIdToSell, inventory, unitPrice);
                    items[i][ITEM_ID] = 0;
                    items[i][ITEM_COUNT] = 0;
                    items[i][ITEM_PRICE] = 0;
                    return items[i][ITEM_COUNT];
                }                   
            }
        }

        // If item is not found, return -1
        return -1;
    }

    public static void printSales(final int[][] sales, final Date[] salesDate) {
        for (int i = 0; i < sales.length; i++) {
            if (sales[i][SALE_ITEM_ID] == 0) {
                continue;
            }
            System.out.printf("%d %d %d %s%n", sales[i][SALE_ITEM_ID], sales[i][SALE_ITEM_COUNT], sales[i][SALE_ITEM_PRICE], salesDate[i]);
        }
    }

    /**
     * sort the selling table by item number, in ascending order
     * @param sales
     * @param salesDate
     */
    public static void sortedTable(final int[][] sales,  final Date[] salesDate) {
        int[][] sortedSales = sales;
        Date[] sortedSalesDate = salesDate;
        int[] salesSwapHelper = new int[SALE_COLUMN_SIZE];
        Date dateSwapHelper = null;

        for (int i = 0; i < sortedSales.length; i++) {
            for (int j = 0; j < sortedSales.length - 1; j++) {
                if (sortedSales[j][SALE_ITEM_ID] > sortedSales[j+1][SALE_ITEM_ID]) {
                    salesSwapHelper[SALE_ITEM_ID] = sortedSales[j][SALE_ITEM_ID];
                    salesSwapHelper[SALE_ITEM_COUNT] = sortedSales[j][SALE_ITEM_COUNT];
                    salesSwapHelper[SALE_ITEM_PRICE] = sortedSales[j][SALE_ITEM_PRICE];
                    sortedSales[j][SALE_ITEM_ID] = sortedSales[j+1][SALE_ITEM_ID];
                    sortedSales[j][SALE_ITEM_COUNT] = sortedSales[j+1][SALE_ITEM_COUNT];
                    sortedSales[j][SALE_ITEM_PRICE] = sortedSales[j+1][SALE_ITEM_PRICE];
                    sortedSales[j+1][SALE_ITEM_ID] = salesSwapHelper[SALE_ITEM_ID];
                    sortedSales[j+1][SALE_ITEM_COUNT] = salesSwapHelper[SALE_ITEM_COUNT];
                    sortedSales[j+1][SALE_ITEM_PRICE] = salesSwapHelper[SALE_ITEM_PRICE];
                    dateSwapHelper = sortedSalesDate[j];
                    sortedSalesDate[j] = sortedSalesDate[j+1];
                    sortedSalesDate[j+1] = dateSwapHelper;
                }
            }
        }

        for (int i = 0; i < sortedSales.length; i++) {
            if (sortedSales[i][SALE_ITEM_ID] == 0) {
                continue;
            }
            System.out.printf("%d %d %d %s%n", sortedSales[i][SALE_ITEM_ID], sortedSales[i][SALE_ITEM_COUNT], sortedSales[i][SALE_ITEM_PRICE], sortedSalesDate[i]);
        }
    }
}