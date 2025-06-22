package com.octotelematics.predictive_maintenance.Application;

// VehicleKeyDto.java
public record VehicleKeyDto(
        String chassisNumber,
        String plate,
        java.util.UUID id) {}
