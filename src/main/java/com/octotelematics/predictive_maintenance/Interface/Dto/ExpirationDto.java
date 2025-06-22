package com.octotelematics.predictive_maintenance.Interface.Dto;


import lombok.Getter;

import java.util.UUID;

@Getter
public class ExpirationDto {
    private int warningLimitKm;
    private int maxLimitKm;
    private String type;
    private UUID partSerialNumber;

    public int getWarningLimitKm() {
        return warningLimitKm;
    }

    public void setWarningLimitKm(int warningLimitKm) {
        this.warningLimitKm = warningLimitKm;
    }

    public int getMaxLimitKm() {
        return maxLimitKm;
    }

    public void setMaxLimitKm(int maxLimitKm) {
        this.maxLimitKm = maxLimitKm;
    }
}
