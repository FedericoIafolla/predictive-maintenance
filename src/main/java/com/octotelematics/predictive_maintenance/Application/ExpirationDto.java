package com.octotelematics.predictive_maintenance.Application;

// ExpirationDto.java
public record ExpirationDto(
        ExpirationKeyDto key,
        int maxLimitKm,
        int warningLimitKm) {}
