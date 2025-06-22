package com.octotelematics.predictive_maintenance.Domain.Entities;

import lombok.Getter;

@Getter
public class VehiclePart {
    private VehiclePartKey key;
    private VehicleKey vehicleKey;
    private String brand;
    private String model;
    private Expiration expiration;

    private VehiclePart(VehicleKey vehicleKey, VehiclePartKey key, String brand, String model, Expiration expiration) {
        this.vehicleKey = vehicleKey;
        this.key = key;
        this.brand = brand;
        this.model = model;
        this.expiration = expiration;
    }

    public static VehiclePart create(VehicleKey vehicleKey, VehiclePartKey key, String brand, String model, Expiration expiration) {
        return new VehiclePart(vehicleKey, key, brand, model, expiration);
    }

    public VehiclePartKey getKey() {
        return key;
    }

    public VehicleKey getVehicleKey() {
        return vehicleKey;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Expiration getExpiration() {
        return expiration;
    }

    public void updateExpiration(Expiration newExpiration) {
        this.expiration = newExpiration;
    }
}
