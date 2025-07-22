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
        double tax;

        if (grossPay <= 500) {
            tax = grossPay * 0.10;
        } else if (grossPay <= 1000) {
            tax = grossPay * 0.15;
        } else if (grossPay <= 2000) {
            tax = grossPay * 0.20;
        } else {
            tax = grossPay * 0.25;
        }

        if (hasHealthInsurance) {
            tax -= 50;
        }

        return Math.max(tax, 0);
    }

    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        int len = Math.min(Math.min(employeeTypes.length, hours.length), Math.min(rates.length, names.length));
        double[] grossPays = new double[len];
        double totalPay = 0;
        int overtimeCount = 0;
        int highestIndex = 0;
        int lowestIndex = 0;

        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-10s %-12s %-8s %-10s %-10s%n", "Name", "Type", "Hours", "Gross Pay", "Tax");
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < len; i++) {
            double pay = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(pay, true);
            grossPays[i] = pay;
            totalPay += pay;

            if (hours[i] > 40) {
                overtimeCount++;
            }

            if (pay > grossPays[highestIndex]) highestIndex = i;
            if (pay < grossPays[lowestIndex]) lowestIndex = i;

            System.out.printf("%-10s %-12s %-8.2f %-10.2f %-10.2f%n", names[i], employeeTypes[i], hours[i], pay, tax);
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("Highest Paid: " + names[highestIndex] + " ($" + grossPays[highestIndex] + ")");
        System.out.println("Lowest Paid: " + names[lowestIndex] + " ($" + grossPays[lowestIndex] + ")");
        System.out.printf("Average Pay: %.2f%n", totalPay / len);
        System.out.println("Employees with Overtime (> 40 hrs): " + overtimeCount);
    }

    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        processPayroll(types, hours, rates, names);
    }
}
