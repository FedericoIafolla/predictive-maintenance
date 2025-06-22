package com.octotelematics.predictive_maintenance.Application;

public record VehicleKeyDto(
        String chassisNumber,
        String plate,
        java.util.UUID id) {}
