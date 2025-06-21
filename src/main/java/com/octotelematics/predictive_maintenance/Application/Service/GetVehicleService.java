package com.octotelematics.predictive_maintenance.Application.Service;

import com.octotelematics.predictive_maintenance.Application.Dto.VehicleDto;
import com.octotelematics.predictive_maintenance.Application.Exception.VehicleNotFoundException;
import com.octotelematics.predictive_maintenance.Application.Port.Out.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetVehicleService {
    private final VehicleRepository vehicleRepository;

    public GetVehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleDto execute(UUID id) {
        var v = vehicleRepository.findById(id);
        if (v == null) throw new VehicleNotFoundException();
        return new VehicleDto(
                v.getKey().getId(),
                v.getUser().getKey().getSerialNumber(),
                v.getKey().getChassisNumber(),
                v.getKey().getPlate(),
                v.getModel(),
                v.getBrand()
        );
    }
}