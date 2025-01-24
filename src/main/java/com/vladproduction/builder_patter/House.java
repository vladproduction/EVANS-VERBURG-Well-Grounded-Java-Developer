package com.vladproduction.builder_patter;

public class House {
    private final int rooms; // required
    private final int bathrooms; // required
    private final String color; // optional
    private final boolean hasGarage; // optional

    // Private constructor to enforce object creation through the Builder
    private House(Builder builder) {
        this.rooms = builder.rooms;
        this.bathrooms = builder.bathrooms;
        this.color = builder.color;
        this.hasGarage = builder.hasGarage;
    }

    // Static inner class - Builder
    public static class Builder {
        private final int rooms; // required
        private final int bathrooms; // required
        private String color; // default: null
        private boolean hasGarage; // default: false

        // Builder constructor for required fields
        public Builder(int rooms, int bathrooms) {
            this.rooms = rooms;
            this.bathrooms = bathrooms;
        }

        // Method to set optional field: color
        public Builder color(String color) {
            this.color = color;
            return this;
        }

        // Method to set optional field: hasGarage
        public Builder hasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        // Method to build the House object
        public House build() {
            return new House(this);
        }
    }

    // Getters for immutable fields
    public int getRooms() {
        return rooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public String getColor() {
        return color;
    }

    public boolean hasGarage() {
        return hasGarage;
    }

    @Override
    public String toString() {
        return "House{" +
                "rooms=" + rooms +
                ", bathrooms=" + bathrooms +
                ", color='" + color + '\'' +
                ", hasGarage=" + hasGarage +
                '}';
    }
}

