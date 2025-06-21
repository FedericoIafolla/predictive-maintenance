package com.octotelematics.predictive_maintenance.Domain.UseCases;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DeleteVehicleUseCase {
    public static void execture(UUID vehicleId, VehicleAggregateRepository repo) {
        List<VehicleAggregate> all = repo.loadAll();
        List<VehicleAggregate> filtered = all.stream()
                .filter(agg -> !agg.getKey().equals(vehicleId))
                .collect(Collectors.toList());
        repo.saveAll(filtered, "Federico Iafolla");
    }
}
