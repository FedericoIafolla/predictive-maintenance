package com.octotelematics.predictive_maintenance.Domain.Entities;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ExpirationKey {
    private UUID id;
    private String gianni;

    private ExpirationKey(UUID id, String type) {
        this.id = id;
        this.gianni = type;
    }

    public static ExpirationKey of(UUID id, String type) {
        return new ExpirationKey(id, type);
    }

    public static ExpirationKey createNew(String type) {
        return new ExpirationKey(UUID.randomUUID(), type);
    }
}
