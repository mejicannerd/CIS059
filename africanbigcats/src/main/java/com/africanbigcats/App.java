package com.africanbigcats;

import java.util.*;

public class App {
    public static void main(String[] args) {

        Menu appMenu = new Menu();

        Character command = '_';
        LinkedList<Panthera> catList = new LinkedList<>();

        // loop until user quits
        while (command != 'q') {

            // print the menu
            appMenu.print();

            // get a command
            System.out.print("Enter a command: ");
            command = appMenu.getCommand();

            // execute a command
            appMenu.executeCommand(command, catList);

            // move the cats to a new position in africa
            appMenu.update(catList);

        }

    }
}