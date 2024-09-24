package TaskSet04;

// Imports
import java.util.Scanner;

/**
 * TASK DESCRIPTION:
 * The boiling point of water is precisely 100 degrees. For a particular immersion heater, 
 * you want to switch off the power supply when the immersion heater reaches the critical 
 * boiling point. Write a program that, given a temperature value, tells you when the 
 * power supply is on or off. If the temperature exceeds 100 degrees, the program should 
 * give an error message about the incorrect temperature. If the temperature is precisely 
 * 100 degrees, the program should tell you that the water is boiling.
 * 
 * PROGRAM DESCRIPTION:
 * 1. Ask user for temperature value
 * 2. Create warning message
 * 3. Print warning message
 * 4. Close Scanner
 * 
 * @author David Browning (davbro-4)
 */
public class Task0402 {

    // Declare constants
    private static int BOILING_POINT_DEGREES = 100;

    public static void main(String[] args) {

        // Declare local variables
        Scanner userInput = new Scanner(System.in);
        int temperatureReading = 0;
        String warningMessage = "";

        // Menu loop
        while (true) {

            // 1a. Ask user for temperature value
            System.out.printf("Enter immersion heater temperature reading (q to quit): ");
            userInput.useDelimiter("\\s");

            // 1b. Validate user input
            if (userInput.hasNextInt()) {
                temperatureReading = userInput.nextInt();
                userInput.nextLine();
            } else {
                if (userInput.next().toLowerCase().equals("q")) {
                    // 4. Close Scanner
                    userInput.close();
                    
                    // Quit program
                    System.out.printf("Program closing. Thank you!%n");
                    return;
                }

                System.out.printf("I'm sorry, I didn't understand that input.%n");
                continue;
            }

            // 2. Create warning message
            if (temperatureReading < BOILING_POINT_DEGREES) {
                warningMessage = "Immersion heater is on.";
            } else if (temperatureReading == BOILING_POINT_DEGREES) {
                warningMessage = "The water is boiling.";
            } else {
                warningMessage = "Immersion heater is off.";
            }

            // 3. Print warning message
            System.out.printf("Warning message: %s%n", warningMessage);
        }

    }
    
}
