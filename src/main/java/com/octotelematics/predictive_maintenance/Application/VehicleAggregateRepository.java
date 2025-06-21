package com.octotelematics.predictive_maintenance.Application;

import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;

import java.util.List;

public interface VehicleAggregateRepository {
    List<VehicleAggregate> loadAll();
    void saveAll(List<VehicleAggregate> aggregates, String username);
}
