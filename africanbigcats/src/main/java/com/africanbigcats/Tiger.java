package com.africanbigcats;

/*
 * Tiger class that extends Panthera to model specific characteristics of tigers
 */
public class Tiger extends Panthera {

    // Constructor
    public Tiger(String name) {
        // Call the super-class (parent) to instantiate it
        super(name);

        // Initialize attributes specific to the Tiger
        this.setSpecies("tiger");
    }

    // Overrides the toString method to include specific attributes for Tiger
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
        s += "fur: " + fur(); // This will call the fur method specific to Tiger
        s += " }";

        return s;
    }

    // Method to return the characteristic fur description of Tigers
    public String fur() {
        return "stripes";
    }
}
