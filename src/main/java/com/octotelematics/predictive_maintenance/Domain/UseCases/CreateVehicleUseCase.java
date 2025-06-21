package com.octotelematics.predictive_maintenance.Domain.UseCases;


import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.Vehicle;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleKey;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;
import com.octotelematics.predictive_maintenance.Interface.Dto.CreateVehicleDto;

import java.util.List;
import java.util.ArrayList;

public class CreateVehicleUseCase {
    public static void execute(CreateVehicleDto dto, VehicleAggregateRepository repo) {
        List<VehicleAggregate> list = repo.loadAll();
        VehicleKey key = VehicleKey.createNew(dto.getChassisNumber(), dto.getPlate());
        Vehicle vehicle = Vehicle.create(key, dto.getModel(), dto.getBrand());
        VehicleAggregate aggregate = VehicleAggregate.of(key, dto.getModel(), dto.getBrand(), null, new ArrayList<>());
        list.add(aggregate);
        repo.saveAll(list, "Federico Iafolla");
    }
}