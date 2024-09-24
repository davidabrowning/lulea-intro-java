package TaskSet04;

// Imports
import java.util.Scanner;

/**
 * TASK INSTRUCTIONS
 * In Sweden, the driving license age is currently 18 years. 
 * Write a program that reads in a particular person's age 
 * and then, based on the person's age, prints whether the 
 * person is eligible for a driving license.
 * 
 * PROGRAM DESCRIPTION
 * 1. Ask user for age
 * 2. Check if the user can drive
 * 3. Print the result
 * 4. Close the Scanner
 * 
 * @author David Browning (davbro-4)
 */
public class Task0401 {

    // Declare constants
    public static int DRIVING_AGE = 18;
    
    public static void main(String[] args) {

        // Declare local variables
        Scanner userInput = new Scanner(System.in);
        boolean validInput = false;
        int userAge = 0;
        boolean drivingEligibility = false;

        // 1. Ask user for age
        validInput = false;
        do {
            System.out.printf("%nPlease enter your age: ");
            if (userInput.hasNextInt()) {
                userAge = userInput.nextInt();
                validInput = true;
            } else {
                userInput.nextLine();
                System.out.printf("%nI'm sorry, I didn't understand that.");
            }
        } while (!validInput);

        // 2. Check if user can drive
        if (userAge >= DRIVING_AGE) {
            drivingEligibility = true;
        }

        System.out.printf("%nYou entered: %d", userAge);

        // Close the Scanner
        userInput.close();

    }
}