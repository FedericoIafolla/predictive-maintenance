package com.octotelematics.predictive_maintenance.Application.Service;

import com.octotelematics.predictive_maintenance.Application.Dto.VehicleDto;
import com.octotelematics.predictive_maintenance.Application.Port.Out.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListVehiclesService {
    private final VehicleRepository vehicleRepository;

    public ListVehiclesService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleDto> execute() {
        return vehicleRepository.findAll().stream()
                .map(v -> new VehicleDto(
                        v.getKey().getId(),
                        v.getUser().getKey().getSerialNumber(),
                        v.getKey().getChassisNumber(),
                        v.getKey().getPlate(),
                        v.getModel(),
                        v.getBrand()
                ))
                .collect(Collectors.toList());
    }
}