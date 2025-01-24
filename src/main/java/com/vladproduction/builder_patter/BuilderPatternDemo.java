package com.vladproduction.builder_patter;

// Example usage
public class BuilderPatternDemo {
    public static void main(String[] args) {
        House house = new House.Builder(3, 2)  // Required fields
                .color("Blue")                 // Optional field
                .hasGarage(true)               // Optional field
                .build();                      // Create the object

        System.out.println(house);
    }
}
