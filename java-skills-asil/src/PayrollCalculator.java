public class PayrollCalculator {

    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        if (hoursWorked < 0 || hourlyRate < 0) {
            System.out.println("Invalid input: negative values");
            return 0.0;
        }

        switch (employeeType.toUpperCase()) {
            case "FULL_TIME":
                if (hoursWorked <= 40) {
                    return hoursWorked * hourlyRate;
                } else {
                    double overtime = hoursWorked - 40;
                    return (40 * hourlyRate) + (overtime * hourlyRate * 1.5);
                }
            case "PART_TIME":
                if (hoursWorked > 25) {
                    hoursWorked = 25;
                }
                return hoursWorked * hourlyRate;
            case "CONTRACTOR":
                return hoursWorked * hourlyRate;
            case "INTERN":
                if (hoursWorked > 20) {
                    hoursWorked = 20;
                }
                return hoursWorked * (hourlyRate * 0.8);
            default:
                System.out.println("Unknown employee type: " + employeeType);
                return 0.0;
        }
    }

    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        return 0.0;
    }

    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
    }

    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        System.out.println("Pay for Alice (FULL_TIME, 45h, 25.0): " +
                calculateWeeklyPay("FULL_TIME", 45, 25.0));
    }
}
