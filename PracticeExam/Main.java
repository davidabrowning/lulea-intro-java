package PracticeExam;

// Imports
import java.util.Scanner;

/**
 * PROGRAM DESCRIPTION
 * Menu simulating flight management system for a local airport called LTU
 * Airport. Handles the scheduling and management of flight departures and
 * arrivals.
 *
 * @author David Browning (davbro-4)
 * @version 1.0
 */
public class Main {

    // Constants: Scanner object
    private static Scanner userInputRetriever = new Scanner(System.in);

    // Constants: Data values
    private static final int FLIGHT_NUMBER_LENGTH = 5;
    private static final int FLIGHT_TIME_LENGTH = 5;
    private static final String FLIGHT_TIME_HH_MIN = "00";
    private static final String FLIGHT_TIME_HH_MAX = "23";
    private static final String FLIGHT_TIME_HHMM_SEPARATOR = ":";
    private static final String FLIGHT_TIME_MM_MIN = "00";
    private static final String FLIGHT_TIME_MM_MAX = "59";
    private static final int MAX_FLIGHTS_PER_DAY = 100;
    private static final int TEXT_FIELDS_PER_FLIGHT = 5;
    private static final int FIELD_FLIGHT_TYPE = 0;
    private static final int FIELD_FLIGHT_NUMBER = 1;
    private static final int FIELD_FLIGHT_AIRPORT = 2;
    private static final int FIELD_FLIGHT_SCHEDULED = 3;
    private static final int FIELD_FLIGHT_ACTUAL = 4;
    private static final String FLIGHT_TYPE_ARRIVAL = "arrival";
    private static final String FLIGHT_TYPE_DEPARTURE = "departure";

    // Constants: Menu text
    private static final String MENU_MAIN =
        "\n\n-----------------------------------"
        + "\n# LTU Airport AD Management System"
        + "\n-----------------------------------"
        + "\n1. Register the scheduled arrival"
        + "\n2. Register the scheduled departure"
        + "\n3. Register the actual arrival of a flight"
        + "\n4. Register the actual departure of a flight"
        + "\n5. Print operations summary"
        + "\nq. End program"
        + "\n> Enter your option: ";
    private static final String PROMPT_ENTER_FLIGHT_NUM = "> Enter flight number: ";
    private static final String PROMPT_ENTER_AIRPORT = "> Enter airport: ";
    private static final String PROMPT_ENTER_SCHEDULED_TIME = "> Enter scheduled time: ";
    private static final String PROMPT_ENTER_ACTUAL_TIME = "> Enter actual time: ";
    private static final String CONFIRMATION_FLIGHT_SCHEDULED = "%nThe %s of flight %s from/to %s is scheduled for %s.";
    private static final String MENU_FLIGHT_INFO = "%-8s %-15s %-8s %-8s%n";
    private static final String MENU_HEADING_OPERATIONS = "\nLTU Airport operations summary:";
    private static final String MENU_HEADING_ARRIVALS = "\nArrivals:";
    private static final String MENU_HEADING_DEPARTURES = "\nDepartures:";
    private static final String MENU_HEADING_FLIGHT = "Flight";
    private static final String MENU_HEADING_FROM = "From";
    private static final String MENU_HEADING_TO = "To";
    private static final String MENU_HEADING_STA = "STA";
    private static final String MENU_HEADING_ATA = "ATA";
    private static final String MENU_HEADING_STD = "STD";
    private static final String MENU_HEADING_ATD = "ATD";
    private static final String MENU_HEADING_NUM_FLIGHTS = "%nTotal number of flights: %d";
    private static final String MENU_HEADING_NUM_DELAYS = "%nTotal number of delayed flights: %d";
    private static final String MESSAGE_END_PROGRAM = "Closing and exiting program.";

    // Constants: Menu options
    private static final String OPTION_QUIT = "q";

    // Constants: Menu selections
    private static final int SELECTION_REGISTER_SCHEDULED_ARRIVAL = 1;
    private static final int SELECTION_REGISTER_SCHEDULED_DEPARTURE = 2;
    private static final int SELECTION_REGISTER_ACTUAL_ARRIVAL = 3;
    private static final int SELECTION_REGISTER_ACTUAL_DEPARTURE = 4;
    private static final int SELECTION_PRINT_OPERATIONS = 5;
    private static final int SELECTION_END_PROGRAM = 0;
    private static final int SELECTION_INVALID = -1;
    private static final int SELECTION_MIN_VALUE = 0;
    private static final int SELECTION_MAX_VALUE = 5;

