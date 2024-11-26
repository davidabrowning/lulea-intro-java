package MarkedAssignments.Assignment04CashRegister;

// Imports
import java.util.Scanner;
import java.util.Date;

/**
 * PROGRAM DESCRIPTION
 * Print menu
 * Collect and validate user input
 * If user chooses "1. Insert items"
 *      Ask user how many items to insert
 *      Insert desired number of items into the items database
 * If user chooses "2. Remove an item"
 *      Ask user which item id to remove
 *      Remove an item from the items database
 * If user chooses "3. Display a list of items"
 *      Display all items in the items databse
 * If user chooses "4. Register a sale"
 *      Ask user which item to sell
 *      Ask user how many units to sell
 *      Log a sale of that many units of that item
 * If user chooses "5. Display sales history"
 *      Show all sales sorted by sale date
 * If user chooses "6. Sort and display sales history table"
 *      Show all sales sorted by item id
 * If user chooses "q. Quit"
 *      Quit the cash register program
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
    public static final String MENU_CHOICE_1 =
        "1. Insert items";
    public static final String MENU_CHOICE_2 =
        "2. Remove an item";
    public static final String MENU_CHOICE_3 =
        "3. Display a list of items";
    public static final String MENU_CHOICE_4 =
        "4. Register a sale";
    public static final String MENU_CHOICE_5 =
        "5. Display sales history";
    public static final String MENU_CHOICE_6 =
        "6. Sort and display sales history table";
    public static final String MENU_CHOICE_Q =
        "q. Quit";

    // Constants for menu prompts
    public static final String MENU_PROMPT_OPTIONS =
        "%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n";
    public static final String MENU_CHOICE_PROMPT =
        "%nYour selection: ";
    public static final String MENU_PROMPT_NUM_ITEMS_TO_ADD =
        "How many items to add? ";
    public static final String MENU_PROMPT_ITEM_TO_REMOVE =
        "Which item ID to remove? ";
    public static final String MENU_PROMPT_ITEM_ID_TO_SELL =
        "Which item ID to sell? ";
    public static final String MENU_PROMPT_ITEM_COUNT_TO_SELL =
        "How many copies of item to sell? ";

    // Constants for confirmation messages
    public static final String CONFIRMATION_WELCOME_ASSIGNMENT_FOUR =
        "%nThis is Marked Assignment 4%n";
    public static final String CONFIRMATION_PROGRAM_EXIT =
        "Thank you for using the cash register.%n%n";
    public static final String CONFIRMATION_ITEM_ADDED =
        "Item %d added.%n";
    public static final String CONFIRMATION_ITEM_REMOVED =
        "Item %d removed.%n";
    public static final String CONFIRMATION_ITEM_SOLD =
        "Sold %d units of item %d at price of %d per unit.%n";
    public static final String CONFIRMATION_ITEM_SOLD_PARTIAL =
        "Failed to sell specified amount. Sold %d units of item %d at unit " 
        + "price of %d.%n";

    // Constants for warning messages
    public static final String WARNING_UNEXPECTED_MENU_BEHAVIOR =
        "Unexpected menu behavior.";
    public static final String WARNING_INVALID_MENU_SELECTION =
        "Invalid menu selection.";
    public static final String WARNING_INVALID_INPUT =
        "Invalid input. Please try again: ";
    public static final String WARNING_REMOVAL_ITEM_NOT_FOUND =
        "Could not find item %d.%n";
    public static final String WARNING_SELL_ITEM_NOT_FOUND =
        "Could not find item %d.%n";

    // Constants for menu selection numbers
    public static final int MENU_ITEM_UNSELECTED = 0;
    public static final int MENU_ITEM_1 = 1;
    public static final int MENU_ITEM_2 = 2;
    public static final int MENU_ITEM_3 = 3;
    public static final int MENU_ITEM_4 = 4;
    public static final int MENU_ITEM_5 = 5;
    public static final int MENU_ITEM_6 = 6;
    public static final int MENU_ITEM_Q = -1;

    // Constants for output tables
    public static final String TABLE_HEADER_ITEM_ID = "ID";
    public static final String TABLE_HEADER_ITEM_COUNT = "Units";
    public static final String TABLE_HEADER_ITEM_PRICE = "Unit price (SEK)";
    public static final String TABLE_ROW_ITEMS_HEADER = "%5s %10s %20s%n";
    public static final String TABLE_ROW_ITEMS = "%5d %10d %20d%n";
    public static final String TABLE_HEADER_SALES_ID = "ID";
    public static final String TABLE_HEADER_SALES_COUNT = "Units";
    public static final String TABLE_HEADER_SALES_PRICE = "Total price (SEK)";
    public static final String TABLE_HEADER_SALES_DATE = "Date of sale";
    public static final String TABLE_ROW_SALES_HEADER = "%5s %10s %20s %35s%n";
    public static final String TABLE_ROW_SALES = "%5d %10d %20d %35s%n";


    // Other constants
    public static final int INITIAL_ITEM_NUMBER = 999;
    public static final int NEW_ITEM_BATCH_MIN_SIZE = 1;
    public static final int NEW_ITEM_BATCH_MAX_SIZE = 10;
    public static final int NEW_ITEM_MIN_PRICE = 100;
    public static final int NEW_ITEM_MAX_PRICE = 1000;
    public static final String MENU_QUIT_KEY = "q";
    private static Scanner userInputScanner = new Scanner(System.in);

    /**
     * This method should be used only for unit testing on CodeGrade.
     * Do not change this method!
     * Swaps userInputScanner with a custom scanner object bound to a test
     * input stream
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

        // Stores user's menu selection
        int userMenuSelection = MENU_ITEM_UNSELECTED;

        // Data structure to store items (itemId, itemCount, itemPrice)
        int[][] items = new int[INITIAL_ITEM_SIZE][ITEM_COLUMN_SIZE];

        // Data structure to store sales (itemId, numberOfItems, sum)
        int[][] sales = new int[MAX_SALES][SALE_COLUMN_SIZE];

        // Data structure to store sale dates
        Date[] saleDates = new Date[MAX_SALES];

        // Keep track of last added ItemNumber
        int lastItemNumber = INITIAL_ITEM_NUMBER;

        // Print assignment title
        System.out.printf(CONFIRMATION_WELCOME_ASSIGNMENT_FOUR);

        // Print menu and handle user menu selection
        while (userMenuSelection != MENU_ITEM_Q) {
            userMenuSelection = menu();
            switch (userMenuSelection) {

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
                    sellItem(
                        sales, saleDates, items, soldItemId, soldItemCount
                    );
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
                    System.out.printf(CONFIRMATION_PROGRAM_EXIT);
                    break;

                // Other unexpected input
                default:
                    System.out.println(WARNING_UNEXPECTED_MENU_BEHAVIOR);
                    break;
            }
        }
    }

    /**
     * Return a randomly selected int from min to max.
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
     * Prints menu and returns user's selection.
     * @return user's menu selection
     */
    public static int menu() {

        // Variables
        int userMenuSelection = 0; // Stores user's menu selection

        // Print menu options
        System.out.printf(MENU_PROMPT_OPTIONS,
            MENU_CHOICE_1, MENU_CHOICE_2, MENU_CHOICE_3,
            MENU_CHOICE_4, MENU_CHOICE_5, MENU_CHOICE_6,
            MENU_CHOICE_Q);

        // Collect and return user menu selection
        while (true) {
            System.out.printf(MENU_CHOICE_PROMPT);
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
            } else {
                System.out.println(WARNING_INVALID_MENU_SELECTION);
            }
        }
    }

    /**
     * Collects user input. Valid inputs are integers and q to quit.
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
        while (true) {
            if (userInputScanner.hasNextInt()) {
                userIntegerInput = userInputScanner.nextInt();
                return userIntegerInput;
            } else {
                userNonIntegerInput = userInputScanner.next();
                if (userNonIntegerInput.equals(MENU_QUIT_KEY)) {
                    return MENU_ITEM_Q;
                } else {
                    System.out.printf(WARNING_INVALID_INPUT);
                }
            }
        }
    }

    /**
     * Returns an int representing the number of empty rows in an item array.
     * @param items array to check
     * @return number of empty rows
     */
    public static int checkNumEmptyRows(final int[][] items) {
        int numEmptyRows = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i][ITEM_ID] == 0) {
                numEmptyRows++;
            }
        }
        return numEmptyRows;
    }

    /**
     * Checks if items array can hold noOfItems new items. Returns true if yes
     * or false if no.
     * @param items array to check
     * @param noOfItems number of new items to add
     * @return true if array cannot hold new items (array would be full),
     * or false if array can hold the new items (array would not be full)
     */
    public static boolean checkFull(final int[][] items, final int noOfItems) {
        int numEmptyRows = 0;
        numEmptyRows = checkNumEmptyRows(items);
        return numEmptyRows < noOfItems;
    }

    /**
     * Extends an array by int noOfItems and return the extended array
     * @param items the original array
     * @param noOfItems size to increase array by
     * @return new larger array
     */
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

    /**
     * Inserts new items into the items database
     * @param items array representing items database
     * @param lastItemId id of last item inserted into items database
     * @param noOfItems number of items to insert
     * @return updated array representing items database
     */
    public static int[][] insertItems(
        final int[][] items, final int lastItemId, final int noOfItems
    ) {
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
            int newItemCount = selectRandomInt(
                NEW_ITEM_BATCH_MIN_SIZE, NEW_ITEM_BATCH_MAX_SIZE
            );
            int newItemPrice = selectRandomInt(
                NEW_ITEM_MIN_PRICE, NEW_ITEM_MAX_PRICE
            );

            // Insert this item into an empty row
            for (
                int itemRowNum = 0;
                itemRowNum < workingItemsArray.length;
                itemRowNum++
            ) {
                if (workingItemsArray[itemRowNum][ITEM_ID] == 0) {
                    System.out.printf(CONFIRMATION_ITEM_ADDED, newItemId);
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

    /**
     * Removes an item from the items database.
     * Returns 0 if items was found or -1 if item was not found.
     * @param items items database array
     * @param itemId item id to remove
     * @return 0 if item found, -1 if item not found
     */
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
     * Prints item number, number, and price for all items.
     * The printout is sorted into ascending item numbers.
     * @param items an array of items
     */
    public static void printItems(final int[][] items) {
        int[][] sortedItemArray = items;
        int[] itemSwapHelper = new int[ITEM_COLUMN_SIZE];

        // Print table heading
        System.out.printf(
            TABLE_ROW_ITEMS_HEADER,
            TABLE_HEADER_ITEM_ID,
            TABLE_HEADER_ITEM_COUNT,
            TABLE_HEADER_ITEM_PRICE
        );

        // Sort items by item id
        for (int i = 0; i < sortedItemArray.length; i++) {
            for (int j = 0; j < sortedItemArray.length - 1; j++) {
                if (
                    sortedItemArray[j][ITEM_ID]
                        > sortedItemArray[j + 1][ITEM_ID]
                ) {
                    itemSwapHelper[ITEM_ID] =
                        sortedItemArray[j][ITEM_ID];
                    itemSwapHelper[ITEM_COUNT] =
                        sortedItemArray[j][ITEM_COUNT];
                    itemSwapHelper[ITEM_PRICE] =
                        sortedItemArray[j][ITEM_PRICE];

                    sortedItemArray[j][ITEM_ID] =
                        sortedItemArray[j + 1][ITEM_ID];
                    sortedItemArray[j][ITEM_COUNT] =
                        sortedItemArray[j + 1][ITEM_COUNT];
                    sortedItemArray[j][ITEM_PRICE] =
                        sortedItemArray[j + 1][ITEM_PRICE];

                    sortedItemArray[j + 1][ITEM_ID] =
                        itemSwapHelper[ITEM_ID];
                    sortedItemArray[j + 1][ITEM_COUNT] =
                        itemSwapHelper[ITEM_COUNT];
                    sortedItemArray[j + 1][ITEM_PRICE] =
                        itemSwapHelper[ITEM_PRICE];
                }
            }
        }

        // Print items
        for (int i = 0; i < sortedItemArray.length; i++) {
            if (sortedItemArray[i][ITEM_ID] != 0) {
                System.out.printf(
                    TABLE_ROW_ITEMS,
                    sortedItemArray[i][ITEM_ID],
                    sortedItemArray[i][ITEM_COUNT],
                    sortedItemArray[i][ITEM_PRICE]
                );
            }
        }
    }

    /**
     * Identifies the first empty row in sales database array
     * @param sales sales database array
     * @return int representing first empty row in sales database array
     */
    public static int getFirstEmptySalesRowIndex(final int[][] sales) {
        for (int i = 0; i < sales.length; i++) {
            if (sales[i][SALE_ITEM_ID] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Inserts a new sale into the sales database array
     * @param sales sales database array
     * @param salesDate sales dates database array
     * @param itemIdToSell sale's item id
     * @param amountToSell sale's unit count
     * @param unitPrice sale's unit price
     */
    public static void insertSale(
        final int[][] sales,
        final Date[] salesDate,
        final int itemIdToSell,
        final int amountToSell,
        final int unitPrice
    ) {

        // Initialize variables
        int firstEmptySalesRowIndex = 0;
        Date dateOfSale = null;
        int totalPrice = 0;

        // Calculate variables' values
        firstEmptySalesRowIndex = getFirstEmptySalesRowIndex(sales);
        dateOfSale = new Date();
        totalPrice = amountToSell * unitPrice;

        // Log the sale in the sales database array and sales dates array
        sales[firstEmptySalesRowIndex][SALE_ITEM_ID] = itemIdToSell;
        sales[firstEmptySalesRowIndex][SALE_ITEM_COUNT] = amountToSell;
        sales[firstEmptySalesRowIndex][SALE_ITEM_PRICE] = totalPrice;
        salesDate[firstEmptySalesRowIndex] = dateOfSale;
    }

    /**
     * Sells an item
     * @param sales sales database array
     * @param salesDate sales dates database array
     * @param items items database array
     * @param itemIdToSell sale's item id
     * @param amountToSell sale's intended unit count
     * @return actual number of units sold, or -1 if item id not found
     */
    public static int sellItem(
        final int[][] sales,
        final Date[] salesDate,
        final int[][] items,
        final int itemIdToSell,
        final int amountToSell
    ) {

        // Initialize variables
        int inventory = 0;
        int unitPrice = 0;

        // Find item in items array and sell desired count
        for (int i = 0; i < items.length; i++) {
            if (items[i][ITEM_ID] == itemIdToSell) {

                inventory = items[i][ITEM_COUNT];
                unitPrice = items[i][ITEM_PRICE];


                // If inventory exceeds sell amount,
                // sell some of the inventory and return 0
                if (inventory > amountToSell) {
                    insertSale(
                        sales, salesDate, itemIdToSell, amountToSell, unitPrice
                    );
                    items[i][ITEM_COUNT] -= amountToSell;
                    System.out.printf(
                        CONFIRMATION_ITEM_SOLD,
                        amountToSell,
                        itemIdToSell,
                        unitPrice
                    );
                    return 0;
                }

                // If inventory equals sell amount,
                // sell full inventory and return 0
                if (inventory == amountToSell) {
                    insertSale(
                        sales, salesDate, itemIdToSell, amountToSell, unitPrice
                    );
                    items[i][ITEM_ID] = 0;
                    items[i][ITEM_COUNT] = 0;
                    items[i][ITEM_PRICE] = 0;
                    System.out.printf(
                        CONFIRMATION_ITEM_SOLD,
                        amountToSell,
                        itemIdToSell,
                        unitPrice
                    );
                    return 0;
                }

                // If inventory is less than sell amount,
                // sell full inventory and return amount sold
                if (inventory < amountToSell) {
                    insertSale(
                        sales, salesDate, itemIdToSell, inventory, unitPrice
                    );
                    items[i][ITEM_ID] = 0;
                    items[i][ITEM_COUNT] = 0;
                    items[i][ITEM_PRICE] = 0;
                    System.out.printf(
                        CONFIRMATION_ITEM_SOLD_PARTIAL,
                        inventory,
                        itemIdToSell,
                        unitPrice
                    );
                    return inventory;
                }
            }
        }

        // If item is not found, return -1
        System.out.printf(WARNING_SELL_ITEM_NOT_FOUND, itemIdToSell);
        return -1;
    }

    /**
     * Print sales table
     * @param sales sales database array
     * @param salesDate sales dates database array
     */
    public static void printSales(final int[][] sales, final Date[] salesDate) {
        // Print table header
        System.out.printf(
            TABLE_ROW_SALES_HEADER,
            TABLE_HEADER_SALES_ID,
            TABLE_HEADER_SALES_COUNT,
            TABLE_HEADER_SALES_PRICE,
            TABLE_HEADER_SALES_DATE
        );

        // Print each sale
        for (int i = 0; i < sales.length; i++) {
            if (sales[i][SALE_ITEM_ID] == 0) {
                continue;
            }
            System.out.printf(
                TABLE_ROW_SALES,
                sales[i][SALE_ITEM_ID],
                sales[i][SALE_ITEM_COUNT],
                sales[i][SALE_ITEM_PRICE],
                salesDate[i]
            );
        }
    }

    /**
     * Print sales tablse sorted by item id ascending
     * @param sales sales database array
     * @param salesDate sales dates database array
     */
    public static void sortedTable(final int[][] sales,  final Date[] salesDate) {
        int[][] sortedSales = sales;
        Date[] sortedSalesDate = salesDate;
        int[] salesSwapHelper = new int[SALE_COLUMN_SIZE];
        Date dateSwapHelper = null;

        // Sort sales
        for (int i = 0; i < sortedSales.length; i++) {
            for (int j = 0; j < sortedSales.length - 1; j++) {
                if (
                    sortedSales[j][SALE_ITEM_ID]
                        > sortedSales[j + 1][SALE_ITEM_ID]
                ) {
                    salesSwapHelper[SALE_ITEM_ID] =
                        sortedSales[j][SALE_ITEM_ID];
                    salesSwapHelper[SALE_ITEM_COUNT] =
                        sortedSales[j][SALE_ITEM_COUNT];
                    salesSwapHelper[SALE_ITEM_PRICE] =
                        sortedSales[j][SALE_ITEM_PRICE];

                    sortedSales[j][SALE_ITEM_ID] =
                        sortedSales[j + 1][SALE_ITEM_ID];
                    sortedSales[j][SALE_ITEM_COUNT] =
                        sortedSales[j + 1][SALE_ITEM_COUNT];
                    sortedSales[j][SALE_ITEM_PRICE] =
                        sortedSales[j + 1][SALE_ITEM_PRICE];

                    sortedSales[j + 1][SALE_ITEM_ID] =
                        salesSwapHelper[SALE_ITEM_ID];
                    sortedSales[j + 1][SALE_ITEM_COUNT] =
                        salesSwapHelper[SALE_ITEM_COUNT];
                    sortedSales[j + 1][SALE_ITEM_PRICE] =
                        salesSwapHelper[SALE_ITEM_PRICE];

                    dateSwapHelper = sortedSalesDate[j];
                    sortedSalesDate[j] = sortedSalesDate[j + 1];
                    sortedSalesDate[j + 1] = dateSwapHelper;
                }
            }
        }

        // Print sales table
        printSales(sortedSales, sortedSalesDate);
    }
}