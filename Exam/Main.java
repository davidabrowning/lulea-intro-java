package Exam;

// Imports
import java.util.Scanner;

 /**
  * This program models a library system where the user is a presented with a
  * menu that lets them add, loan, return, and remove books, as well as print
  * out book and loan summaries.
  * @author David Browning (davbro-4)
  * @version 1.0
 **/
public class Main {

    // Scanner
    private static Scanner userInputRetriever = new Scanner(System.in);

    // Constants: Values
    private static final int MAX_BOOK_INVENTORY_SIZE = 100;
    private static final int BOOK_ID = 0;
    private static final int BOOK_ISBN = 1;
    private static final int BOOK_TITLE = 2;
    private static final int BOOK_STATUS = 3;
    private static final int BOOK_NUM_FIELDS = 4;
    private static final int MAX_LOAN_INVENTORY_SIZE = 10000;
    private static final int LOAN_NAME = 0;
    private static final int LOAN_BOOK_ID = 1;
    private static final int LOAN_START = 2;
    private static final int LOAN_END = 3;
    private static final int LOAN_NUM_FIELDS = 4;
    private static final int ID_LENGTH = 4;
    private static final int ISBN_LENGTH_TOTAL = 11;
    private static final int ISBN_LENGTH_PART_1 = 9;
    private static final int ISBN_POSITION_HYPHEN = 9;
    private static final int ISBN_POSITION_LAST_DIGIT = 10;
    private static final int MIN_BOOK_ID = 999;
    private static final String STATUS_AVAILABLE = "Available";
    private static final String STATUS_LOANED = "Loaned";
    private static final String STATUS_REMOVED = "Removed";
    private static final int DATE_LENGTH = 10;
    private static final int DATE_YEAR_START_POS = 0;
    private static final int DATE_YEAR_END_POS = 3;
    private static final int DATE_HYPHEN1_POS = 4;
    private static final int DATE_MONTH_START_POS = 5;
    private static final int DATE_MONTH_END_POS = 6;
    private static final int DATE_HYPHEN2_POS = 7;
    private static final int DATE_DAY_START_POS = 8;
    private static final int DATE_DAY_END_POS = 9;
    private static final int NUM_FREE_DAYS = 10;
    private static final int MONTHS_IN_YEAR = 12;
    private static final int DAYS_IN_YEAR = 365;
    private static final int DAYS_IN_MONTH = 31;
    private static final int DAILY_COST = 15;

    // Constants: Menu text
    private static final String MENU =
        "\n----------------------------------"
        + "\n# LTU Library"
        + "\n----------------------------------"
        + "\n1. Add book"
        + "\n2. Remove book"
        + "\n3. Loan a book"
        + "\n4. Return a book"
        + "\n5. Print book list"
        + "\n6. Print lending summary"
        + "\nq. End program";

    // Constants: Menu options
    private static final String MENU_OPTION_INPUT_QUIT = "q";
    private static final int MENU_OPTION_MIN = 1;
    private static final int MENU_OPTION_MAX = 6;
    private static final int MENU_OPTION_QUIT = 0;
    private static final int MENU_OPTION_ADD = 1;
    private static final int MENU_OPTION_REMOVE = 2;
    private static final int MENU_OPTION_LOAN = 3;
    private static final int MENU_OPTION_RETURN = 4;
    private static final int MENU_OPTION_PRINT_BOOK_LIST = 5;
    private static final int MENU_OPTION_PRINT_LOAN_LIST = 6;
    private static final int MENU_OPTION_INVALID = -1;

    // Constants: Prompts
    private static final String PROMPT_ENTER_OPTION = "> Enter your option: ";
    private static final String PROMPT_ENTER_TITLE = "> Enter book title: ";
    private static final String PROMPT_ENTER_ISBN = "> Enter ISBN-10 code: ";
    private static final String PROMPT_ENTER_ID = "> Enter book ID number: ";
    private static final String PROMPT_ENTER_LENDER_NAME =
        "> Enter lender's name ";
    private static final String PROMPT_ENTER_START_DATE =
        "> Enter start date of the loan: ";
    private static final String PROMPT_ENTER_RETURN_DATE =
        "> Enter return date: ";

