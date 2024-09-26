package PracticeProblems.PracticeProblems02;

// Imports
import java.util.Scanner;

/**
 * TASK:
 * Write a Java program that asks for the number of hours, minutes, and 
 * seconds. Use the Scanner class with the colon sign ':' as a delimiter 
 * (see below). The program will then calculate and print how many 
 * seconds it was in total.
 * 
 * PROGRAM DESCRIPTION:
 * 1. Ask for user input (HH:MM:SS)
 * 2. Validate user input
 * 3. Calculate number of seconds
 * 4. Display number of seconds
 * 
 * 
 * @author David Browning (davbro-4)
 */
public class B2Time {

    // Constants
    private static String TIME_INPUT_INSTRUCTIONS = "Please enter a time amount (HH:MM:SS): ";
    private static String TIME_INPUT_DELIMITER = ":|\\s+";
    private static String INVALID_TIME_MESSAGE = "Invalid time entered.";
    private static int SECONDS_PER_MINUTE = 60;
    private static int SECONDS_PER_HOUR = 3600;
    private static String TIME_OUTPUT_MESSAGE_START = "The time you entere is";
    private static String TIME_OUTPUT_MESSAGE_END = "seconds.";

    public static void main(final String[] args) {

        // Variables
        int userHours = 0;          // Tracks user-entered hours
        int userMinutes = 0;        // Tracks user-entered minutes
        int userSeconds = 0;        // Tracks user-entered seconds
        int totalSeconds = 0;       // Tracks total seconds calculated

        // Initialize Scanner
        Scanner userInput = new Scanner(System.in);

    }
    
}
