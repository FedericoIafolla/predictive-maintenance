package com.octotelematics.predictive_maintenance.Domain.Entities;

import java.util.UUID;

public class UserKey {
    private UUID serialNumber;
    private String taxId;

    private UserKey(UUID serialNumber, String taxId) {
        this.serialNumber = serialNumber;
        this.taxId = taxId;
    }

    public static UserKey of(UUID serialNumber, String taxId) {
        return new UserKey(serialNumber, taxId);
    }

    public static UserKey createNew(String taxId) {
        return new UserKey(null, taxId);
    }

    public UUID getSerialNumber() {
        return serialNumber;
    }

    public String getTaxId() {
        return taxId;
    }
}
