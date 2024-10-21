import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepCalculating = true;

        while (keepCalculating) {
            System.out.println("Enter first number:");
            double num1 = getValidNumber(scanner);

            System.out.println("Enter second number:");
            double num2 = getValidNumber(scanner);

            System.out.println("Select operation: +, -, *, /");
            char operation = scanner.next().charAt(0);

            double result;

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error! Division by zero.");
                        continue; // Go to the next iteration
                    }
                    break;
                default:
                    System.out.println("Invalid operation!");
                    continue; // Go to the next iteration
            }

            System.out.printf("Result: %.2f%n", result);
            System.out.println("Do you want to perform another calculation? (yes/no)");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                keepCalculating = false;
            }
        }

        System.out.println("Thank you for using the calculator!");
        scanner.close();
    }

    private static double getValidNumber(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Invalid input! Please enter a number:");
                scanner.next(); // Clear invalid input
            }
        }
    }
}
