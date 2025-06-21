package com.octotelematics.predictive_maintenance.Application.Dto;

import lombok.Value;
import java.util.UUID;

@Value
public class VehiclePartDto {
    UUID id;
    UUID serialNumber;
    String type;
}