package com.octotelematics.predictive_maintenance.Application.Service;

import com.octotelematics.predictive_maintenance.Application.Dto.DeleteVehicleResponse;
import com.octotelematics.predictive_maintenance.Application.Exception.VehicleNotFoundException;
import com.octotelematics.predictive_maintenance.Application.Port.Out.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteVehicleService {
    private final VehicleRepository vehicleRepository;

    public DeleteVehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public DeleteVehicleResponse execute(UUID id) {
        var existing = vehicleRepository.findById(id);
        if (existing == null) throw new VehicleNotFoundException();
        vehicleRepository.deleteById(id);
        return new DeleteVehicleResponse(true);
    }
}