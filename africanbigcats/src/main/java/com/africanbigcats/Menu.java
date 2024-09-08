package com.africanbigcats;

import java.util.*;

/*
 * Menu class for the African Big Cat app
 */
public class Menu {

    // attributes
    private Scanner input;

    // constructor
    public Menu() {
        // initialize attributes
        this.input = new Scanner(System.in);
    }

    // prints the menu
    public void print() {
        printLine();
        System.out.println("African Big Cats App");
        printLine();

        printCommand('c', "[C]reates a big cat");
        printCommand('l', "[L]ists all big cats");
        printCommand('d', "[D]eletes a big cat");
        printCommand('f', "[F]inds a cat"); // New find command
        printCommand('q', "[Q]uits");

        printLine();
    }

    private static void printLine() {
        System.out.println("----------------------------------------------------------");
    }

    private static void printCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    // get first character from input
    public Character getCommand() {
        Character command = '_';
        String rawInput = input.nextLine();

        if (rawInput.length() > 0) {
            rawInput = rawInput.toLowerCase();
            command = rawInput.charAt(0);
        }

        return command;
    }

    // command switch
    public Boolean executeCommand(Character command, LinkedList<Panthera> catList) {
        Boolean success = true;

        switch (command) {
            case 'c':
                executeCreate(catList);
                break;
            case 'l':
                executeList(catList);
                break;
            case 'd':
                executeDelete(catList);
                break;
            case 'f':
                executeFind(catList); // New find functionality
                break;
            case 'q':
                executeQuit();
                break;
            default:
                System.out.println("ERROR: Unknown command");
                success = false;
        }

        return success;
    }

    // New method to find a cat
    public void executeFind(LinkedList<Panthera> catList) {
        System.out.println();
        System.out.print("Enter a name or part of a name to find cats: ");
        String query = input.nextLine().toLowerCase();
        System.out.println();

        boolean found = false;
        for (Panthera cat : catList) {
            if (cat.getName().toLowerCase().contains(query)) {
                System.out.println("Found: " + cat);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No cats found matching '" + query + "'");
        }
    }

    // delete a big cat based on name
    public void executeDelete(LinkedList<Panthera> catList) {
        System.out.println();
        System.out.print("Enter the name of the big cat to delete: ");
        String name = input.nextLine();
        System.out.println();

        boolean found = false;
        for (Iterator<Panthera> iterator = catList.iterator(); iterator.hasNext();) {
            Panthera cat = iterator.next();
            if (cat.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                found = true;
                System.out.println(name + " has been deleted from the list.");
                break;
            }
        }

        if (!found) {
            System.out.println("No cat found with the name " + name);
        }
    }

    // update the position of all the cats
    public void update(LinkedList<Panthera> catList) {
        for (Panthera cat : catList) {
            cat.move();
        }
    }

    // quit the app
    public void executeQuit() {
        input.close();
        System.out.println();
        printLine();
        System.out.println("Thank you for using the African Big Cats App!");
        printLine();
        System.out.println();
    }

    public Panthera getNewCat(String name, int catType) {
        Panthera result;
        if (catType == 1) {
            result = new Tiger(name);
        } else if (catType == 2) {
            result = new Lion(name);
        } else {
            result = new Jaguar(name);
        }
        return result;
    }

    // create a cat, if it's unique
    public void executeCreate(LinkedList<Panthera> catList) {
        System.out.println();
        System.out.print("Enter a name for the big cat to create: ");
        String name = input.nextLine();
        System.out.println();

        // Check for duplicates
        for (Panthera cat : catList) {
            if (cat.getName().equalsIgnoreCase(name)) {
                System.out.println("A cat with the name " + name + " already exists.");
                return;
            }
        }

        System.out.print("Enter the type of big cat (1 for Tiger, 2 for Lion, 3 for Jaguar): ");
        int catType = input.nextInt();
        input.nextLine(); // Consume newline
        System.out.println();

        // Validate input
        if (catType < 1 || catType > 3) {
            System.out.println("Invalid choice. Please enter 1 for Tiger, 2 for Lion, or 3 for Jaguar.");
            return;
        }

        Panthera cat = getNewCat(name, catType);
        catList.add(cat);
        System.out.println(name + " has been added.");
    }

    // list all big cats
    public void executeList(LinkedList<Panthera> catList) {
        System.out.println();
        printLine();
        System.out.println("African Big Cat List");
        printLine();

        if (catList.size() > 0) {
            for (Panthera cat : catList) {
                System.out.println(cat);
            }
        } else {
            System.out.println("There are no African Big Cats. :(");
        }

        System.out.println();
    }
}
