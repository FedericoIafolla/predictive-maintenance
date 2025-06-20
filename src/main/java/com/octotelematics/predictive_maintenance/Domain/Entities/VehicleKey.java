package com.octotelematics.predictive_maintenance.Domain.Entities;

import lombok.Getter;

import java.util.UUID;

@Getter

public class VehicleKey {
    private VehicleKey key;
    private String chassisNumber;
    private String plate;
    private UUID id;

    private VehicleKey(UUID id, String chassisNumber, String plate) {
        this.chassisNumber = chassisNumber;
        this.plate = plate;
        this.id = id;
    }

    public static VehicleKey of(UUID id, String chassisNumber, String plate) {
        return new VehicleKey(id, chassisNumber, plate);
    }

    public static VehicleKey createNew(String chassisNumber, String plate) {
        return new VehicleKey(null, chassisNumber, plate);
    }
}