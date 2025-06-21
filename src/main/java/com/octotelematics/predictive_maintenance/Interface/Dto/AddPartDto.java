package com.octotelematics.predictive_maintenance.Interface.Dto;

import lombok.Data;

@Data
public class AddPartDto {
    private String vehicleId;
    private String partSerial;
    private String brand;
    private String model;
    private int warningLimitKm;
    private int maxLimitKm;
}
