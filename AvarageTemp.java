import java.util.Scanner;

public class AvarageTemp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Print an empty line before the output starts
        System.out.println();

        // Step 1: Take an input from the user (number of temperature values)
        System.out.print("Enter the number of temperature values: ");
        int n = scanner.nextInt();

        // Step 2: Prompt the user to enter all the temperature values
        double[] temperatures = new double[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter temperature " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
            sum += temperatures[i];
        }

        // Step 3: Calculate the average temperature
        double average = sum / n;
        System.out.println("Average temperature: " + average);

        // Step 4: Determine how many temperatures are above the average
        int countAboveAverage = 0;
        for (double temp : temperatures) {
            if (temp > average) {
                countAboveAverage++;
                // Close the scanner to avoid resource leak
                scanner.close();
            }
        }

        System.out.println("Number of days above average temperature: " + countAboveAverage);
    }
}