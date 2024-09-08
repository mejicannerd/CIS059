package com.africanbigcats;

/*
 * Panthera base class that simulates GPS information
 */
public class Panthera extends PantheraGPS {

    /*
     * TIP:
     * Students will need to add additional attributes and methods to complete this
     * classes
     * implementation.
     */

    // constructor
    public Panthera(String name) {
        // call the super-class (parent) to instantiate it
        super(name);

        // initialize attributes
        this.setSpecies("panthera");
    }

    // Getter for name
    public String getName() {
        return this.name();
    }

    // Serializes attributes into a string
    @Override // override superclass method
    public String toString() {
        String s;

        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + this.getName(); // using getName() method
        s += ", ";
        s += "species: " + this.species();
        s += ", ";
        s += "longitude: " + this.longitude();
        s += ", ";
        s += "latitude: " + this.latitude();
        s += " }";

        return s;
    }
}