    // Constants: Confirmations
    private static final String CONFIRMATION_BOOK_ADDED =
        "Book with the title %s was assigned ID %s and added to the system.";
    private static final String CONFIRMATION_LOAN_ADDED =
        "Book %s was loaned by %s on %s";
    private static final String CONFIRMATION_BOOK_REMOVED =
        "Book %s was removed from the system.";
    private static final String CONFIRMATION_BOOK_RETURNED =
        "RECEIPT LTU LIBRARY%n%n"
        + "Lender's name: %s%n"
        + "Book title: %s%n"
        + "ISBN-10: %s%n%n"
        + "Period: %s - %s%n"
        + "Duration: %s days%n%n"
        + "Cost: %s kr";

    // Constants: Error messages
    private static final String ERROR_INVALID_MENU_ITEM = "Invalid menu item";
    private static final String ERROR_INVALID_ISBN = "Invalid ISBN";
    private static final String ERROR_ISBN_EXISTS = "ISBN %s already exists%n";
    private static final String ERROR_INVALID_ID = "Invalid ID";
    private static final String ERROR_INVALID_TITLE = "Invalid title";
    private static final String ERROR_INVALID_DATE = "Invalid date";
    private static final String ERROR_INVALID_LENDER_NAME =
        "Invalid lender name";
    private static final String ERROR_ID_DOES_NOT_EXIST =
        "ID %s does not exist%n";
    private static final String ERROR_ID_NOT_AVAILABLE =
        "Book not available to loan";
    private static final String ERROR_BOOK_LOANED =
        "Book with ID %s is loaned out to %s and needs to be returned before "
        + "removal from the system.%n";

    // Constants: Output
    private static final String HEADING_BOOK_LIST = "\nBook list LTU Library\n";
    private static final String HEADING_LOAN_LIST = "\nLoan summary LTU Library\n";
    private static final String HEADING_ID = "ID";
    private static final String HEADING_ISBN = "ISBN-10";
    private static final String HEADING_TITLE = "Title";
    private static final String HEADING_STATUS = "Status";
    private static final String HEADING_LENDER = "Lender";
    private static final String HEADING_START = "Start date";
    private static final String HEADING_END = "End date";
    private static final String HEADING_COST = "Cost";
    private static final String HEADING_NUM_LOANS = "Number of loans: ";
    private static final String HEADING_TOTAL_REVENUE = "Total revenue: ";
    private static final String FORMAT_ROW_BOOK = "%-8s %-12s %-20s %-10s%n";
    private static final String FORMAT_ROW_LOAN =
        "%-8s %-20s %-15s %-15s %-8s%n";

    public static void main(final String[] args) {

        // Variables
        boolean run = true;
        String[][] books = new String[MAX_BOOK_INVENTORY_SIZE][BOOK_NUM_FIELDS];
        String[][] loans = new String[MAX_LOAN_INVENTORY_SIZE][LOAN_NUM_FIELDS];

        // Present the LTU Library menu until the user decides to quit
        while (run) {
            run = printMenu(books, loans);
        }

        // Close the Scanner
        userInputRetriever.close();
    }

    // =========================================================================
    // ======================== INPUT RETRIEVAL METHODS ========================
    // =========================================================================

    /**
     * Collects user's desired menu option from Scanner object
     * @return int menu option
     */
    private static int fetchMenuOption() {
        int menuOption = 0; // Holds user's menu selection

        // Collect and validate user's input
        if (userInputRetriever.hasNextInt()) {
            menuOption = userInputRetriever.nextInt();
            userInputRetriever.nextLine().trim();
            if (menuOption < MENU_OPTION_MIN || menuOption > MENU_OPTION_MAX) {
                menuOption = MENU_OPTION_INVALID;
            }
        } else {
            if (userInputRetriever.next().toLowerCase().equals(
                MENU_OPTION_INPUT_QUIT)) {
                menuOption = MENU_OPTION_QUIT;
            } else {
                menuOption = MENU_OPTION_INVALID;
            }
        }

        return menuOption; // Return user's menu selection
    }

