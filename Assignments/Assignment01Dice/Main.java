package Assignments.Assignment01Dice;

import java.util.Scanner;
import java.util.Random;

/**
 * The program is a game where the player will roll 3 dice to get a total sum of 12 in order to win.
 * 
 * 1.
 *
 * @author Name (LTU username)
 */
class Main {
  /**
   * Below static strings are there to help you get the messages correct.
   * Autograder checks for these exact strings, so it is mentioned here.
   * You can rename them if you want, and you can directly use them in your code.
   * Just make sure these exact messages are used.
   */
    static final String GAME_START = "Welcome to dice game 12. You must roll 1-3 dice and try to get the sum of 12 ...\n";
    static final String CHOOSE_DICE = "Enter which dice you want to roll [1,2,3] (exit with q):";
    static final String ROUND_WON = "You won!!";
    static final String ROUND_LOST = "You lost!!";
    static final String ROUND_TIE = "You neither won nor lost the round.";
    static final String NEXT_ROUND = "Next round!";
    static final String GAME_OVER = "Game Over!";
    static final String ALREADY_SELECTED_DICE = "Sorry, you have already rolled that dice. Try again";
    static final String INVALID_ENTRY = "Sorry, that is an invalid entry. Try again. Valid entries are 1, 2, 3, and q\n";
    static final String AMOUNT_WIN_STRING = "#win: ";
    static final String AMOUNT_LOST_STRING = " #loss: ";
    static final String SUM_STRING = " sum: ";
    static final int MAX_DICE_VALUE = 6;
    static final int MIN_DICE_VALUE = 1;
    static final int DICE_SUM_TARGET_VALUE = 12;

    public static void main(final String[] args) {

        int dice1Value = 0; // The value of the first dice
        boolean isDice1Rolled = false; // Whether the first dice is rolled or not

        int dice2Value = 0; // The value of the second dice
        boolean isDice2Rolled = false; // Whether the second dice is rolled or not

        int dice3Value = 0; // The value of the third dice
        boolean isDice3Rolled = false; // Whether the third dice is rolled or not

        int sum = 0; // The sum of the dice values
        int winCounter = 0; // The number of wins
        int lossCounter = 0; // The number of losses

        boolean isPlaying = true; // Whether the game is being played or not

        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();

        System.out.println(GAME_START);

        while (isPlaying) {
            System.out.println(CHOOSE_DICE);
            
            isPlaying = false;
        }
        userInput.close();
    }
}