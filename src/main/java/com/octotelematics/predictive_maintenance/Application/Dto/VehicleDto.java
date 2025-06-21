package com.octotelematics.predictive_maintenance.Application.Dto;

import lombok.Value;
import java.util.UUID;

@Value
public class VehicleDto {
    UUID id;
    UUID userId;
    String chassisNumber;
    String plate;
    String model;
    String brand;
}