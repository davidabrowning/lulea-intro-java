package Exam; 

// Imports
import java.util.Scanner;
 
 /**
  * No need for Pseducode, just a simple summary is fine, couple of lines
  * 
  * 
 * @author David Browning (davbro-4)
 * @version 1.0
 **/

 public class Main {

    // Scanner
    private static final Scanner userInputRetriever = new Scanner(System.in);

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

    // Constants: Menu text
    private static final String MENU =
        "----------------------------------"
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
    private static final String PROMPT_ENTER_LENDER_NAME = "> Enter lender's name ";
    private static final String PROMPT_ENTER_START_DATE = "> Enter start date of the loan: ";
    private static final String PROMPT_ENTER_RETURN_DATE = "> Enter return date: ";

    // Constants: Confirmations
    private static final String CONFIRMATION_BOOK_ADDED = "Book with the title %s was assigned ID %s and added to the system.%n";
    private static final String CONFIRMATION_LOAN_ADDED = "Book %s was loaned by %s on %s%n";

    // Constants: Error messages
    private static final String ERROR_INVALID_MENU_ITEM = "Invalid menu item";
    private static final String ERROR_INVALID_ISBN = "Invalid ISBN";
    private static final String ERROR_ISBN_EXISTS = "ISBN %s already exists%n";
    private static final String ERROR_INVALID_ID = "Invalid ID";
    private static final String ERROR_INVALID_TITLE = "Invalid title";
    private static final String ERROR_INVALID_DATE = "Invalid date";
    private static final String ERROR_INVALID_LENDER_NAME = "Invalid lender name";
    private static final String ERROR_ID_DOES_NOT_EXIST = "ID %s does not exist%n";
    private static final String ERROR_ID_NOT_AVAILABLE = "Book not available to loan";

    // Constants: Output
    private static final String HEADING_BOOK_LIST = "Book list LTU Library";
    private static final String HEADING_LOAN_LIST = "Loan summary LTU Library";
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
    private static final String FORMAT_ROW_LOAN = "%-8s %-20s %-15s %-15s %-8s%n";

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

    private static boolean printMenu(String[][] books, String[][] loans) {
        System.out.println(MENU);
        System.out.print(PROMPT_ENTER_OPTION);
        return handleMenuOption(fetchMenuOption(), books, loans);
    }

    private static int fetchMenuOption() {
        int menuOption = 0;

        if (userInputRetriever.hasNextInt()) {
            menuOption = userInputRetriever.nextInt();
            userInputRetriever.nextLine().trim();
            if (menuOption < MENU_OPTION_MIN || menuOption > MENU_OPTION_MAX) {
                menuOption = MENU_OPTION_INVALID;
            }
        } else {
            if (userInputRetriever.next().toLowerCase().equals(MENU_OPTION_INPUT_QUIT)) {
                menuOption = MENU_OPTION_QUIT;
            } else {
                menuOption = MENU_OPTION_INVALID;
            }
        }

        return menuOption;
    }

    private static boolean handleMenuOption(int menuOption, String[][] books, String[][] loans) {
        boolean runProgramAgain = true;
        switch (menuOption) {
            case MENU_OPTION_ADD:
                System.out.println(addBook(books));
                break;
            case MENU_OPTION_REMOVE:
                System.out.println(removeBook(books, loans));
                break;
            case MENU_OPTION_LOAN:
                System.out.println(loanBook(books, loans));
                break;
            case MENU_OPTION_RETURN:
                System.out.println(returnBook(books, loans));
                break;
            case MENU_OPTION_PRINT_BOOK_LIST:
                printBookList(books);
                break;
            case MENU_OPTION_PRINT_LOAN_LIST:
                printLoanList(loans);
                break;
            case MENU_OPTION_QUIT:
                System.out.println("End program.");
                runProgramAgain = false;
                break;
            default:
                System.out.println(ERROR_INVALID_MENU_ITEM);
                break;    
        }
        return runProgramAgain;
    }

    private static String addBook(String[][] books) {
        String[] newBook = new String[BOOK_NUM_FIELDS];

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
            return ERROR_ISBN_EXISTS;
        }

        // Set id
        newBook[BOOK_ID] = "" + nextAvailableId(books);

        // Set status
        newBook[BOOK_STATUS] = STATUS_AVAILABLE;

        // Add book
        books[nextAvailableIndex(books)] = newBook;

        return String.format(CONFIRMATION_BOOK_ADDED, newBook[BOOK_TITLE], newBook[BOOK_ID]);
    }

    private static boolean isValidId(String id) {
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

        return true;
    }

    private static boolean isValidTitle(String title) {
        return title.length() > 0;
    }

    private static boolean isValidIsbn(String isbn) {
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
        if (isbn.charAt(ISBN_POSITION_LAST_DIGIT) < '0' || isbn.charAt(ISBN_POSITION_LAST_DIGIT) > '9') {
            return false;
        }

        return true;
    }

    private static boolean isbnExists(String[][] books, String isbn) {
        for (int i = 0; i < books.length; i++) {
            if (books[i][BOOK_ID] == null) {
                continue;
            }
            if (books[i][BOOK_ISBN].equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    private static int nextAvailableId(String[][] books) {
        int maxId = MIN_BOOK_ID;
        for (String[] book : books) {
            if (book[BOOK_ID] == null) {
                continue;
            }
            if (Integer.parseInt(book[BOOK_ID]) > maxId) {
                maxId = Integer.parseInt(book[BOOK_ID]);
            }
        }
        return maxId + 1;
    }

    private static int nextAvailableIndex(String[][] twoDimensionalArray) {
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            if (twoDimensionalArray[i][0] == null) {
                return i;
            }
        }
        return -1;
    }

    private static void printBookList(String[][] books) {
        System.out.printf(FORMAT_ROW_BOOK, HEADING_ID, HEADING_ISBN, HEADING_TITLE, HEADING_STATUS);
        for (int i = 0; i < books.length; i++) {
            if (books[i][BOOK_ID] != null) {
                printBook(books[i]);
            }
        }
    }

    private static void printBook(String[] book) {
        System.out.printf(FORMAT_ROW_BOOK, book[BOOK_ID], book[BOOK_ISBN], book[BOOK_TITLE], book[BOOK_STATUS]);
    }

    private static void printLoanList(String[][] loans) {
        System.out.printf(FORMAT_ROW_LOAN, HEADING_ID, HEADING_LENDER, HEADING_START, HEADING_END, HEADING_COST);
        for (int i = 0; i < loans.length; i++) {
            if (loans[i][LOAN_BOOK_ID] != null) {
                printLoan(loans[i]);
            }
        }
    }

    private static void printLoan(String[] loan) {
        System.out.printf(FORMAT_ROW_LOAN, loan[LOAN_BOOK_ID], loan[LOAN_NAME], loan[LOAN_START], loan[LOAN_END], calculateCost(loan));
    }

    private static String loanBook(String[][] books, String[][] loans) {
        String[] newLoan = new String[LOAN_NUM_FIELDS];
        String[] loanedBook = null;

        // Collect and validate book ID
        System.out.print(PROMPT_ENTER_ID);
        newLoan[LOAN_BOOK_ID] = userInputRetriever.nextLine().trim();
        if (!isValidId(newLoan[LOAN_BOOK_ID])) {
            return ERROR_INVALID_ID;
        }
        loanedBook = getBookById(books, newLoan[LOAN_BOOK_ID]);

        // Check if book is available
        if (!isAvailable(books, loanedBook[BOOK_ID])) {
            return ERROR_ID_NOT_AVAILABLE;
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

        // Return confirmation message
        return String.format(CONFIRMATION_LOAN_ADDED, loanedBook[BOOK_TITLE], newLoan[LOAN_NAME], newLoan[LOAN_START]);
    }

    private static String[] getBookById(String[][] books, String bookId) {
        for (int i = 0; i < books.length; i++) {
            if (books[i][BOOK_ID] == null) {
                continue;
            }
            if (books[i][BOOK_ID].equals(bookId)) {
                return books[i];
            }
        }
        return null;        
    }

    private static boolean isAvailable(String[][] books, String bookId) {
        String[] book = getBookById(books, bookId);
        return book[BOOK_STATUS].equals(STATUS_AVAILABLE);
    }

    private static boolean isValidName(String name) {
        return name.length() > 0;
    }

    private static boolean isValidDate(String date) {
        // Check length
        if (date.length() != DATE_LENGTH);

        // Check hyphen positions
        if (date.charAt(DATE_HYPHEN1_POS) != '-' || date.charAt(DATE_HYPHEN2_POS) != '-') {
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
            if (getMonth(date) < 1 || getMonth(date) > 12) {
                return false;
            }
        }

        // Validate day
        for (int i = DATE_DAY_START_POS; i <= DATE_DAY_START_POS; i++) {
            if (date.charAt(i) < '0' || date.charAt(i) > '9') {
                return false;
            }
            if (getDay(date) < 1 || getDay(date) > 31) {
                return false;
            }
        }

        return true;
    }

    private static int getYear(String dateAsString) {
        return Integer.parseInt(dateAsString.substring(DATE_YEAR_START_POS, DATE_YEAR_END_POS + 1));
    }

    private static int getMonth(String dateAsString) {
        return Integer.parseInt(dateAsString.substring(DATE_MONTH_START_POS, DATE_MONTH_END_POS + 1));
    }

    private static int getDay(String dateAsString) {
        return Integer.parseInt(dateAsString.substring(DATE_DAY_START_POS, DATE_DAY_END_POS + 1));
    }

    private static int calculateCost(String[] loan) {
        if (loan[LOAN_END].equals("")) {
            return 0;
        }

        int daysElapsed = 0;

        daysElapsed = 365 * (getYear(loan[LOAN_END]) - getYear(loan[LOAN_START]))
            + 31 * (getMonth(loan[LOAN_END]) - getMonth(loan[LOAN_START]))
            + (getDay(loan[LOAN_END]) - getDay(loan[LOAN_START]));

        if (daysElapsed <= NUM_FREE_DAYS) {
            return 0;
        } else {
            return 15 * (daysElapsed - NUM_FREE_DAYS);
        }
    }

    private static String removeBook(String[][] books, String[][] loans) {
        return "Book removed!";
    }

    private static String returnBook(String[][] books, String[][] loans) {
        return "Book returned!";
    }
}
