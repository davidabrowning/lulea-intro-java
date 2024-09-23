/**
 * Practicing data storage tasks
 * @author: David Browning (davbro-4)
 */

 public class TaskSet02 {
    static final double PI = 3.14159;
    public static void main(String[] args) {

        System.out.printf("Task 2.1: Simple data storage\n");
        int birthYear = 1986;
        System.out.printf("Age in 2030 will be %d\n", 2030 - birthYear);

        System.out.printf("\nTask 2.2: Use of constants:\n");
        final int MAX_WEIGHT_GRAMS = 100;
        System.out.printf("The maximum weight is %d g\n", MAX_WEIGHT_GRAMS);
        final double PI = 3.14159;
        int diameter = 5;
        System.out.printf("The circumference for diameter %d is %.2f\n", 
            diameter, diameter * PI);

        System.out.printf("\nTask 2.3: Binary format versus storage capacity:\n");
        byte littleNum = 5;
        System.out.printf("%d\n", littleNum);
        // littleNum = 128; Not allowed - too large
        System.out.printf("%d\n", littleNum);

        System.out.printf("\nTask 2.4: Manage the number of decimals for floating point numbers:\n");
        int numOfDecimals = 3;
        double scale = Math.pow(10, numOfDecimals);
        System.out.printf("Scale is %.0f\n", scale);
        double newPi = Math.round(PI * scale) / scale;
        System.out.printf("Pi is %f\n", PI);
        System.out.printf("Rounded pi is %.3f\n", newPi);

        System.out.printf("\nTask 2.5: Rounding problems for floating point numbers\n");
        double a = 1.7;
        double b = 1.9;
        double c = a + 0.1;
        double d = b - 0.1;
        System.out.printf("Unrounded:\n");
        System.out.println(c);  // Expected 1.8
        System.out.println(d);  // Expected 1.8
        System.out.printf("Rounded:\n");
        numOfDecimals = 1;
        scale = Math.pow(10, numOfDecimals);
        c = Math.round(c * scale) / scale;
        d = Math.round(d * scale) / scale;
        System.out.println(c);  // Expected 1.8
        System.out.println(d);  // Expected 1.8

        System.out.printf("\nTask 2.6: The dependence between input data and results\n");
        int firstSum = 10000 + 10 * 100;
        float secondSum = 10000 + (101.36f * 10);
        System.out.println("First sum: " + firstSum);   // Expected 11000
        System.out.println("Second sum: " + secondSum); // Expected 11013.6

        System.out.printf("\nTask 2.7: Divisions with or without a quotient\n");
        int first = 3/4;
        double second = 3 / 4.0;
        System.out.println("First division: " + first);
        System.out.println("Second division: " + second);

        System.out.printf("\nTask 2.8: Use of modulo\n");
        int firstQuotient = 5 / 4;
        int firstRemainder = 5 % 4;
        int secondQuotient = 15 / 8;
        int secondRemainder = 15 % 8;
        int thirdQuotient = 9 / 7;
        int thirdRemainder = 9 % 7;
        System.out.println("5/4 gives integer " + firstQuotient + " and remainder " + firstRemainder);
        System.out.println("15/8 gives integer " + secondQuotient + " and remainder " + secondRemainder);
        System.out.println("9/7 gives integer " + thirdQuotient + " and remainder " + thirdRemainder);

        System.out.printf("\nTask 2.9: Conversion between different data types\n");
        final double PI_TASK_2_9 = 3.141592654;
        double dProduct = PI_TASK_2_9 * 3.45f;
        float fProduct = (float) (PI_TASK_2_9 * 3.45f);
        int iProduct = (int) (PI_TASK_2_9 * 3.45);
        System.out.println("Product as double: " + dProduct);
        System.out.println("Product as float: " + fProduct);
        System.out.println("Product as integer: " + iProduct);

    }
}
