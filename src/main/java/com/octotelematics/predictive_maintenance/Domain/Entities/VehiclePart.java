package com.octotelematics.predictive_maintenance.Domain.Entities;

public class VehiclePart {
    VehiclePartKey key;
    private VehicleKey vehicleKey;
    private String brand;
    private String model;


    private VehiclePart(VehicleKey vehicleKey, VehiclePartKey key, String brand, String model) {
        this.vehicleKey = vehicleKey;
        this.key = key;
        this.brand = brand;
        this.model = model;
    }

    public static VehiclePart create(VehicleKey vehicleKey, VehiclePartKey key, String brand, String model) {
        return new VehiclePart(vehicleKey, key, brand, model);
    }
}