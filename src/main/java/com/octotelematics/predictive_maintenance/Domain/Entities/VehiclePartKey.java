package com.octotelematics.predictive_maintenance.Domain.Entities;

import lombok.Getter;

import java.util.UUID;

@Getter

public class VehiclePartKey {
    private UUID serialNumber;
    private UUID id;

    private VehiclePartKey(UUID id, UUID serialNumber) {
        this.serialNumber = serialNumber;
        this.id = id;
    }

    public static VehiclePartKey of(UUID id, UUID serialNumber) {
        return new VehiclePartKey(id, serialNumber);
    }

    public static VehiclePartKey createNew(UUID serialNumber) {
        return new VehiclePartKey(null, serialNumber);
    }
}