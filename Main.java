/**
 * Use this file as a general sandbox.
 * @author David Browning (davbro-4)
 */

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = userInput.nextLine();
        userInput.close();

        Scanner userInput2 = new Scanner(System.in);
        System.out.print("Enter another string: ");
        String str2 = userInput2.nextLine();
        userInput2.close();
    }
}