    /**
     * Routes the user's desired menu option to the appropriate method
     * @param menuOption user's menu option selection
     * @param books array representing all library books
     * @param loans array representing all library loans
     * @return boolean representing whether to keep running program
     */
    private static boolean handleMenuOption(final int menuOption,
        final String[][] books, final String[][] loans) {
        boolean runProgramAgain = true; // Tracks whether to run program again
        switch (menuOption) {

            // Add a new book
            case MENU_OPTION_ADD:
                System.out.println(addBook(books));
                break;

            // Remove an existing book
            case MENU_OPTION_REMOVE:
                System.out.println(removeBook(books, loans));
                break;

            // Loan a book
            case MENU_OPTION_LOAN:
                System.out.println(loanBook(books, loans));
                break;

            // Return a book
            case MENU_OPTION_RETURN:
                System.out.println(returnBook(books, loans));
                break;

            // Print out a list of all books
            case MENU_OPTION_PRINT_BOOK_LIST:
                printBookList(books);
                break;

            // Print out a list of all loans
            case MENU_OPTION_PRINT_LOAN_LIST:
                printLoanList(loans);
                break;

            // Quit the program
            case MENU_OPTION_QUIT:
                System.out.println("End program.");
                runProgramAgain = false;
                break;

            // Handle unexpected input
            default:
                System.out.println(ERROR_INVALID_MENU_ITEM);
                break;
        }
        return runProgramAgain; // Return whether to run program again
    }

    // =========================================================================
    // ========================== DATA ENTRY METHODS ==========================
    // =========================================================================

    /**
     * Add a new book to the library
     * @param books array representing all books in the library
     * @return a String confirmation message
     */
    private static String addBook(final String[][] books) {
        String[] newBook = new String[BOOK_NUM_FIELDS]; // Book to add

        // Set title
        System.out.print(PROMPT_ENTER_TITLE);
        newBook[BOOK_TITLE] = userInputRetriever.nextLine().trim();
        if (!isValidTitle(newBook[BOOK_TITLE])) {
            return ERROR_INVALID_TITLE;
        }

        // Set isbn
        System.out.print(PROMPT_ENTER_ISBN);
        newBook[BOOK_ISBN] = userInputRetriever.nextLine().trim();
        if (!isValidIsbn(newBook[BOOK_ISBN])) {
            return ERROR_INVALID_ISBN;
        }
        if (isbnExists(books, newBook[BOOK_ISBN])) {
            return String.format(ERROR_ISBN_EXISTS, newBook[BOOK_ISBN]);
        }

        // Set id and status
        newBook[BOOK_ID] = "" + nextAvailableId(books);
        newBook[BOOK_STATUS] = STATUS_AVAILABLE;

        // Add book to library
        books[nextAvailableIndex(books)] = newBook;

        // Return confirmation message
        return String.format(CONFIRMATION_BOOK_ADDED, newBook[BOOK_TITLE],
            newBook[BOOK_ID]);
    }

