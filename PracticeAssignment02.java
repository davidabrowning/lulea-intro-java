// Imports
import java.util.Scanner;

/**
 * Program description:
 *  - Steps:
 *      - User enters time hh:mm for sunrise/sunset via Scanner object
 *      - Validations
 *          - Date is in June or July
 *          - House/minute/day is valid
 *          - Sunrise is later than sunset
 *          - Give error message and quit otherwise
 *      - Calculate number of hours of sunshine
 *      - Calculate production output
 *      - Calculate profit
 *      - Present results to two decimal place accuracy
 *  - Assumptions:
 *      - Solar panels work at 20% efficiency
 *      - Solar radiation is 166 Wh / m^2 / hour
 *      - Electricity price is 0.9 SEK / kWh
 *      - Production is radiation * efficiency * surface area * hours of sunshine
 * @author David Browning (davbro-4) 
 * */

 // Imports
 import java.util.Scanner;

public class PracticeAssignment02 {

    // Define constants
    private static final int JUNE_AS_INT = 6;
    private static final int JULY_AS_INT = 7;
    private static final int DAYS_IN_JUNE = 30;
    private static final int DAYS_IN_JULY = 31;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int HOURS_PER_DAY = 24;
    private static final double SOLAR_PANEL_EFFICIENCY = 0.2;
    private static final double RADIATION_WH = 166;
    private static final int WH_PER_KWH = 1000;
    private static final double PRICE_SEK_PER_KWH = 0.9;
    private static final double NUM_SOLAR_PANELS = 26.0;
    private static final double AREA_PER_PANEL_M2 = 1.7;

    public static void main(String[] args) {

        // Define variables
        Scanner userInput = new Scanner(System.in);
        int month = 0;
        int day = 0;
        int sunriseHour = 0;
        int sunriseMinute = 0;
        double sunriseTime = 0.0;
        int sunsetHour = 0;
        int sunsetMinute = 0;
        double sunsetTime = 0.0;
        double sunHours = 0.0;
        double solarPanelSurfaceAreaM2 = 0.0;
        double productionKwh = 0.0;
        double profitSek = 0.0;

        // Collect today's date
        System.out.printf("Enter today's date [mm-dd]> ");
        userInput.useDelimiter("[-|\\s]+");
        month = userInput.nextInt();
        day = userInput.nextInt();

        // Validate today's month
        // Exit if month is neither June nor July
        if (month != JUNE_AS_INT && month != JULY_AS_INT) {
            System.out.printf("Error! Invalid month.%n");
            System.exit(0);
        }

        // Validate today's day
        // Exit if day is < 1
        // Exit if day is > than number of days in current month
        if (day < 1 || month == JUNE_AS_INT && day > DAYS_IN_JUNE || month == JULY_AS_INT && day > DAYS_IN_JULY) {
            System.out.printf("Error! Invalid day.%n");
            System.exit(0);
        }

        // Collect time of sunrise
        System.out.printf("Enter the time of sunrise: [hh:mm]> ");
        userInput.useDelimiter("[:|\\s]+");
        sunriseHour = userInput.nextInt();
        sunriseMinute = userInput.nextInt();

        // Validate sunrise hour
        if (sunriseHour < 0 || sunriseHour >= HOURS_PER_DAY) {
            System.out.printf("Error! Invalid time. Hours must be between 0 and 23.");
            System.exit(0);
        }

        // Validate sunrise minute
        if (sunriseMinute < 0 || sunriseMinute >= MINUTES_PER_HOUR) {
            System.out.printf("Error! Invalid time. Minutes must be between 0 and 59.");
            System.exit(0);
        }

        // Calculate sunrise time
        sunriseTime = sunriseHour + 1.0 * sunriseMinute / MINUTES_PER_HOUR;

        // Collect time of sunset
        System.out.printf("Enter the time of sunset [hh:mm]> ");
        userInput.useDelimiter("[:|\\s]+");
        sunsetHour = userInput.nextInt();
        sunsetMinute = userInput.nextInt();

        // Validate sunset hour
        if (sunsetHour < 0 || sunsetHour >= HOURS_PER_DAY) {
            System.out.printf("Error! Invalid time. Hours must be between 0 and 23.");
            System.exit(0);
        }

        // Validate sunset minute
        if (sunsetMinute < 0 || sunsetMinute >= MINUTES_PER_HOUR) {
            System.out.printf("Error! Invalid time. Minutes must be between 0 and 59.");
            System.exit(0);
        }

        // Calculate sunset time
        sunsetTime = sunsetHour + 1.0 * sunsetMinute / MINUTES_PER_HOUR;

        // Validate the sunset is after sunrise
        if (sunriseTime >= sunsetTime) {
            System.out.printf("Error! Sunrise must be before sunset.");
            System.exit(0);
        }

        // Close the Scanner
        userInput.close();

        // Calculate sun hours
        // Sun hours = sunset - sunrise
        sunHours = sunsetTime - sunriseTime;

        // Calculate solar panel surface area
        // Total area = area per panel * number of panels
        solarPanelSurfaceAreaM2 = AREA_PER_PANEL_M2 * NUM_SOLAR_PANELS;

        // Calculate production
        // Production is radiation * efficiency * surface area * hours of sunshine
        // Production is limited to 290 W per panel
        productionKwh = (RADIATION_WH / WH_PER_KWH) * SOLAR_PANEL_EFFICIENCY * solarPanelSurfaceAreaM2 * sunHours;

        // Calculate profit
        profitSek = productionKwh * PRICE_SEK_PER_KWH;

        // Print the output
        System.out.printf("==========================================%n");
        System.out.printf("Sun hours: %.2f hours%n", sunHours);
        System.out.printf("The production on %d/%d is: %.2f kWh to a value of: SEK %.2f", day, month, productionKwh, profitSek);
    }
}
