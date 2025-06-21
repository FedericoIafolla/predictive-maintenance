package com.octotelematics.predictive_maintenance.Domain.UseCases;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;

import java.util.List;

public class GetAllVehicleUseCase {
    public static List<VehicleAggregate> execute(VehicleAggregateRepository repo) {
        return repo.loadAll();
    }
}
