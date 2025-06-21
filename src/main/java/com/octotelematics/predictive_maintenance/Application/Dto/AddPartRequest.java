package com.octotelematics.predictive_maintenance.Application.Dto;

import lombok.Value;
import java.util.UUID;

@Value
public class AddPartRequest {
    UUID vehicleId;
    UUID partSerialNumber;
    String type;
}