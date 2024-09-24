package TaskSet04;

// Imports
import java.util.Scanner;

/**
 * Instructions:
 * In Sweden, the driving license age is currently 18 years. 
 * Write a program that reads in a particular person's age 
 * and then, based on the person's age, prints whether the 
 * person is eligible for a driving license.
 * 
 * Program description:
 * 1. Ask user for age
 * 2. Check if the user can drive
 * 3. Print the result
 * 
 * @author David Browning (davbro-4)
 */
public class Task4dot1 {

    // Declare constants
    int DRIVING_AGE = 18;
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

        System.out.printf("%nYou entered: %d", userAge);

        // Close the Scanner
        userInput.close();

    }
}