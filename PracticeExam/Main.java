package PracticeExam;

import java.util.Scanner;

/**
 * PROGRAM DESCRIPTION
 * @author David Browning (davbro-4)
 * @version 1.0
 */
public class Main {

    // Constants: Scanner object
    private static final Scanner userInputRetriever = new Scanner(System.in);

    // Constants: Data values
    private static int FLIGHT_NUMBER_LENGTH = 5;
    private static int FLIGHT_TIME_LENGTH = 5;
    private static String FLIGHT_TIME_HH_MIN = "00";
    private static String FLIGHT_TIME_HH_MAX = "23";
    private static String FLIGHT_TIME_HHMM_SEPARATOR = ":";
    private static String FLIGHT_TIME_MM_MIN = "00";
    private static String FLIGHT_TIME_MM_MAX = "59";
    private static int MAX_FLIGHTS_PER_DAY = 100;
    private static int TEXT_FIELDS_PER_FLIGHT = 5;
    private static int FIELD_FLIGHT_TYPE = 0;
    private static int FIELD_FLIGHT_NUMBER = 1;
    private static int FIELD_FLIGHT_AIRPORT = 2;
    private static int FIELD_FLIGHT_SCHEDULED = 3;
    private static int FIELD_FLIGHT_ACTUAL = 4;
    private static String FLIGHT_TYPE_ARRIVAL = "arrival";
    private static String FLIGHT_TYPE_DEPARTURE = "departure";

    // Constants: Menu text
    private static final String MENU_MAIN = 
        "\n-----------------------------------"
        + "\n# LTU Airport AD Management System"
        + "\n-----------------------------------"
        + "\n1. Register the scheduled arrival"
        + "\n2. Register the scheduled departure"
        + "\n3. Register the actual arrival of a flight"
        + "\n4. Register the actual departure of a flight"
        + "\n5. Print operations summary"
        + "\nq. End program"
        + "\n> Enter your option: ";
    private static final String MENU_FLIGHT_INFO = "%-8s %-15s %-8s %-8s%n";

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


