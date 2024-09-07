package com.chavvicalc;

import java.util.*;

public class App {

    // Initialize variables A and B to 0; these represent the two numbers used for
    // calculations.
    private static float A = 0;
    private static float B = 0;

    public static void main(String[] args) {
        // Create a scanner object to read user input from the console
        Scanner scan = new Scanner(System.in);
        Character command = '_'; // Initialize command variable with a placeholder value

        // Loop continuously until the user decides to quit the application
        while (command != 'q') {
            printMenu(); // Display the command menu
            System.out.print("Enter a command: ");
            command = menuGetCommand(scan); // Get the user's input command

            executeCommand(scan, command); // Execute the corresponding action based on the user's command
        }

        // Close the scanner to free up resources
        scan.close();
    }

    // Print a decorative line for the menu
    private static void printMenuLine() {
        System.out.println("----------------------------------------------------------");
    }

    // Print a specific command and its description in the menu
    private static void printMenuCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    // Display the menu options to the user, including the current values of A and B
    public static void printMenu() {
        printMenuLine();
        System.out.println("ChavviCalc"); // Title of the application
        printMenuLine();

        // Display the current values of A and B formatted to 3 decimal places
        System.out.printf("A = %.3f\tB = %.3f\n", A, B);
        printMenuCommand('a', "Set A"); // Option to set value for A
        printMenuCommand('b', "Set B"); // Option to set value for B
        printMenuCommand('+', "A = A + B"); // Option to add B to A
        printMenuCommand('-', "A = A - B"); // Option to subtract B from A
        printMenuCommand('*', "A = A * B"); // Option to multiply A by B
        printMenuCommand('/', "A = A / B"); // Option to divide A by B
        printMenuCommand('c', "Clear A and B"); // Option to reset A and B to 0
        printMenuCommand('q', "Quit"); // Option to quit the application

        printMenuLine();
    }

    // Retrieve the first character from user input to determine the selected
    // command
    private static Character menuGetCommand(Scanner scan) {
        Character command = '_'; // Initialize command variable with a placeholder

        // Read the user's input line and convert to lowercase
        String rawInput = scan.nextLine();

        if (rawInput.length() > 0) {
            rawInput = rawInput.toLowerCase(); // Convert input to lowercase for consistency
            command = rawInput.charAt(0); // Get the first character of the input
        }

        return command; // Return the extracted command
    }

    // Execute the user's selected command and perform the appropriate calculation
    // or action
    private static Boolean executeCommand(Scanner scan, Character command) {
        Boolean success = true; // Initialize success status as true

        // Determine which command was selected and execute the corresponding action
        switch (command) {
            case 'a':
                A = getNumberFromUser(scan, "Enter a value for A: "); // Prompt user for a new value for A
                break;
            case 'b':
                B = getNumberFromUser(scan, "Enter a value for B: "); // Prompt user for a new value for B
                break;
            case '+':
                A = A + B; // Add B to A
                break;
            case '-':
                A = A - B; // Subtract B from A
                break;
            case '*':
                A = A * B; // Multiply A by B
                break;
            case '/':
                if (B != 0) {
                    A = A / B; // Divide A by B, if B is not zero
                } else {
                    System.out.println("ERROR: Cannot divide by zero."); // Handle division by zero error
                    success = false; // Set success status to false due to error
                }
                break;
            case 'c':
                A = 0;
                B = 0; // Reset A and B to 0
                break;
            case 'q':
                System.out.println("Thank you for using Chavvi Calc"); // Exit message
                break;
            default:
                System.out.println("ERROR: Unknown command"); // Handle unknown commands
                success = false; // Set success status to false due to error
        }

        return success; // Return the success status of the command execution
    }

    // Prompt the user for a valid floating-point number and return the number
    private static float getNumberFromUser(Scanner scan, String prompt) {
        float number = 0; // Initialize number variable
        boolean validInput = false; // Flag to check for valid input

        // Loop until the user enters a valid floating-point number
        while (!validInput) {
            System.out.print(prompt); // Display the prompt to the user
            String input = scan.nextLine(); // Read the user's input

            try {
                number = Float.parseFloat(input); // Attempt to parse the input as a float
                validInput = true; // If parsing succeeds, mark input as valid
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid number. Please enter a valid floating-point number."); // Handle
                                                                                                          // invalid
                                                                                                          // input
            }
        }

        return number; // Return the valid floating-point number
    }
}