    // Constants: Warnings
    private static final String WARNING_UNEXPECTED_INPUT = "Warning: Unexpected input.";
    private static final String WARNING_INVALID_TIME_FORMAT = "Invalid time format.";
    private static final String WARNING_INVALID_FLIGHT_NUMBER_FORMAT = "Invalid flight number format.";
    private static final String WARNING_FLIGHT_ALREADY_EXISTS = "Flight number already exists.";
    private static final String WARNING_FLIGHT_DOES_NOT_EXIST = "Flight number does not exist.";

    /**
     * Main method. Entry point for the program. Accepts a String[] args which
     * is not used. Shows a menu for user to interact with flight arrivals
     * and departures.
     * @param args
     */
    public static void main(final String[] args) {

        String[][] flights = new String[MAX_FLIGHTS_PER_DAY][TEXT_FIELDS_PER_FLIGHT];
        boolean run = true; // If program should keep running
        int userMenuChoice = 0; // For use in menu switch statement
        userInputRetriever.useDelimiter("\\n"); // Configure Scanner

        while (run) {
            printMainMenu();
            userMenuChoice = getMainMenuSelection();

            // Handle user's menu input by routing to appropriate function
            switch (userMenuChoice) {
                case SELECTION_REGISTER_SCHEDULED_ARRIVAL:
                    registerScheduledFlight(flights, FLIGHT_TYPE_ARRIVAL);
                    break;
                case SELECTION_REGISTER_SCHEDULED_DEPARTURE:
                    registerScheduledFlight(flights, FLIGHT_TYPE_DEPARTURE);
                    break;
                case SELECTION_REGISTER_ACTUAL_ARRIVAL:
                    registerActualFlight(flights, FLIGHT_TYPE_ARRIVAL);
                    break;
                case SELECTION_REGISTER_ACTUAL_DEPARTURE:
                    registerActualFlight(flights, FLIGHT_TYPE_DEPARTURE);
                    break;
                case SELECTION_PRINT_OPERATIONS:
                    printOperations(flights);
                    break;
                case SELECTION_END_PROGRAM:
                    System.out.println(MESSAGE_END_PROGRAM);
                    run = false;
                    break;
                default:
                    System.out.println(WARNING_UNEXPECTED_INPUT);
                    break;
            }

        }

        // Close the Scanner object
        userInputRetriever.close();
    }

    /**
     * Prints the airport's main menu. Returns void.
     */
    public static void printMainMenu() {
        System.out.print(MENU_MAIN);
    }

    /**
     * Collecs and validates user's menu selection.
     * @return the user's menu selection as an int
     */
    public static int getMainMenuSelection() {
        String userInput = "";
        int userSelection = -1;

        // Collect menu selection from user: If non-integer, check if user
        // intends to quit program.
        if (userInputRetriever.hasNextInt()) {
            userSelection = userInputRetriever.nextInt();
        } else {
            userInput = userInputRetriever.next();
            if (userInput.toLowerCase().equals(OPTION_QUIT)) {
                userSelection = SELECTION_END_PROGRAM;
            }
        }

        // Validate user's menu selection: Must not be outside range of possible
        // menu selections.
        if (userSelection < SELECTION_MIN_VALUE
            || userSelection > SELECTION_MAX_VALUE) {
            userSelection = SELECTION_INVALID;
        }

        // Return user's menu selection
        return userSelection;
    }

    /**
     * Registers a new flight
     * @param flights array of existing flights
     * @param flightType String representing new flight's type (arrival or
     * departure)
     */
    public static void registerScheduledFlight(final String[][] flights, final String flightType) {
        String[] flight = new String[TEXT_FIELDS_PER_FLIGHT]; // New flight
        flight[FIELD_FLIGHT_TYPE] = flightType; // Arrival or departure
        flight[FIELD_FLIGHT_ACTUAL] = ""; // Will hold actual arrival time

        // Collect and validate flight number
        System.out.print(PROMPT_ENTER_FLIGHT_NUM);
        flight[FIELD_FLIGHT_NUMBER] = userInputRetriever.next();
        if (isValidFlightNumber(flight[FIELD_FLIGHT_NUMBER], flights) == false) {
            return;
        }

        // Collect airport name
        System.out.print(PROMPT_ENTER_AIRPORT);
        flight[FIELD_FLIGHT_AIRPORT] = userInputRetriever.next();

        // Collect and validate scheduled time
        System.out.print(PROMPT_ENTER_SCHEDULED_TIME);
        flight[FIELD_FLIGHT_SCHEDULED] = userInputRetriever.next();
        if (isValidFlightTime(flight[FIELD_FLIGHT_SCHEDULED]) == false) {
            return;
        }

        // Log flight
        logFlight(flight, flights);

        // Print confirmation for user
        System.out.printf(
            CONFIRMATION_FLIGHT_SCHEDULED,
            flightType,
            flight[FIELD_FLIGHT_NUMBER],
            flight[FIELD_FLIGHT_AIRPORT],
            flight[FIELD_FLIGHT_SCHEDULED]
        );
    }