    public static void main(final String[] args) {

        String[][] flights = new String[MAX_FLIGHTS_PER_DAY][TEXT_FIELDS_PER_FLIGHT];
        boolean run = true; // If program should keep running
        int userMenuChoice = 0; // For use in menu switch statement

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
                    System.out.println("End program.");
                    run = false;
                    break;
                default:
                    System.out.println("Unexpected input.");
                    break;
            }

        }

        userInputRetriever.close(); // Close the Scanner object
        
    }

    // Done
    private static void printMainMenu() {
        System.out.print(MENU_MAIN);
    }

    // Done
    private static int getMainMenuSelection() {
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
        if (userSelection < SELECTION_MIN_VALUE ||
            userSelection > SELECTION_MAX_VALUE) {
                userSelection = SELECTION_INVALID;
        }

        // Return user's menu selection
        return userSelection;
    }

    // Done
    private static void registerScheduledFlight(final String[][] flights, String flightType) {
        String[] flight = new String[TEXT_FIELDS_PER_FLIGHT]; // New flight
        flight[FIELD_FLIGHT_TYPE] = flightType; // Arrival or departure
        flight[FIELD_FLIGHT_ACTUAL] = ""; // Will hold actual arrival time

        // Collect and validate flight number
        System.out.print("Enter flight number: ");
        flight[FIELD_FLIGHT_NUMBER] = userInputRetriever.next();
        if (isValidFlightNumber(flight[FIELD_FLIGHT_NUMBER], flights) == false) {
            return;
        }

        // Collect airport name
        System.out.print("Enter airport: ");
        flight[FIELD_FLIGHT_AIRPORT] = userInputRetriever.next();

        // Collect and validate arrival time
        System.out.print("Enter scheduled time: ");
        flight[FIELD_FLIGHT_SCHEDULED] = userInputRetriever.next();
        if (isValidFlightTime(flight[FIELD_FLIGHT_SCHEDULED], flights) == false) {
            return;
        }

        // Log flight
        logFlight(flight, flights);

        // Print confirmation for user
        System.out.printf(
            "The %s of flight %s from %s is scheduled for %s.",
            flightType,
            flight[FIELD_FLIGHT_NUMBER], 
            flight[FIELD_FLIGHT_AIRPORT], 
            flight[FIELD_FLIGHT_SCHEDULED]
        );
    }

    // Done, remove magic numbers
    static boolean isValidFlightNumber(String flightNum, String[][] flights) {
        
        // Validate that flight number is exactly five characters long
        if (flightNum.length() != FLIGHT_NUMBER_LENGTH) {
            System.out.println("Flight number incorrect length.");
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
                System.out.println("Flight number must start with two capital letters and end with three digits.");
                return false;
        }
        
        // Validate that flight does not already exist
        for (String[] existingFlight : flights) {
            if (existingFlight[FIELD_FLIGHT_NUMBER] == null) {
                continue;
            }
            if (existingFlight[FIELD_FLIGHT_NUMBER].equals(flightNum)) {
                System.out.println("Flight number already exists.");
                return false;
            }
        }

        // If no tests have failed, return true
        return true;
    }

    // Done, use String constants
    static boolean isValidFlightTime(String flightTime, String[][] flights) {
        // Validate that time length is correct
        if (flightTime.length() != FLIGHT_TIME_LENGTH) {
            System.out.println("Invalid time format.");
            return false;
        }

        // Validate that the time is in the range 00:00 - 23:59
        if (isValidTimeFormat(flightTime) == false) {
            return false;
        }
        
        // If no tests have failed, return true
        return true;
    }

    // Validate that the time is in the range 00:00 - 23:59
    private static boolean isValidTimeFormat(String time) {
        String arrivalTimeHH = time.substring(0, 2);
        String arrivalTimeHHMMSeparator = time.substring(2, 3);
        String arrivalTimeMM = time.substring(3, 5);
        if (arrivalTimeHH.compareTo(FLIGHT_TIME_HH_MIN) >= 0
            || arrivalTimeHH.compareTo(FLIGHT_TIME_HH_MAX) <= 0
            || arrivalTimeHHMMSeparator.equals(FLIGHT_TIME_HHMM_SEPARATOR) == true
            || arrivalTimeMM.compareTo(FLIGHT_TIME_MM_MIN) >= 0 
            || arrivalTimeMM.compareTo(FLIGHT_TIME_MM_MAX) >= 0) {
                
                return true;
        } else {
            System.out.println("Invalid time format.");
            return false;
        }  
    }

    // Done
    private static void logFlight(String[] flight, String[][] flights) {
        int nextFlightIndex = getFirstEmptyIndex(flights);
        flights[nextFlightIndex] = flight;
    }

    // Done
    private static int getFirstEmptyIndex(String[][] twoDArray) {
        for (int i = 0; i < twoDArray.length; i++) {
            if (twoDArray[i][0] == null) {
                return i;
            }
        }
        return -1;
    }

    private static void registerActualFlight(String[][] flights, String flightType) {
        String flightNum = "";
        String actualFlightTime = "";
        boolean flightExists = false;

        // Collect and validate flight number
        System.out.print("Enter flight number: ");
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
            System.out.println("Flight number does not exist. Unable to find " + flightType + " with that flight number.");
            return;
        }

        // Collect and validate actual flight time
        System.out.print("Enter actual time of " + flightType + ": ");
        actualFlightTime = userInputRetriever.next();
        if (isValidTimeFormat(actualFlightTime) == false) {
            return;
        }

        logActualTime(flightNum, actualFlightTime, flights);

    }

    private static void logActualTime(String flightNum, String actualFlightTime, String[][] flights) {
        for (String[] flight : flights) {
            if (flight[FIELD_FLIGHT_NUMBER] == null) {
                continue;
            }
            if (flight[FIELD_FLIGHT_NUMBER].equals(flightNum)) {
                flight[FIELD_FLIGHT_ACTUAL] = actualFlightTime;
            }
        }
    }

    // In progress, add total flights and delayed flights
    private static void printOperations(String[][] flights) {
        System.out.println("\nLTU Airport operations summary:");
        printArrivals(flights);
        printDepartures(flights);
    }

    // Done
    private static void printArrivals(String[][] flights) {
        System.out.println("\nArrivals:");
        System.out.printf(MENU_FLIGHT_INFO, "Flight", "From", "STA", "ATA");
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

    // Done
    private static void printDepartures(String[][] flights) {
        System.out.println("\nDepartures:");
        System.out.printf(MENU_FLIGHT_INFO, "Flight", "To", "STD", "ATD");
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
    
}
