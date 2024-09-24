package TaskSet04;

import java.util.Scanner;

/**
 * DESCRIPTION:
 * For a given loop, you always want to run the loop at least once before 
 * the user's input of an integer causes the loop to end. You can enter 
 * the following example and see that the loop is run at least once 
 * before the condition is checked.
 * 
 * @author David Browning (davbro-4)
 */
public class Task0407 {

    public static void main(String[] args) {

        // Variables
        Scanner userInput = new Scanner(System.in);
        int number = 0; 

        do { 
            System.out.print("Enter an integer:"); 
            number = userInput.nextInt(); 
            System.out.println("Number:" + number); 
        } while (number> 0);

        userInput.close();
    }
}
