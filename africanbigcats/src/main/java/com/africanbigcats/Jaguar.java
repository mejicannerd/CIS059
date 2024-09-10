package com.africanbigcats;

/*
 * Jaguar class that extends Panthera to model specific characteristics of jaguars
 */
public class Jaguar extends Panthera {

    // Attribute to specify if the Jaguar sleeps in trees
    private boolean sleepsInTrees;

    // Constructor
    public Jaguar(String name) {
        // Call the super-class (parent) to instantiate it
        super(name);

        // Initialize attributes specific to the Jaguar
        this.setSpecies("jaguar");
        this.sleepsInTrees = true; // Jaguars sleep in trees by default
    }

    // Overrides the toString method to include specific attributes for Jaguar
    @Override
    public String toString() {
        String s;

        // Since the object representation is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + getName(); // Use the getter method from Panthera
        s += ", ";
        s += "species: " + species();
        s += ", ";
        s += "longitude: " + longitude();
        s += ", ";
        s += "latitude: " + latitude();
        s += ", ";
        s += "weight: " + getWeight(); // Display the weight using getter method from Panthera
        s += ", ";
        s += "speed: " + speed(); // Display the current speed using the speed() method from Panthera
        s += ", ";
        s += "fur: " + fur(); // This will call the fur method specific to Jaguar
        s += ", ";
        s += "sleepsInTrees: " + sleepsInTrees; // Include the sleepsInTrees attribute
        s += " }";

        return s;
    }

    // Method to return the characteristic fur description of Jaguars
    public String fur() {
        return "spots";
    }
}
