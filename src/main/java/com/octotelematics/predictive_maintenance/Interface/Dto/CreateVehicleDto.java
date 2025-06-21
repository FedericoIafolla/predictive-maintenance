package com.octotelematics.predictive_maintenance.Interface.Dto;

import lombok.Data;

@Data
public class CreateVehicleDto {
    private String chassisNumber;
    private String plate;
    private String model;
    private String brand;
}