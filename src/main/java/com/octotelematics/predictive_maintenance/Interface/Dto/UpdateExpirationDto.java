package com.octotelematics.predictive_maintenance.Interface.Dto;

import lombok.Data;

@Data
public class UpdateExpirationDto {
    private String vehicleId;
    private String partSerial;
    private int warningLimitKm;
    private int maxLimitKm;
}