    /**
     * Checks if a flight number is valid
     * @param flightNum flight number to check
     * @param flights array of existing flights
     * @return true if number is valid, false otherwise
     */
    public static boolean isValidFlightNumber(final String flightNum, final String[][] flights) {

        // Validate that flight number is exactly five characters long
        if (flightNum.length() != FLIGHT_NUMBER_LENGTH) {
            System.out.println(WARNING_INVALID_FLIGHT_NUMBER_FORMAT);
            return false;
        }

        // Validate the flight number starts with two capital letters and ends
        // with three numeric digits
        String flightNumLetters = flightNum.substring(0, 2);
        String flightNumDigits = flightNum.substring(2, 5);
        if (flightNumLetters.compareTo("AA") < 0
            || flightNumLetters.compareTo("ZZ") > 0
            || flightNumDigits.compareTo("000" ) < 0
            || flightNumDigits.compareTo("999") > 0) {
            System.out.println(WARNING_INVALID_FLIGHT_NUMBER_FORMAT);
            return false;
        }

        // Validate that flight does not already exist
        for (String[] existingFlight : flights) {
            if (existingFlight[FIELD_FLIGHT_NUMBER] == null) {
                continue;
            }
            if (existingFlight[FIELD_FLIGHT_NUMBER].equals(flightNum)) {
                System.out.println(WARNING_FLIGHT_ALREADY_EXISTS);
                return false;
            }
        }

        // If no tests have failed, return true
        return true;
    }

    /**
     * Checks if a flight time is valid
     * @param flightTime the String flight time
     * @return true if flight time is valid, false otherwise
     */
    public static boolean isValidFlightTime(final String flightTime) {

        // Validate that time length is correct
        if (flightTime.length() != FLIGHT_TIME_LENGTH) {
            System.out.println(WARNING_INVALID_TIME_FORMAT);
            return false;
        }

        // Validate that the time is in the range 00:00 - 23:59
        String arrivalTimeHH = flightTime.substring(0, 2);
        String arrivalTimeHHMMSeparator = flightTime.substring(2, 3);
        String arrivalTimeMM = flightTime.substring(3, 5);
        if (arrivalTimeHH.compareTo(FLIGHT_TIME_HH_MIN) < 0
            || arrivalTimeHH.compareTo(FLIGHT_TIME_HH_MAX) > 0
            || arrivalTimeHHMMSeparator.equals(FLIGHT_TIME_HHMM_SEPARATOR) == false
            || arrivalTimeMM.compareTo(FLIGHT_TIME_MM_MIN) < 0
            || arrivalTimeMM.compareTo(FLIGHT_TIME_MM_MAX) > 0) {
            System.out.println(WARNING_INVALID_TIME_FORMAT);
            return false;
        }

        // If no tests have failed, return true
        return true;
    }

    /**
     * Adds a flight to the "database"
     * @param flight flight to add
     * @param flights array of all current existing flights
     */
    public static void logFlight(final String[] flight, final String[][] flights) {
        int nextFlightIndex = getFirstEmptyIndex(flights);
        flights[nextFlightIndex] = flight;
    }

