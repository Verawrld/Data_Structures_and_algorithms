import java.util.Scanner;

public class MovieTheater {
    private static final int ROWS = 5;
    private static final int COLS = 5;
    private static char[][] seats = new char[ROWS][COLS];

    public static void main(String[] args) {
        initializeSeats();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the Movie Theater");
            System.out.println("1. Reserve Seats");
            System.out.println("2. Cancel Seats");
            System.out.println("3. View Seating Chart");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reserveSeats(scanner);
                    break;
                case 2:
                    cancelSeats(scanner);
                    break;
                case 3:
                    viewSeatingChart();
                    break;
                case 4:
                    System.out.println("Thank you for using the Movie Theater reservation system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void initializeSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seats[i][j] = 'O'; // 'O' indicates the seat is available
            }
        }
    }

    private static void reserveSeats(Scanner scanner) {
        System.out.print("Enter row number (1-5): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter column number (1-5): ");
        int col = scanner.nextInt() - 1;

        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Invalid seat number. Please try again.");
        } else if (seats[row][col] == 'X') {
            System.out.println("Seat is already taken. Please choose another seat.");
        } else {
            seats[row][col] = 'X'; // 'X' indicates the seat is reserved
            System.out.println("Seat reserved successfully.");
        }
    }

    private static void cancelSeats(Scanner scanner) {
        System.out.print("Enter row number (1-5): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter column number (1-5): ");
        int col = scanner.nextInt() - 1;

        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Invalid seat number. Please try again.");
        } else if (seats[row][col] == 'O') {
            System.out.println("Seat is already available. No need to cancel.");
        } else {
            seats[row][col] = 'O'; // 'O' indicates the seat is available
            System.out.println("Seat cancellation successful.");
        }
    }

    private static void viewSeatingChart() {
        System.out.println("Seating Chart:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
}