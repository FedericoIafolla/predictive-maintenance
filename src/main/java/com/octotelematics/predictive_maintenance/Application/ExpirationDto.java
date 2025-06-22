package com.octotelematics.predictive_maintenance.Application;

public record ExpirationDto(
        ExpirationKeyDto key,
        int maxLimitKm,
        int warningLimitKm) {}
