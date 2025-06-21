package com.octotelematics.predictive_maintenance.Domain.UseCases;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.Expiration;
import com.octotelematics.predictive_maintenance.Domain.Entities.ExpirationKey;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehiclePart;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehiclePartKey;
import com.octotelematics.predictive_maintenance.Interface.Dto.AddPartDto;

import java.util.List;
import java.util.UUID;

public class AddVehiclePartUseCase {
    public static void execute(AddPartDto dto, VehicleAggregateRepository repo) {
        List<VehicleAggregate> list = repo.loadAll();
        VehiclePartKey partKey = VehiclePartKey.createNew(UUID.fromString(dto.getPartSerial()));
        ExpirationKey expKey = ExpirationKey.createNew("part", partKey);
        Expiration expiration = Expiration.create(expKey, dto.getWarningLimitKm(), dto.getMaxLimitKm());
        list.stream()
                .filter(agg -> agg.getKey().getId().toString().equals(dto.getVehicleId()))
                .findFirst()
                .ifPresent(agg -> agg.addVehiclePart(
                        VehiclePart.create(agg.getKey(), partKey, dto.getBrand(), dto.getModel(), expiration)
                ));
        repo.saveAll(list, "Federico Iafolla");
    }
}