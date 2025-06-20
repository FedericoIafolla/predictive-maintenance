package com.octotelematics.predictive_maintenance.Domain.Entities;

import lombok.Getter;

import java.util.UUID;

@Getter

public class ExpirationKey {
    private UUID id;
    private String type;
    private VehiclePartKey piece;

    private ExpirationKey(UUID id, String type, VehiclePartKey piece) {
        this.id = id;
        this.type = type;
        this.piece = piece;
    }

    public static ExpirationKey of(UUID id, String type, VehiclePartKey piece) {
        return new ExpirationKey(id, type, piece);
    }

    public static ExpirationKey createNew(String type, VehiclePartKey piece) {
        return new ExpirationKey(null, type, piece);
    }
}