    /**
     * Loan a book from the library
     * @param books array of all books
     * @param loans array of all loans
     * @return a String confirmation message
     */
    private static String loanBook(final String[][] books,
        final String[][] loans) {
        String[] newLoan = new String[LOAN_NUM_FIELDS]; // Loan array
        String[] loanedBook = null; // Book to be loaned

        // Collect and validate book ID
        System.out.print(PROMPT_ENTER_ID);
        newLoan[LOAN_BOOK_ID] = userInputRetriever.nextLine().trim();
        if (!isValidId(newLoan[LOAN_BOOK_ID])) {
            return String.format(ERROR_ID_DOES_NOT_EXIST,
            newLoan[LOAN_BOOK_ID]);
        }
        loanedBook = getBookById(books, newLoan[LOAN_BOOK_ID]);

        // Check if book is available
        if (!isAvailable(books, newLoan[LOAN_BOOK_ID])) {
            return String.format(ERROR_ID_DOES_NOT_EXIST,
                newLoan[LOAN_BOOK_ID]);
        }

        // Collect and validate lender's name
        System.out.print(PROMPT_ENTER_LENDER_NAME);
        newLoan[LOAN_NAME] = userInputRetriever.nextLine().trim();
        if (!isValidName(newLoan[LOAN_NAME])) {
            return ERROR_INVALID_LENDER_NAME;
        }

        // Collect and validate start date
        System.out.print(PROMPT_ENTER_START_DATE);
        newLoan[LOAN_START] = userInputRetriever.nextLine().trim();
        if (!isValidDate(newLoan[LOAN_START])) {
            return ERROR_INVALID_DATE;
        }

        // Set end date
        newLoan[LOAN_END] = "";

        // Add loan
        loans[nextAvailableIndex(loans)] = newLoan;
        loanedBook[BOOK_STATUS] = STATUS_LOANED;

        // Return confirmation message
        return String.format(CONFIRMATION_LOAN_ADDED, loanedBook[BOOK_TITLE],
        newLoan[LOAN_NAME], newLoan[LOAN_START]);
    }

    /**
     * Remove book from the library
     * @param books array of all library books
     * @param loans array of all library loans
     * @return a String confirmation message
     */
    private static String removeBook(final String[][] books,
        final String[][] loans) {

        String idToRemove = ""; // ID of book to remove
        String[] bookToRemove = null; // Book to remove
        String[] loan = null; // Book's loan, if applicable

        // Collect ID
        System.out.print(PROMPT_ENTER_ID);
        idToRemove = userInputRetriever.nextLine();

        // Validate ID format
        if (!isValidId(idToRemove)) {
            return ERROR_INVALID_ID;
        }

        // Set book value
        bookToRemove = getBookById(books, idToRemove);

        // Validate book exists
        if (bookToRemove == null) {
            return String.format(ERROR_ID_DOES_NOT_EXIST, idToRemove);
        }

        // Validate book is not checked out
        if (!isAvailable(books, idToRemove)) {
            loan = getLoanByBookId(loans, idToRemove);
            return String.format(ERROR_BOOK_LOANED, loan[LOAN_BOOK_ID],
            loan[LOAN_NAME]);
        }

        // Mark book as removed
        bookToRemove[BOOK_STATUS] = STATUS_REMOVED;

        // Return confirmation message
        return String.format(CONFIRMATION_BOOK_REMOVED,
        bookToRemove[BOOK_TITLE]);
    }

    /**
     * Return a book to the library
     * @param books array of all books
     * @param loans array of all loans
     * @return a String confirmation message
     */
    private static String returnBook(final String[][] books,
        final String[][] loans) {

        String returnId = ""; // ID of book to return
        String returnDate = ""; // Date of book return
        String[] returnedBook = null; // Returned book
        String[] returnedLoan = null; // Returned book's loan

        // Collect and validate book ID
        System.out.print(PROMPT_ENTER_ID);
        returnId = userInputRetriever.nextLine().trim();
        if (!isValidId(returnId)) {
            return ERROR_INVALID_ID;
        }

        // Fetch and validate return book
        returnedBook = getBookById(books, returnId);
        if (returnedBook == null) {
            return String.format(ERROR_ID_DOES_NOT_EXIST, returnId);
        }

        // Collect and validate return date
        System.out.print(PROMPT_ENTER_RETURN_DATE);
        returnDate = userInputRetriever.nextLine().trim();
        if (!isValidDate(returnDate)) {
            return ERROR_INVALID_DATE;
        }

        // Fetch loan
        returnedLoan = getLoanByBookId(loans, returnId);
        if (returnDate.compareTo(returnedLoan[LOAN_START]) < 0) {
            return ERROR_INVALID_DATE;
        }

        // Update loan and book statuses
        returnedLoan[LOAN_END] = returnDate;
        returnedBook[BOOK_STATUS] = STATUS_AVAILABLE;

        // Return confirmation message
        return String.format(CONFIRMATION_BOOK_RETURNED,
            returnedLoan[LOAN_NAME], returnedBook[BOOK_TITLE],
            returnedBook[BOOK_ISBN], returnedLoan[LOAN_START],
            returnedLoan[LOAN_END], calculateDuration(returnedLoan),
            calculateCost(returnedLoan)
        );
    }

