package com.octotelematics.predictive_maintenance.Application.Dto;

import lombok.Value;
import java.util.UUID;

@Value
public class ExpirationDto {
    UUID id;
    int warningLimitKm;
    int maxLimitKm;
}