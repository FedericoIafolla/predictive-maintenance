package com.octotelematics.predictive_maintenance.Domain.Entities;

import lombok.Getter;

import java.util.UUID;

@Getter

public class UserKey {
    private UUID SerialNumber;
    private String TaxId;

    private UserKey(UUID serialNumber, String taxId) {
        SerialNumber = serialNumber;
        TaxId = taxId;
    }

    public static UserKey of(UUID serialNumber, String taxId) {
        return new UserKey(serialNumber, taxId);
    }

    public static UserKey CreateNew(String taxId)  {
    return new UserKey(null, taxId);
    }
}
