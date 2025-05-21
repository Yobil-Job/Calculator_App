package CalculatorApp;

import java.util.Scanner;

class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }
}

public class CalculatorApp {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean runAgain = true;

        while (runAgain) {
            printMenu();
            int choice = getUserChoice();

            if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }

            double num1 = getDoubleInput("Enter the first number: ");
            double num2 = getDoubleInput("Enter the second number: ");

            performOperation(choice, num1, num2);
            runAgain = askToContinue();
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Simple Calculator ===");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
        System.out.print("Choose an option (1-5): ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number (1-5): ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static void performOperation(int choice, double a, double b) {
        try {
            double result;
            switch (choice) {
                case 1 -> result = Calculator.add(a, b);
                case 2 -> result = Calculator.subtract(a, b);
                case 3 -> result = Calculator.multiply(a, b);
                case 4 -> result = Calculator.divide(a, b);
                default -> throw new IllegalArgumentException("Unknown operation.");
            }
            System.out.printf("Result: %.2f%n", result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean askToContinue() {
        System.out.print("Do you want to perform another calculation? (y/n): ");
        String input = scanner.next().trim().toLowerCase();
        return input.equals("y");
    }
}
