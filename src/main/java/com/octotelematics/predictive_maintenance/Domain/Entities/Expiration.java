package com.octotelematics.predictive_maintenance.Domain.Entities;

public class Expiration {
    ExpirationKey key;
    private int maxLimitKm;
    private int warningLimitKm;

    private Expiration(ExpirationKey key, int maxLimitKm, int warningLimitKm) {
        this.key = key;
        this.maxLimitKm = maxLimitKm;
        this.warningLimitKm = warningLimitKm;
    }

    public static Expiration create(ExpirationKey key, int warningLimitKm, int maxLimitKm) {
        return new Expiration(key, warningLimitKm, maxLimitKm);
    }
}