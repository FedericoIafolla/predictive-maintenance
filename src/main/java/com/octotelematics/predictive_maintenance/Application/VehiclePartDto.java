package com.octotelematics.predictive_maintenance.Application;

// VehiclePartDto.java
public record VehiclePartDto(
        VehiclePartKeyDto key,
        VehicleKeyDto vehicleKey,
        String brand,
        String model,
        ExpirationDto expiration) {}
