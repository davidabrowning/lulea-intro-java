package PracticeProblems;
/**
 * Practice problems for Intro Java
 * at Luleå tekniska universitet
 * 
 * @author David Browning (davbro-4)
 */
public class PracticeProblem01 {
    public static void main(String[] args) {
        System.out.println("\nData types: Invitation");
        System.out.println("You are welcome to attend the next Java party");
        System.out.println("on Saturday 21 May at 19.30");

        System.out.println("\nData types: Phone number");
        String firstName = "David";
        String lastName = "Browning";
        String mobileNumber = "073 561 55 55";
        System.out.printf("%s %s\n%s\n", firstName, lastName, mobileNumber);

        System.out.println("\nData types: Roll the dics");
        int roll1 = (int) (Math.random() * 6) + 1;
        int roll2 = (int) (Math.random() * 6) + 1;
        int roll3 = (int) (Math.random() * 6) + 1;
        int sum = roll1 + roll2 + roll3;
        System.out.printf("%d %d %d\n%d\n", roll1, roll2, roll3, sum);

        System.out.println("\nData types: Area of a circle");
        final double PI = 3.1415;
        double radius = Math.random() * 10 + 1;
        double area = PI * Math.pow(radius, 2);
        System.out.printf("%f\n%f\n", radius, area);

    }
}
