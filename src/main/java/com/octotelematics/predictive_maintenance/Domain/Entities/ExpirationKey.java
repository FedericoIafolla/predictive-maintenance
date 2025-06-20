package com.octotelematics.predictive_maintenance.Domain.Entities;

import lombok.Getter;

import java.util.UUID;

@Getter

public class ExpirationKey {
    private UUID id;
    private String type;
    private String piece;

    private ExpirationKey(UUID id, String type, String piece) {
        this.id = id;
        this.type = type;
        this.piece = piece;
    }

    public static ExpirationKey of(UUID id, String type, String piece) {
        return new ExpirationKey(id, type, piece);
    }

    public static ExpirationKey createNew(String type, String piece) {
        return new ExpirationKey(null, type, piece);
    }
}