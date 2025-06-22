package com.octotelematics.predictive_maintenance.Domain.Entities;

import lombok.Getter;
import java.util.UUID;

@Getter
public class VehicleKey {
    private final String chassisNumber;
    private final String plate;
    private final UUID id;

    private VehicleKey(UUID id, String chassisNumber, String plate) {
        this.chassisNumber = chassisNumber;
        this.plate = plate;
        this.id = id;
    }

    public static VehicleKey of(UUID id, String chassisNumber, String plate) {
        return new VehicleKey(id, chassisNumber, plate);
    }

    public static VehicleKey createNew(String chassisNumber, String plate) {
        return new VehicleKey(UUID.randomUUID(), chassisNumber, plate);
    }

    public UUID getId() {
        return id;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public String getPlate() {
        return plate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        VehicleKey other = (VehicleKey) obj;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
