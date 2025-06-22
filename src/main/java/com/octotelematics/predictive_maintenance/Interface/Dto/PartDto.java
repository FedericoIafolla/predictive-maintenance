package com.octotelematics.predictive_maintenance.Interface.Dto;

import java.util.UUID;

public record PartDto(
        String chassisNumber,
        String plate,
        UUID partSerial,
        String brand,
        String model,
        ExpirationDto expiration
) {}