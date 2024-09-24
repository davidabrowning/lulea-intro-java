package TaskSet03;
/**
 * Practicing using the Scanner class
 * @author David Browning (davbro-4)
 */

import java.util.Scanner;
// import java.util.Locale;

public class Task03 {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("\nTask 3.1: Input");
        runTask3_1(userInput);

        System.out.println("\nTask 3.2: Problems with mixed input types");
        runTask3_2(userInput);

        System.out.println("\nTask 3.3: Character format (char)");
        runTask3_3();

        System.out.println("\nTask 3.4: Locale");
        runTask3_4();

        System.out.println("\nTask 3.5: Input/print/formatted print");
        runTask3_5(userInput);

        userInput.close();

    }

    private static void runTask3_1(Scanner userInput) {
        System.out.print("Enter the path: ");
        userInput.useDelimiter("[://|:/|/]+");
        System.out.println(userInput.next());
        System.out.println(userInput.next());
        System.out.println(userInput.next());
        userInput.nextLine();
    }

    private static void runTask3_2(Scanner userInput) {
        int age;
        String name;
        
        System.out.print("How old are you?: ");
        age = Integer.parseInt(userInput.nextLine());

        System.out.print("What is your name?: ");
        name = userInput.nextLine();

        System.out.println("Your name is " + name + " and you are " + age + " years old.");
    }

    private static void runTask3_3() {
        char firstChar = '\u0061';
        char secondChar = 'n';
        char thirdChar = 110;
        char fourthChar = 'a';
        System.out.println("Den sammanslagna strängen blir : "
            + firstChar + secondChar + thirdChar + fourthChar);
    }

    private static void runTask3_4() {
        // Commenting out since this uses a deprecated contructor Locale(String, String)
        // and will not be addressed

        // Locale svenska = new Locale("sv", "SE");
        // Locale.setDefault(svenska);
        // double testDecimal = 10 / 3.8;
        // System.out.printf("Test decimal in Swedish: %2.2f\n", testDecimal);
    }

    private static void runTask3_5(Scanner userInput) {
        System.out.print("Enter two integers separated by a space: ");
        userInput.useDelimiter("[\\s|\n]");
        int a = userInput.nextInt();
        int b = userInput.nextInt();
        System.out.printf("Total: %d\nDifference; %d\nProduct: %d"
            + "\nAbsolute value of the difference: %d"
            + "\nAverage value: %.2f\nMaximum value: %d"
            + "\nMinimum value: %d\n", a+b, a-b, a*b, Math.abs(a-b),
            (a+b)/2.0, Math.max(a,b), Math.min(a,b));
    }
}
