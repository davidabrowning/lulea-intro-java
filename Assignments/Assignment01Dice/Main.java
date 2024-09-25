package Assignments.Assignment01Dice;

import java.util.Scanner;
import java.util.Random;

/**
 * PROGRAM SUMMARY:
 *  The program is a game where the player will roll 3 dice to get a total 
 *  sum of 12 in order to win.
 * 
 * PROGRAM DESCRIPTION:
 *  1. Print game instructions
 *  2. Loop until user enters q
 *  3. Ask for user to select a die to roll
 *  4. Validate user's die selection
 *  5. Process die roll
 *  6. Print die status and win/loss status
 *  7. Print win/loss message
 *  8. Print next round message
 *  9. If game over:
 *      9a. Print win/loss status
 *      9b. Print Game Over
 *      9c. Close Scanner
 *      9d. System exit
 *
 * @author David Browning (davbro-4)
 */
public class Main {

    // Constants
    private static final String GAME_START = "Welcome to dice game 12. You must roll 1-3"
        + " dice and try to get the sum of 12 ...\n";
    private static final String CHOOSE_DIE = "Enter which dice you want to roll [1,2,3]"
        + " (exit with q):";
    private static final String ROUND_WON = "You won!!";
    private static final String ROUND_LOST = "You lost!!";
    private static final String ROUND_TIE = "You neither won nor lost the round.";
    private static final String NEXT_ROUND = "Next round!";
    private static final String GAME_OVER = "Game Over!";
    private static final String ALREADY_SELECTED_DICE = "Sorry, you have already rolled"
        + "that dice. Try again";
    private static final String INVALID_ENTRY = "Sorry, that is an invalid entry. Try"
        + " again. Valid entries are 1, 2, 3, and q\n";
    private static final String AMOUNT_WIN_STRING = "#win: ";
    private static final String AMOUNT_LOST_STRING = " #loss: ";
    private static final String SUM_STRING = " sum: ";
    private static final int MAX_DIE_VALUE = 6;
    private static final int MIN_DIE_VALUE = 1;
    private static final int DICE_SUM_TARGET_VALUE = 12;

    public static void main(final String[] args) {

        // Variables
        int die1Value = 0;              // The value of the first die
        boolean isDie1Rolled = false;   // Whether the first die is rolled or not

        int die2Value = 0;              // The value of the second die
        boolean isDie2Rolled = false;   // Whether the second die is rolled or not

        int die3Value = 0;              // The value of the third die
        boolean isDie3Rolled = false;   // Whether the third die is rolled or not

        int sum = 0;                    // The sum of the die values
        int winCounter = 0;             // The number of wins
        int lossCounter = 0;            // The number of losses

        boolean isPlaying = true;       // Whether the game is being played or not

        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();

        // 1. Print game instructions
        System.out.println(GAME_START);

        // 2. Loop until user enters q
        while (isPlaying) {
            System.out.println(CHOOSE_DIE);
            
            isPlaying = false;
        }
        userInput.close();
    }
}