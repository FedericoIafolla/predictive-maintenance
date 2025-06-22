package com.octotelematics.predictive_maintenance.Application;

import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;

import java.util.List;
import java.util.Map;

public interface VehicleAggregateRepository {
    Map<Integer, VehicleAggregate> loadAll();
    void saveAll(List<VehicleAggregate> aggregates, String username);
    void update(VehicleAggregate aggregate, int id);
    void deleteAll(int id);
}
