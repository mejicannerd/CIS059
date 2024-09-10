package com.africanbigcats;

import java.util.Random;

/*
 * Panthera class that extends PantheraGPS and adds additional features
 */
public class Panthera extends PantheraGPS {

    private int weight; // Weight attribute in pounds
    private Random speedRandom; // Random generator for speed

    // Constructor
    public Panthera(String name) {
        // Call the super-class (parent) to instantiate it
        super(name);

        // Initialize attributes
        this.setSpecies("panthera");

        // Initialize weight with a random value between 10 and 600 pounds
        Random rand = new Random();
        this.weight = 10 + rand.nextInt(591); // 591 ensures the range is [10, 600]

        // Initialize the random number generator for speed
        this.speedRandom = new Random();
    }

    // Getter for name
    public String getName() {
        return this.name();
    }

    // Getter for weight
    public int getWeight() {
        return this.weight;
    }

    // Method to get the current speed
    public float speed() {
        // Generate a random speed between 0 and 50 miles per hour
        return this.speedRandom.nextFloat() * maxSpeed;
    }

    // Serializes attributes into a string
    @Override
    public String toString() {
        String s;

        // Since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + this.getName(); // Using getName() method
        s += ", ";
        s += "species: " + this.species();
        s += ", ";
        s += "longitude: " + this.longitude();
        s += ", ";
        s += "latitude: " + this.latitude();
        s += ", ";
        s += "weight: " + this.getWeight(); // Display the weight
        s += ", ";
        s += "speed: " + this.speed(); // Display the current speed
        s += " }";

        return s;
    }
}
