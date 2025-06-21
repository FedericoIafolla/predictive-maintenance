package com.octotelematics.predictive_maintenance.Domain.UseCases;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.Expiration;
import com.octotelematics.predictive_maintenance.Domain.Entities.ExpirationKey;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;
import com.octotelematics.predictive_maintenance.Interface.Dto.UpdateExpirationDto;

import java.util.List;
import java.util.UUID;

public class UpdateExpirationUseCase {
    public static void execute(UpdateExpirationDto dto, VehicleAggregateRepository repo) {
        List<VehicleAggregate> list = repo.loadAll();
        ExpirationKey expKey = ExpirationKey.of(UUID.fromString(dto.getPartSerial()), "part", null);
        Expiration newExp = Expiration.create(expKey, dto.getWarningLimitKm(), dto.getMaxLimitKm());
        list.stream()
                .filter(agg -> agg.getKey().getId().toString().equals(dto.getVehicleId()))
                .findFirst()
                .ifPresent(agg -> agg.updateExpiration(null, newExp));
        repo.saveAll(list, "Federico Iafolla");
    }
}