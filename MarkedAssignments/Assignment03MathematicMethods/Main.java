package MarkedAssignments.Assignment03MathematicMethods;

// Imports
import java.util.Scanner;

/**
 * PROGRAM DESCRIPTION
 * 
 * @author David Browning (davbro-4)
 * @version 1.0
 */
public class Main {

    // Creation of Scanner object
    private static Scanner userInputScanner = new Scanner(System.in);

    // Constants
    static final int QUIT = -1;
    static final String USER_INPUT_INDICATOR = "> ";

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
     * 
     * @param args - not used by program
     */
    public static void main(final String[] args) {

        // Local variables
        int radius = 0;
        int height = 0;
        int numerator = 0;
        int denominator = 0;

        // Print the header of the program for area and volume.
        System.out.println("----------------------------------");
        System.out.println("# Test of area and volume methods");
        System.out.println("----------------------------------");

        // Print the user input indicator.
        System.out.printf(USER_INPUT_INDICATOR);

        // While loop that runs until user enters "q" for area and volume.
        while (true) {

            radius = input();
            if (radius == QUIT) {
                break;
            }

            height = input();
            if (height == QUIT) {
                break;
            }

            System.out.println("\nr = " + radius + ", h = " + height);
            System.out.printf("Circle area: %.2f %n", area(radius));
            System.out.printf("Cone area: %.2f %n", area(radius, height));
            System.out.printf("Cone volume: %.2f %n", volume(radius, height));
        }

        // Print the header of the program for area and volume.
        System.out.println("----------------------------------");
        System.out.println("# Test of the fractional methods");
        System.out.println("----------------------------------");

        // Print the user input indicator.
        System.out.printf(USER_INPUT_INDICATOR);

        // While loop that runs until user enters "q" for the fraction part
        while (true) {

            numerator = input();
            if (numerator == QUIT) {
                break;
            }

            denominator = input();
            if (denominator == QUIT) {
                break;
            }

            System.out.printf("%d/%d = ", numerator, denominator);
            printFraction(fraction(numerator, denominator));
        }
    }

    public static double area(final int radius) {
        double area = 0.0;
        area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    public static double area(final int radius, final int height) {
        double area = 0.0;
        double s = pythagoras(radius, height);
        area = Math.PI * radius * s;
        return area;
    }

    public static double pythagoras(final int sideA, final int sideB) {
        double hypotenuse = 0.0;
        hypotenuse = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
        return hypotenuse;
    }

    public static double volume(final int radius, final int height) {
        double volume = 0.0;
        volume = Math.PI * Math.pow(radius, 2) * height / 3;
        return volume;
    }

    public static int[] fraction(int numerator, int denominator) {
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