    /**
     * Checks for the first empty row in a 2D array
     * @param twoDArray array to check
     * @return int representing first empty row
     */
    public static int getFirstEmptyIndex(final String[][] twoDArray) {
        for (int i = 0; i < twoDArray.length; i++) {
            if (twoDArray[i][0] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Registers a flight's actual arrival or departure time
     * @param flights array of existing flights
     * @param flightType the type of the new flight to be registers (arrival or departure)
     */
    private static void registerActualFlight(final String[][] flights, final String flightType) {
        String flightNum = "";
        String actualFlightTime = "";
        boolean flightExists = false;

        // Collect and validate flight number
        System.out.print(PROMPT_ENTER_FLIGHT_NUM);
        flightNum = userInputRetriever.next();
        for (String[] flight : flights) {
            if (flight[FIELD_FLIGHT_NUMBER] == null) {
                continue;
            }
            if (flight[FIELD_FLIGHT_NUMBER].equals(flightNum) && flight[FIELD_FLIGHT_TYPE].equals(flightType)) {
                flightExists = true;
            }
        }
        if (flightExists == false) {
            System.out.println(WARNING_FLIGHT_DOES_NOT_EXIST);
            return;
        }

        // Collect and validate actual flight time
        System.out.print(PROMPT_ENTER_ACTUAL_TIME);
        actualFlightTime = userInputRetriever.next();
        if (isValidFlightTime(actualFlightTime) == false) {
            return;
        }

        logActualTime(flightNum, actualFlightTime, flights);

    }

    /**
     * Logs the actual flight time of a flight
     * @param flightNum actual flight number
     * @param actualFlightTime the actual flight arrival/departure time
     * @param flights an array of existing flights
     */
    private static void logActualTime(final String flightNum, final String actualFlightTime, final String[][] flights) {
        for (String[] flight : flights) {
            if (flight[FIELD_FLIGHT_NUMBER] == null) {
                continue;
            }
            if (flight[FIELD_FLIGHT_NUMBER].equals(flightNum)) {
                flight[FIELD_FLIGHT_ACTUAL] = actualFlightTime;
            }
        }
    }

    /**
     * Prints a summary of all flights
     * @param flights array of existing flights
     */
    private static void printOperations(final String[][] flights) {
        System.out.println(MENU_HEADING_OPERATIONS);
        printArrivals(flights);
        printDepartures(flights);
        printNumFlights(flights);
        printNumDelays(flights);
    }

    /**
     * Prints list of arrivals
     * @param flights array of existing flights
     */
    private static void printArrivals(final String[][] flights) {
        System.out.println(MENU_HEADING_ARRIVALS);
        System.out.printf(
            MENU_FLIGHT_INFO,
            MENU_HEADING_FLIGHT,
            MENU_HEADING_FROM,
            MENU_HEADING_STA,
            MENU_HEADING_ATA
        );
        for (String[] flight : flights) {
            if (flight[FIELD_FLIGHT_NUMBER] != null
                && flight[FIELD_FLIGHT_TYPE].equals(FLIGHT_TYPE_ARRIVAL)) {
                System.out.printf(
                    MENU_FLIGHT_INFO,
                    flight[FIELD_FLIGHT_NUMBER],
                    flight[FIELD_FLIGHT_AIRPORT],
                    flight[FIELD_FLIGHT_SCHEDULED],
                    flight[FIELD_FLIGHT_ACTUAL]
                );
            }
        }
    }

    /**
     * Prints list of departures
     * @param flights array of existing flights
     */
    private static void printDepartures(final String[][] flights) {
        System.out.println(MENU_HEADING_DEPARTURES);
        System.out.printf(
            MENU_FLIGHT_INFO,
            MENU_HEADING_FLIGHT,
            MENU_HEADING_TO,
            MENU_HEADING_STD,
            MENU_HEADING_ATD
        );
        for (String[] flight : flights) {
            if (flight[FIELD_FLIGHT_NUMBER] != null
                && flight[FIELD_FLIGHT_TYPE].equals(FLIGHT_TYPE_DEPARTURE)) {
                System.out.printf(
                    MENU_FLIGHT_INFO,
                    flight[FIELD_FLIGHT_NUMBER],
                    flight[FIELD_FLIGHT_AIRPORT],
                    flight[FIELD_FLIGHT_SCHEDULED],
                    flight[FIELD_FLIGHT_ACTUAL]
                );
            }
        }
    }
    
    /**
     * Prints the total number of flights
     * @param flights array of existing flights
     */
    private static void printNumFlights(final String[][] flights) {
        int numFlights = 0;
        for (String[] flight : flights) {
            if (flight[FIELD_FLIGHT_NUMBER] != null) {
                numFlights++;
            }
        }
        System.out.printf(MENU_HEADING_NUM_FLIGHTS, numFlights);
    }

    /**
     * Prints the total number of delayed flights
     * @param flights array of existing flights
     */
    private static void printNumDelays(final String[][] flights) {
        int numDelays = 0;
        for (String[] flight : flights) {
            if (flight[FIELD_FLIGHT_NUMBER] != null
                && flight[FIELD_FLIGHT_ACTUAL] != ""
                && flight[FIELD_FLIGHT_ACTUAL].compareTo(flight[FIELD_FLIGHT_SCHEDULED]) > 0
            ) {
                numDelays++;
            }
        }
        System.out.printf(MENU_HEADING_NUM_DELAYS, numDelays);
    }
}
