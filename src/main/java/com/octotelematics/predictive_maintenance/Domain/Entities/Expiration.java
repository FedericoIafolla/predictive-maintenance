package com.octotelematics.predictive_maintenance.Domain.Entities;

import lombok.Getter;

@Getter
public class Expiration {
    private ExpirationKey key;
    private int maxLimitKm;
    private int warningLimitKm;

    private Expiration(ExpirationKey key, int maxLimitKm, int warningLimitKm) {
        this.key = key;
        this.maxLimitKm = maxLimitKm;
        this.warningLimitKm = warningLimitKm;
    }

    public static Expiration create(ExpirationKey key, int warningLimitKm, int maxLimitKm) {
        return new Expiration(key, maxLimitKm, warningLimitKm);
    }

    public ExpirationKey getKey() {
        return key;
    }

    public int getMaxLimitKm() {
        return maxLimitKm;
    }

    public int getWarningLimitKm() {
        return warningLimitKm;
    }
}
