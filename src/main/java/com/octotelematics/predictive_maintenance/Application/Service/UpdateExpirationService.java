package com.octotelematics.predictive_maintenance.Application.Service;

import com.octotelematics.predictive_maintenance.Application.Dto.UpdateExpirationRequest;
import com.octotelematics.predictive_maintenance.Application.Dto.ExpirationDto;
import com.octotelematics.predictive_maintenance.Application.Port.Out.VehicleRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.Expiration;
import com.octotelematics.predictive_maintenance.Domain.Entities.ExpirationKey;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehiclePart;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehiclePartKey;
import java.util.UUID;

public class UpdateExpirationService {
    private final VehicleRepository vehicleRepository;

    public UpdateExpirationService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public ExpirationDto execute(UpdateExpirationRequest request) {
        VehicleAggregate vehicle = vehicleRepository.findById(request.getVehicleId());
        VehiclePart part = vehicle.getVehicleParts().stream()
                .filter(vp -> vp.getKey().getId().equals(request.getPartId()))
                .findFirst()
                .orElseThrow();
        ExpirationKey expirationKey = ExpirationKey.createNew("km", part.getKey());
        Expiration expiration = Expiration.create(expirationKey, request.getWarningLimitKm(), request.getMaxLimitKm());
        vehicle.updateExpiration(part, expiration);
        vehicleRepository.save(vehicle);
        return new ExpirationDto(expirationKey.getId(), request.getWarningLimitKm(), request.getMaxLimitKm());
    }
}