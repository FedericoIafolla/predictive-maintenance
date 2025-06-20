package com.octotelematics.predictive_maintenance.Domain.Entities;

public class VehiclePart {
    VehiclePartKey key;
    private VehicleKey vehicleKey;
    private String brand;
    private String model;
    private Expiration expiration;

    public void updateExpiration (Expiration newExpiration) {
        this.expiration = newExpiration;
    }


    private VehiclePart(VehicleKey vehicleKey, VehiclePartKey key, String brand, String model,Expiration expiration) {
        this.vehicleKey = vehicleKey;
        this.key = key;
        this.brand = brand;
        this.model = model;
        this.expiration = expiration;
    }

    public static VehiclePart create(VehicleKey vehicleKey, VehiclePartKey key, String brand, String model, Expiration expiration) {
        return new VehiclePart(vehicleKey, key, brand, model, expiration);
    }
}