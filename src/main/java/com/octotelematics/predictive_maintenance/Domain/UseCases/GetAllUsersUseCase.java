package com.octotelematics.predictive_maintenance.Domain.UseCases;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;
import com.octotelematics.predictive_maintenance.Interface.Dto.UserDto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetAllUsersUseCase {
    public static List<UserDto> execute(VehicleAggregateRepository repo) {
        return repo.loadAll().stream()
                .map(VehicleAggregate::getUser)
                .filter(user -> user != null)
                .collect(Collectors.toMap(
                        u -> u.getKey().getTaxId(),
                        u -> u,
                        (u1, u2) -> u1
                ))
                .values().stream()
                .map(u -> new UserDto(
                        u.getKey().getSerialNumber() != null ? u.getKey().getSerialNumber().toString() : null,
                        u.getKey().getTaxId(),
                        u.getName(),
                        u.getSurname(),
                        u.getEmail()
                ))
                .collect(Collectors.toList());
    }
}