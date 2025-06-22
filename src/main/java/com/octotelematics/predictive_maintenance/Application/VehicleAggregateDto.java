package com.octotelematics.predictive_maintenance.Application;

// VehicleAggregateDto.java
import java.util.List;

public record VehicleAggregateDto(
        VehicleKeyDto key,
        String model,
        String brand,
        UserDto user,
        List<VehiclePartDto> vehicleParts) {}