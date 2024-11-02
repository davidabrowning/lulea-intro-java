package MarkedAssignments.Assignment03MathematicMethods;

// Imports
import java.util.Scanner;

/**
 * PROGRAM DESCRIPTION
 * 1. Declare Scanner and constants
 * 2. Keep injectionInput() method for grading purposes
 * 3. Declare local variables
 * 4. Ask user for input to area and volume methods
 * 5. Loop until user chooses to quit:
 *      5a. Get next radius input
 *      5b. Get next height input
 *      5c. Calculate and print areas and volumes
 * 6. Ask user for input to fraction methods
 * 7. Loop until user chooses to quit:
 *      7a. Get next numerator input
 *      7b. Get next denominator input
 *      7c. Calculate and print fraction
 * 8. Close the Scanner object
 *
 * @author David Browning (davbro-4)
 * @version 1.0
 */
public class Main {

    // 1. Declare Scanner and constants
    private static Scanner userInputScanner = new Scanner(System.in);
    static final int QUIT = -1;
    static final String USER_INPUT_INDICATOR = "> ";

    // 2. Keep injectionInput() method for grading purposes

    /**
     * This method should be used only for unit testing on CodeGrade. Do not change this method!
     * Do not remove this method!
     * Swaps userInputScanner with a custom scanner object bound to a test input stream
     *
     * @param inputScanner - test scanner object
     */
    public static void injectInput(final Scanner inputScanner) {
        userInputScanner = inputScanner;
    }

    /**
     * Main method: Entry point for program
     * @param args - not used by program
     */
    public static void main(final String[] args) {

        // 3. Declare local variables
        int radius = 0;
        int height = 0;
        int numerator = 0;
        int denominator = 0;

        // 4. Ask user for input to area and volume methods
        System.out.println("----------------------------------");
        System.out.println("# Test of area and volume methods");
        System.out.println("----------------------------------");
        System.out.printf(USER_INPUT_INDICATOR);

        // 5. Loop until user chooses to quit:
        while (true) {

            // 5a. Get next radius input
            radius = input();
            if (radius == QUIT) {
                break;
            }

            // 5b. Get next height input
            height = input();
            if (height == QUIT) {
                break;
            }

            // 5c. Calculate and print areas and volumes
            System.out.println("\nr = " + radius + ", h = " + height);
            System.out.printf("Circle area: %.2f %n", area(radius));
            System.out.printf("Cone area: %.2f %n", area(radius, height));
            System.out.printf("Cone volume: %.2f %n", volume(radius, height));
        }

        // 6. Ask user for input to fraction methods
        System.out.println("----------------------------------");
        System.out.println("# Test of the fractional methods");
        System.out.println("----------------------------------");
        System.out.printf(USER_INPUT_INDICATOR);

        // 7. Loop until user chooses to quit:
        while (true) {

            // 7a. Get next numerator input
            numerator = input();
            if (numerator == QUIT) {
                break;
            }

            // 7b. Get next denominator input
            denominator = input();
            if (denominator == QUIT) {
                break;
            }

            // 7c. Calculate and print fraction
            System.out.printf("%d/%d = ", numerator, denominator);
            printFraction(fraction(numerator, denominator));
        }

        // 8. Close the Scanner object
        userInputScanner.close();
    }

    /**
     * Calculates the area of a circle
     * @param radius - the radius of the circle
     * @return - a double representing the area of the circle
     */
    public static double area(final int radius) {
        double area = 0.0;
        area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    /**
     * Calculates the surface area of a cone
     * @param radius - the radius of the cone's base
     * @param height - the height of the cone
     * @return - a double representing the surface area of the cone
     */
    public static double area(final int radius, final int height) {
        double area = 0.0;
        double s = pythagoras(radius, height);
        area = Math.PI * radius * s;
        return area;
    }

    /**
     * Calculates the hypotenuse of a right triangle
     * @param sideA - the length of one short side of the triangle
     * @param sideB - the length of the other short side of the triangle
     * @return - a double representing the length of the triangle's hypotenuse
     */
    public static double pythagoras(final int sideA, final int sideB) {
        double hypotenuse = 0.0;
        hypotenuse = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
        return hypotenuse;
    }

    /**
     * Calculates the volume of a cone
     * @param radius - the radius of the cone's base
     * @param height - the height of the cone
     * @return - a double representing the cone's volume
     */
    public static double volume(final int radius, final int height) {
        double volume = 0.0;
        volume = Math.PI * Math.pow(radius, 2) * height / 3;
        return volume;
    }

    /**
     * Converts a numerator/denominator pair into fraction parts.
     * For example, 9/5 would be returned as [1, 4, 5], indicating 1 4/5.
     * If denominator is 0, method returns null.
     * If numerator and denominator have a common denominator, they are
     * simplified through division by the greatest common denominator.
     * @param numerator - the input fraction's numerator
     * @param denominator - the input fraction's denominator
     * @return - an int[] representing the resultant fraction's 3 parts:
     * whole number, fraction numerator, and fraction denominator.
     */
    public static int[] fraction(final int numerator, final int denominator) {
        int[] fraction = new int[3];
        int gcd = 0;

        if (denominator == 0) {
            return null;
        }

        fraction[0] = numerator / denominator;
        fraction[1] = numerator % denominator;
        fraction[2] = denominator;

        gcd = gcd(fraction[1], fraction[2]);
        fraction[1] /= gcd;
        fraction[2] /= gcd;

        return fraction;
    }

    /**
     * Finds the greatest common denominator between two integers
     * @param a - integer one
     * @param b - integer two
     * @return - an integer representing integer one and two's greatest
     * common denominator
     */
    public static int gcd(final int a, final int b) {
        int gcd = 1;
        for (int i = a; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    /**
     * Prints a fraction as a String.
     * For example, [1, 4, 5] is printed as 1 4/5.
     * If numerator is nonzero and whole number component is 0 then whole
     * number is ignored. For example, [0, 3, 8] is printed as 3/8.
     * If numerator is 0 then only whole number is printed.
     * For example, [7, 0, 5] is printed as 7.
     * @param parts - the 3-part int[] input representing the fraction's
     * whole number, numerator, and denominator components.
     */
    public static void printFraction(final int[] parts) {
        if (parts == null) {
            System.out.printf("Error%n");
            return;
        }

        if (parts[1] > 0) {
            if (parts[0] > 0) {
                System.out.printf("%d %d/%d%n", parts[0], parts[1], parts[2]);
            } else {
                System.out.printf("%d/%d%n", parts[1], parts[2]);
            }
        } else {
            System.out.printf("%d%n", parts[0]);
        }
    }

    /**
     * Loops through userInputScanner Scanner object until it finds an int or
     * a "q" representing a request to quit the program.
     * @return - an int representing either user int input or int constant
     * representing user's desire to quit the program.
     */
    public static int input() {
        int input = 0;

        while (true) {
            if (userInputScanner.hasNextInt()) {
                input = userInputScanner.nextInt();
                input = Math.abs(input);
                break;
            }
            if (userInputScanner.next().equals("q")) {
                input = QUIT;
                break;
            }
        }

        return input;
    }
}