    // =========================================================================
    // ========================== VALIDATION METHODS ==========================
    // =========================================================================

    /**
     * Check if lender name is valid
     * @param name String name to check
     * @return boolean true if valid name, false if invalid name
     */
    private static boolean isValidName(final String name) {
        return name.length() > 0;
    }

    /**
     * Check if date is valid
     * @param date String date to validate
     * @return boolean true if date is valid, false if invalid
     */
    private static boolean isValidDate(final String date) {
        // Check length
        if (date.length() != DATE_LENGTH) {
            return false;
        }

        // Check hyphen positions
        if (date.charAt(DATE_HYPHEN1_POS) != '-'
            || date.charAt(DATE_HYPHEN2_POS) != '-') {
            return false;
        }

        // Validate year
        for (int i = DATE_YEAR_START_POS; i <= DATE_YEAR_END_POS; i++) {
            if (date.charAt(i) < '0' || date.charAt(i) > '9') {
                return false;
            }
        }

        // Validate month
        for (int i = DATE_MONTH_START_POS; i <= DATE_MONTH_END_POS; i++) {
            if (date.charAt(i) < '0' || date.charAt(i) > '9') {
                return false;
            }
            if (getMonth(date) < 1 || getMonth(date) > MONTHS_IN_YEAR) {
                return false;
            }
        }

        // Validate day
        for (int i = DATE_DAY_START_POS; i <= DATE_DAY_START_POS; i++) {
            if (date.charAt(i) < '0' || date.charAt(i) > '9') {
                return false;
            }
            if (getDay(date) < 1 || getDay(date) > DAYS_IN_MONTH) {
                return false;
            }
        }

        // If no tests have failed, return true
        return true;
    }

    /**
     * Validate book id
     * @param id book id to validate
     * @return boolean true if id is valid, false if invalid
     */
    private static boolean isValidId(final String id) {
        // Check that the total length is correct
        if (id.length() != ID_LENGTH) {
            return false;
        }

        // Check that the id only contains digits
        for (int i = 0; i < id.length(); i++) {
            if (id.charAt(i) < '0' || id.charAt(i) > '9') {
                return false;
            }
        }

        // If no tests have failed, return true
        return true;
    }

    /**
     * Validate book title
     * @param title String title to validate
     * @return true if title format is valid, false if format is invalid
     */
    private static boolean isValidTitle(final String title) {
        return title.length() > 0;
    }

    /**
     * Validate book ISBN
     * @param isbn String ISBN number to validate
     * @return true if ISBN is in valid format, false if format is invalid
     */
    private static boolean isValidIsbn(final String isbn) {
        // Check that the total length is correct
        if (isbn.length() != ISBN_LENGTH_TOTAL) {
            return false;
        }

        // Check that the first 9 letters are digits
        for (int i = 0; i < ISBN_LENGTH_PART_1; i++) {
            char charToCheck = isbn.charAt(i);
            if (charToCheck < '0' || charToCheck > '9') {
                return false;
            }
        }

        // Check that the 10th letter is a hyphen
        if (isbn.charAt(ISBN_POSITION_HYPHEN) != '-') {
            return false;
        }

        // Check that the 11th letter is a digit
        if (isbn.charAt(ISBN_POSITION_LAST_DIGIT) < '0'
            || isbn.charAt(ISBN_POSITION_LAST_DIGIT) > '9') {
            return false;
        }

        // If no previous tests have failed, return true
        return true;
    }

    /**
     * Check if a book is available
     * @param books array of all books
     * @param bookId book id to check
     * @return true if book is available, otherwise false
     */
    private static boolean isAvailable(final String[][] books,
        final String bookId) {
        String[] book = getBookById(books, bookId); // Get book
        return book[BOOK_STATUS].equals(STATUS_AVAILABLE); // Check book status
    }

