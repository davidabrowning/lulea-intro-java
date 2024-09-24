package ModuleNotes;
import java.util.Scanner;
public class Module02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("\nModule 2: Validating input");
        runValidateInput(input);

        System.out.println("\nModule 2: Operator precedence and associativity");
        runOperatorPrecedenceAndAssociativity();

        System.out.println("\nControl statements");
        runControlStatements();


    }

    private static void runValidateInput(Scanner input) {
        while (true) {
            System.out.print("Enter a number: ");

            if (input.hasNextInt()) {
                System.out.println("hasNextInt");
            }

            if (input.hasNextFloat()) {
                System.out.println("hasNextFloat");
            }

            if (input.hasNext()) {
                System.out.println("hasNext (String)");
            }

            input.nextLine();
        }
    }

    private static void runOperatorPrecedenceAndAssociativity() {
        // Initialize the variables
        int a = 10;
        int b = 20;
        int c = 30;

        // Demonstrate operator precedence using arithmetic operators
        int result1 = a + b * c;
        int result2 = (a + b) * c;
        System.out.println("Result 1: " + result1 + " (expected: 610)");
        System.out.println("Result 2: " + result2 + " (expected: 900)");

        // Demonstrate operator associativity using arithmetic operators
        int result3 = a - b + c;
        int result4 = a - (b + c);
        System.out.println("Result 3: " + result3 + " (expected: 20)");
        System.out.println("Result 4: " + result4 + " (expected: -40)");
    }

    private static void runControlStatements() {
        int number = 10;
        if (number > 0) {
            System.out.println("NUmber is positive");
        } else {
            System.out.println("Number is negative or zero");
        }
    }
}
