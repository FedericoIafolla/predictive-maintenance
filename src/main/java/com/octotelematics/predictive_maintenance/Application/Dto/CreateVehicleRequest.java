package com.octotelematics.predictive_maintenance.Application.Dto;

import lombok.Value;
import java.util.UUID;

@Value
public class CreateVehicleRequest {
    UUID userId;
    String chassisNumber;
    String plate;
    String model;
    String brand;
}