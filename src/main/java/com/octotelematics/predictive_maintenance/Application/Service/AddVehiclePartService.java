package com.octotelematics.predictive_maintenance.Application.Service;

import com.octotelematics.predictive_maintenance.Application.Dto.AddPartRequest;
import com.octotelematics.predictive_maintenance.Application.Dto.VehiclePartDto;
import com.octotelematics.predictive_maintenance.Application.Port.Out.VehicleRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehiclePart;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehiclePartKey;
import java.util.UUID;

public class AddVehiclePartService {
    private final VehicleRepository vehicleRepository;

    public AddVehiclePartService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehiclePartDto execute(AddPartRequest request) {
        VehicleAggregate vehicle = vehicleRepository.findById(request.getVehicleId());
        VehiclePartKey partKey = VehiclePartKey.createNew(request.getPartSerialNumber());
        VehiclePart part = VehiclePart.of(partKey, request.getType());
        vehicle.addVehiclePart(part);
        vehicleRepository.save(vehicle);
        return new VehiclePartDto(partKey.getId(), partKey.getSerialNumber(), request.getType());
    }
}