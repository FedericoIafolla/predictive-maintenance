package com.octotelematics.predictive_maintenance.Application.Dto;

import lombok.Value;
import java.util.UUID;

@Value
public class UpdateExpirationRequest {
    UUID vehicleId;
    UUID partId;
    int warningLimitKm;
    int maxLimitKm;
}