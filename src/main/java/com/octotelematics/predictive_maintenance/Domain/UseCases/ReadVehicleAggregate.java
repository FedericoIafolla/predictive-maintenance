package com.octotelematics.predictive_maintenance.Domain.UseCases;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;
import com.octotelematics.predictive_maintenance.Domain.Mapping.VehicleAggregateMapper;

import java.util.List;

public class ReadVehicleAggregate {
    public static List<VehicleAggregate> execute(VehicleAggregateRepository repo) {
        return  repo.loadAll().values().stream()
                .map(Dto -> VehicleAggregateMapper.map(Dto))
               .toList();

    }
}