    /**
     * Check if ISBN number already exists
     * @param books array of all books
     * @param isbn String ISBN number to check
     * @return true if ISBN exists already, false if it is new
     */
    private static boolean isbnExists(final String[][] books,
        final String isbn) {
        for (int i = 0; i < books.length; i++) { // For all books
            if (books[i][BOOK_ID] != null) { // If book is not null
                if (books[i][BOOK_ISBN].equals(isbn)) { // If ISBNs match
                    return true; // Return true
                }
            }
        }
        return false; // If no match found, return false
    }

    // =========================================================================
    // ========================== DATA LOOKUP METHODS ==========================
    // =========================================================================

    /**
     * Check for next available id in books array
     * @param books array of all books
     * @return id of next available id
     */
    private static int nextAvailableId(final String[][] books) {
        int maxId = MIN_BOOK_ID; // Set starting ID
        for (String[] book : books) { // For all books
            if (book[BOOK_ID] != null) { // If book is not null
                if (Integer.parseInt(book[BOOK_ID]) > maxId) { // If ID > max
                    maxId = Integer.parseInt(book[BOOK_ID]); // Set new max
                }
            }
        }
        return maxId + 1; // Return next open slot (max current index + 1)
    }

    /**
     * Check for next available index in a 2D array
     * @param twoDimensionalArray array to check
     * @return int index of next available empty slot, or -1 if none found
     */
    private static int nextAvailableIndex(
        final String[][] twoDimensionalArray) {
        for (int i = 0; i < twoDimensionalArray.length; i++) { // All elements
            if (twoDimensionalArray[i][0] == null) { // If element is null
                return i; // Then it is empty, so return it
            }
        }
        return -1; // If no empty rows found, return -1
    }

    /**
     * Get book by book ID
     * @param books array of all books
     * @param bookId book ID to look up
     * @return array representing the found book, or null if none found
     */
    private static String[] getBookById(final String[][] books,
        final String bookId) {
        for (int i = 0; i < books.length; i++) {
            // If book is not null and status is not removed
            if (books[i][BOOK_ID] != null
                && !books[i][BOOK_STATUS].equals(STATUS_REMOVED)) {
                // If book id matches
                if (books[i][BOOK_ID].equals(bookId)) {
                    return books[i]; // Return the book
                }
            }
        }
        return null; // Return null if nothing found
    }

    /**
     * Get loan by book id
     * @param loans array of all loans
     * @param bookId book id to look up
     * @return an array representing the loan, or null if no match found
     */
    private static String[] getLoanByBookId(final String[][] loans,
        final String bookId) {
        for (int i = 0; i < loans.length; i++) { // For all loans
            if (loans[i][LOAN_BOOK_ID] != null) { // If loan is not null
                if (loans[i][LOAN_BOOK_ID].equals(bookId)) { // And ids match
                    return loans[i]; // Return the loan
                }
            }
        }
        return null; // If no match found, return null
    }

    // =========================================================================
    // ========================== CALCULATION METHODS ==========================
    // =========================================================================

    /**
     * Extracts year from a date String
     * @param dateAsString date String to parse
     * @return int year
     */
    private static int getYear(final String dateAsString) {
        return Integer.parseInt(dateAsString.substring(DATE_YEAR_START_POS,
        DATE_YEAR_END_POS + 1));
    }

    /**
     * Extracts month from a date String
     * @param dateAsString date String to parse
     * @return int month
     */
    private static int getMonth(final String dateAsString) {
        return Integer.parseInt(dateAsString.substring(DATE_MONTH_START_POS,
        DATE_MONTH_END_POS + 1));
    }

    /**
     * Extracts day from a date String
     * @param dateAsString date String to parse
     * @return int day
     */
    private static int getDay(final String dateAsString) {
        return Integer.parseInt(dateAsString.substring(DATE_DAY_START_POS,
        DATE_DAY_END_POS + 1));
    }

