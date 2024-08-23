package com.chavvicalc;

import java.util.*;

public class App {

    // Initialize A and B to 0
    private static float A = 0;
    private static float B = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Character command = '_';

        // loop until user quits
        while (command != 'q') {
            printMenu();
            System.out.print("Enter a command: ");
            command = menuGetCommand(scan);

            executeCommand(scan, command);
        }

        scan.close();
    }

    // menu functions
    private static void printMenuLine() {
        System.out.println(
                "----------------------------------------------------------");
    }

    private static void printMenuCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    // prints the menu
    public static void printMenu() {
        printMenuLine();
        System.out.println("ChavviCalc");
        printMenuLine();

        System.out.printf("A = %.3f\tB = %.3f\n", A, B);
        printMenuCommand('a', "Set A");
        printMenuCommand('b', "Set B");
        printMenuCommand('+', "A = A + B");
        printMenuCommand('-', "A = A - B");
        printMenuCommand('*', "A = A * B");
        printMenuCommand('/', "A = A / B");
        printMenuCommand('c', "Clear A and B");
        printMenuCommand('q', "Quit");

        printMenuLine();
    }

    // get first character from input
    private static Character menuGetCommand(Scanner scan) {
        Character command = '_';

        String rawInput = scan.nextLine();

        if (rawInput.length() > 0) {
            rawInput = rawInput.toLowerCase();
            command = rawInput.charAt(0);
        }

        return command;
    }

    // calculator functions
    private static Boolean executeCommand(Scanner scan, Character command) {
        Boolean success = true;

        switch (command) {
            case 'a':
                A = getNumberFromUser(scan, "Enter a value for A: ");
                break;
            case 'b':
                B = getNumberFromUser(scan, "Enter a value for B: ");
                break;
            case '+':
                A = A + B;
                break;
            case '-':
                A = A - B;
                break;
            case '*':
                A = A * B;
                break;
            case '/':
                if (B != 0) {
                    A = A / B;
                } else {
                    System.out.println("ERROR: Cannot divide by zero.");
                    success = false;
                }
                break;
            case 'c':
                A = 0;
                B = 0;
                break;
            case 'q':
                System.out.println("Thank you for using Chavvi Calc");
                break;
            default:
                System.out.println("ERROR: Unknown command");
                success = false;
        }

        return success;
    }

    // Get a valid number from the user
    private static float getNumberFromUser(Scanner scan, String prompt) {
        float number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            String input = scan.nextLine();

            try {
                number = Float.parseFloat(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid number. Please enter a valid floating-point number.");
            }
        }

        return number;
    }
}