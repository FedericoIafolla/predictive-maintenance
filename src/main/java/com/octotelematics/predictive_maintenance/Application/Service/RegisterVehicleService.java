package com.octotelematics.predictive_maintenance.Application.Service;

import com.octotelematics.predictive_maintenance.Application.Dto.CreateVehicleRequest;
import com.octotelematics.predictive_maintenance.Application.Dto.VehicleDto;
import com.octotelematics.predictive_maintenance.Application.Port.Out.UserRepository;
import com.octotelematics.predictive_maintenance.Application.Port.Out.VehicleRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.User;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleKey;
import java.util.UUID;
import java.util.ArrayList;

public class RegisterVehicleService {
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public RegisterVehicleService(VehicleRepository vehicleRepository, UserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    public VehicleDto execute(CreateVehicleRequest request) {
        User user = userRepository.findById(request.getUserId());
        VehicleKey key = VehicleKey.createNew(request.getChassisNumber(), request.getPlate());
        VehicleAggregate vehicle = VehicleAggregate.of(key, request.getModel(), request.getBrand(), user, new ArrayList<>());
        vehicleRepository.save(vehicle);
        return new VehicleDto(key.getId(), request.getUserId(), request.getChassisNumber(), request.getPlate(), request.getModel(), request.getBrand());
    }
}