package PracticeAssignments;
/**
* Program description:
* 1. Calculate charging time for an electric car
* 2. Define constants
* 3. Inputs of current (A) and voltage (V) are given
* 4a. For 230V: charging power (W) = A * V
* 4b. For 400V: charging power (W) = A * V * square_root(3)
* 5. 1kW = 1000W
* 6. Charging time (h) =  battery capacity / charging power
* 7. Calculations are manually rounded to a maximum of two decimal places
* 8. Print the output in a table
*
* @author David Browning (davbro-4)
*/

// 1. Calculate charging time for an electric car
class PracticeAssignment01 {

    // 2. Definte constants
    static final double BATTERY_CAPACITY_KWH = 35.8;
    static final int W_PER_KW = 1000;
    static final double ROUNDING_SCALE = 100.0;
    static final int TEN_AMPS = 10;
    static final int SIXTEEN_AMPS = 16;
    static final int THIRTY_TWO_AMPS = 32;
    static final int TWO_HUNDRED_THIRTY_VOLTS = 230;
    static final int FOUR_HUNDRED_VOLTS = 400;

    public static void main(final String[] args) {

        // 3. Inputs of current (A) and voltage (V) are given
        double amperage1 = TEN_AMPS;
        double amperage2 = SIXTEEN_AMPS;
        double amperage3 = TEN_AMPS;
        double amperage4 = SIXTEEN_AMPS;
        double amperage5 = THIRTY_TWO_AMPS;
        double voltage1 = TWO_HUNDRED_THIRTY_VOLTS;
        double voltage2 = TWO_HUNDRED_THIRTY_VOLTS;
        double voltage3 = FOUR_HUNDRED_VOLTS;
        double voltage4 = FOUR_HUNDRED_VOLTS;
        double voltage5 = FOUR_HUNDRED_VOLTS;

        // 4a. For 230V: charging power (W) = A * V
        double chargingPowerW1 = amperage1 * voltage1;
        double chargingPowerW2 = amperage2 * voltage2;

        // 4b. For 400V: charging power (W) = A * V * square_root(3)
        double chargingPowerW3 = amperage3 * voltage3 * Math.sqrt(3.0);
        double chargingPowerW4 = amperage4 * voltage4 * Math.sqrt(3.0);
        double chargingPowerW5 = amperage5 * voltage5 * Math.sqrt(3.0);

        // 5. 1kW = 1000W
        double chargingPowerKw1 = chargingPowerW1 / W_PER_KW;
        double chargingPowerKw2 = chargingPowerW2 / W_PER_KW;
        double chargingPowerKw3 = chargingPowerW3 / W_PER_KW;
        double chargingPowerKw4 = chargingPowerW4 / W_PER_KW;
        double chargingPowerKw5 = chargingPowerW5 / W_PER_KW;

        // 6. Charging time = battery capacity (kWH) / charging power (kW)
        double chargingTimeH1 = BATTERY_CAPACITY_KWH / chargingPowerKw1;
        double chargingTimeH2 = BATTERY_CAPACITY_KWH / chargingPowerKw2;
        double chargingTimeH3 = BATTERY_CAPACITY_KWH / chargingPowerKw3;
        double chargingTimeH4 = BATTERY_CAPACITY_KWH / chargingPowerKw4;
        double chargingTimeH5 = BATTERY_CAPACITY_KWH / chargingPowerKw5;

        // 7. Calculations are rounded to a max of two decimal places
        chargingPowerKw1 =
            Math.round(chargingPowerKw1 * ROUNDING_SCALE) / ROUNDING_SCALE;
        chargingPowerKw2 =
            Math.round(chargingPowerKw2 * ROUNDING_SCALE) / ROUNDING_SCALE;
        chargingPowerKw3 =
            Math.round(chargingPowerKw3 * ROUNDING_SCALE) / ROUNDING_SCALE;
        chargingPowerKw4 =
            Math.round(chargingPowerKw4 * ROUNDING_SCALE) / ROUNDING_SCALE;
        chargingPowerKw5 =
            Math.round(chargingPowerKw5 * ROUNDING_SCALE) / ROUNDING_SCALE;
        chargingTimeH1 =
            Math.round(chargingTimeH1 * ROUNDING_SCALE) / ROUNDING_SCALE;
        chargingTimeH2 =
            Math.round(chargingTimeH2 * ROUNDING_SCALE) / ROUNDING_SCALE;
        chargingTimeH3 =
            Math.round(chargingTimeH3 * ROUNDING_SCALE) / ROUNDING_SCALE;
        chargingTimeH4 =
            Math.round(chargingTimeH4 * ROUNDING_SCALE) / ROUNDING_SCALE;
        chargingTimeH5 =
            Math.round(chargingTimeH5 * ROUNDING_SCALE) / ROUNDING_SCALE;

        // 8. Print the output in a table
        System.out.printf("Battery: %.1f (kwh)\n", BATTERY_CAPACITY_KWH);
        System.out.printf("%-20s %-20s %-20s %-20s %n",
            "Current(A)", "Voltage(V)", "Charging Power(kW)",
            "Charging Time(h)");
        System.out.printf("%-20.1f %-20.1f %-20.2f %-20.2f %n",
            amperage1, voltage1, chargingPowerKw1, chargingTimeH1);
        System.out.printf("%-20.1f %-20.1f %-20.2f %-20.2f %n",
            amperage2, voltage2, chargingPowerKw2, chargingTimeH2);
        System.out.printf("%-20.1f %-20.1f %-20.2f %-20.2f %n",
            amperage3, voltage3, chargingPowerKw3, chargingTimeH3);
        System.out.printf("%-20.1f %-20.1f %-20.2f %-20.2f %n",
            amperage4, voltage4, chargingPowerKw4, chargingTimeH4);
        System.out.printf("%-20.1f %-20.1f %-20.2f %-20.2f %n",
            amperage5, voltage5, chargingPowerKw5, chargingTimeH5);
    }
}