    /**
     * Calculates duration of a loan
     * @param loan array loan to analyze
     * @return int representing the loan's age in days
     */
    private static int calculateDuration(final String[] loan) {
        int duration = 0; // Holds loan's age in days

        // Convert each date to a day value and calculate the difference
        duration = DAYS_IN_YEAR
            * (getYear(loan[LOAN_END]) - getYear(loan[LOAN_START]))
            + DAYS_IN_MONTH
            * (getMonth(loan[LOAN_END]) - getMonth(loan[LOAN_START]))
            + (getDay(loan[LOAN_END]) - getDay(loan[LOAN_START]));

        return duration; // Return the difference in days
    }

    /**
     * Calculates the cost of a book loan
     * @param loan the book loan to analyze
     * @return an int representing the loan's cost
     */
    private static int calculateCost(final String[] loan) {
        // If loan hasn't ended yet, return 0
        if (loan[LOAN_END].equals("")) {
            return 0;
        }

        if (calculateDuration(loan) <= NUM_FREE_DAYS) {
            return 0; // If duration < free days, return 0
        } else {
            // Otherwise 15 SEK/day * number of days beyond the num of free days
            return DAILY_COST * (calculateDuration(loan) - NUM_FREE_DAYS);
        }
    }

    // =========================================================================
    // =========================== PRINTING METHODS ===========================
    // =========================================================================

    /**
     * Print the main menu
     * @param books array of all library books
     * @param loans array of all library loans
     * @return boolean indicating whether user wants to run menu again
     */
    private static boolean printMenu(final String[][] books,
        final String[][] loans) {
        System.out.println(MENU);
        System.out.print(PROMPT_ENTER_OPTION);
        return handleMenuOption(fetchMenuOption(), books, loans);
    }

    /**
     * Print a list of all books
     * @param books array of all library books
     */
    private static void printBookList(final String[][] books) {
        // Print table headers
        System.out.println(HEADING_BOOK_LIST);
        System.out.printf(FORMAT_ROW_BOOK, HEADING_ID, HEADING_ISBN,
            HEADING_TITLE, HEADING_STATUS);

        // Print all books
        for (int i = 0; i < books.length; i++) {
            if (books[i][BOOK_ID] != null
                && !books[i][BOOK_STATUS].equals(STATUS_REMOVED)) {
                printBook(books[i]);
            }
        }
    }

    /**
     * Prints a single book to the console
     * @param book the book to print
     */
    private static void printBook(final String[] book) {
        System.out.printf(FORMAT_ROW_BOOK, book[BOOK_ID], book[BOOK_ISBN],
            book[BOOK_TITLE], book[BOOK_STATUS]);
    }

    /**
     * Prints a list of all loans
     * @param loans array of all library loans
     */
    private static void printLoanList(final String[][] loans) {
        int numLoans = 0; // Holds number of loaned books
        int totalRevenue = 0; // Holds total book loan revenue

        // Print table headers
        System.out.println(HEADING_LOAN_LIST);
        System.out.printf(FORMAT_ROW_LOAN, HEADING_ID, HEADING_LENDER,
            HEADING_START, HEADING_END, HEADING_COST);

        // Print all loans
        for (int i = 0; i < loans.length; i++) {
            if (loans[i][LOAN_BOOK_ID] != null) {
                printLoan(loans[i]);
                numLoans++;
                if (loans[i][LOAN_END].length() > 0) {
                    totalRevenue += calculateCost(loans[i]);
                }
            }
        }

        // Print table footer
        System.out.printf("%n%s: %s%n", HEADING_NUM_LOANS, numLoans);
        System.out.printf("%s: %s kr%n", HEADING_TOTAL_REVENUE,
            totalRevenue);
    }

    /**
     * Print a single loan to the console
     * @param loan the loan to print
     */
    private static void printLoan(final String[] loan) {
        System.out.printf(FORMAT_ROW_LOAN, loan[LOAN_BOOK_ID], loan[LOAN_NAME],
            loan[LOAN_START], loan[LOAN_END], calculateCost(loan) + " kr");
    }

}
