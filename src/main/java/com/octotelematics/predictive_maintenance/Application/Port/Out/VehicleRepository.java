package com.octotelematics.predictive_maintenance.Application.Port.Out;

import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;
import java.util.UUID;
import java.util.List;

public interface VehicleRepository {
    VehicleAggregate findById(UUID id);
    List<VehicleAggregate> findAll();
    void save(VehicleAggregate vehicle);
    void deleteById(UUID id);
}