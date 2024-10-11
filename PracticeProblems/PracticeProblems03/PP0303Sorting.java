package PracticeProblems.PracticeProblems03;

/**
 * === Task description ===
 * Write a program that randomizes 30 integers from 1 to 100 into an array a, sorts them, and prints them.
 * 
 * === Program description ===
 * 1. Declare constants
 * 2. Declare variables
 * 3. Populate random number array
 * 4. Print unsorted random number array
 * 5. Sort array with selection sort
 * 6. Print sorted array
 * 
 * @author David Browning (davbro-4)
 */
public class PP0303Sorting {

    // 1. Declare constants
    static int NUMBERS_TO_GENERATE = 30;
    static int RANGE_MIN = 1;
    static int RANGE_MAX = 100;

    public static void main(final String[] args) {
        // 2. Declare variables
        int[] numbers = new int[NUMBERS_TO_GENERATE];   
                            // Stores numbers generated
        int temp = 0;       // Assists with swapping array elements

        // 3. Populate random number array
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 99) + 1;
        }

        // 4. Print unsorted random number array
        for(int i : numbers) {
            System.out.print(i + " ");
        }

        // 5. Sort array with selection sort

        // 6. Print sorted array

    }
}
