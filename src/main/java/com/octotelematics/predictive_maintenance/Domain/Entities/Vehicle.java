package com.octotelematics.predictive_maintenance.Domain.Entities;

public class Vehicle {
    private VehicleKey key;
    private String model;
    private String brand;

    private Vehicle(VehicleKey key, String model, String brand) {
        this.key = key;
        this.model = model;
        this.brand = brand;
    }

    public static Vehicle create(VehicleKey key, String model, String brand) {
        return new Vehicle(key, model, brand);
    }
}
