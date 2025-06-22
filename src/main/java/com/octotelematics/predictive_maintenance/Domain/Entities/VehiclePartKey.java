package com.octotelematics.predictive_maintenance.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class VehiclePartKey {
    @JsonProperty
    private UUID serialNumber;

    @JsonProperty
    private UUID id;

    public VehiclePartKey(UUID id, UUID serialNumber) {
        this.serialNumber = serialNumber;
        this.id = id;
    }

    public static VehiclePartKey of(UUID id, UUID serialNumber) {
        return new VehiclePartKey(id, serialNumber);
    }

    public static VehiclePartKey createNew(UUID serialNumber) {
        return new VehiclePartKey(null, serialNumber);
    }

    public UUID getSerialNumber() {
        return serialNumber;
    }
}
