package MarkedAssignments.Assignment04CashRegister;

// Imports
import java.util.Scanner;
import java.util.Date;

/**
 * PROGRAM DESCRIPTION
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

    // Other constants
    public static final int MENU_ITEM_1 = 1;
    public static final int MENU_ITEM_2 = 2;
    public static final int MENU_ITEM_3 = 3;
    public static final int MENU_ITEM_4 = 4;
    public static final int MENU_ITEM_5 = 5;
    public static final int MENU_ITEM_6 = 6;
    public static final int MENU_ITEM_Q = -1;
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
        int[][] items = new int[INITIAL_ITEM_SIZE][ITEM_COLUMN_SIZE]; // Data structure to store items
        int[][] sales = new int[MAX_SALES][SALE_COLUMN_SIZE]; // Data structure to store sales
        Date[] saleDates = new Date[MAX_SALES]; // Data structure to store sale dates
        int lastItemNumber = INITIAL_ITEM_NUMBER; // Keep track of last added ItemNumber

        System.out.println("This is Marked Assignment 4");
    }

    public static int menu() {
        return 0;
    }

    public static int input() {
        return 0;
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