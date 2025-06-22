package com.octotelematics.predictive_maintenance.Domain.Entities;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ExpirationKey {
    private UUID id;
    private String type;

    private ExpirationKey(UUID id, String type) {
        this.id = id;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public static ExpirationKey of(UUID id, String type) {
        return new ExpirationKey(id, type);
    }

    public static ExpirationKey createNew(String type) {
        return new ExpirationKey(UUID.randomUUID(), type);
    }

    public String gianni() {
        return type;
    }
}
