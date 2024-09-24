package TaskSet04;

// Imports

/**
 * TASK:
 * 1.   Animals are generally unisexual, i.e., either female or male. 
 *      Create a logical expression with appropriate relationship 
 *      operators that determine whether a particular individual is 
 *      male or female. Use two different variables to represent the 
 *      male. Thus a Boolean variable is true about males and a 
 *      Boolean variable is true about females. Show how you, with 
 *      exclusive OR (^), can implement a solution where only one 
 *      gender at a time gives true.
 * 2.   Worms are bisexual hermaphrodites, i.e., both male/female. 
 *      Complement your solution so that the combination of male and 
 *      female simultaneously shows the result of hermaphrodite.
 * 
 * PROGRAM DESCRIPTION:
 * 1. Check if male
 * 2. Check if female
 * 3. Check if hermaphrodite
 * 
 * @author David Browning (davbro-4)
 */
public class Task0405 {

    // Constants
    private static String ANIMAL_1 = "Male cat";
    private static String ANIMAL_2 = "Female dog";
    private static String ANIMAL_3 = "Worm";

    public static void main(String[] args) {

        // Variables
        String currentAnimal = "";
        boolean isMale = false;
        boolean isFemale = false;

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                currentAnimal = ANIMAL_1;
                isMale = true;
                isFemale = false;
            }
            if (i == 1) {
                currentAnimal = ANIMAL_2;
                isMale = false;
                isFemale = true;
            }
            if (i == 2) {
                currentAnimal = ANIMAL_3;
                isMale = true;
                isFemale = true;
            }

            // Print animal header
            System.out.printf("%n%s%n", currentAnimal);

            // 1. Check if male

            // 2. Check if female

            // 3. Check if hermaphrodite


        }

    }
    
}
