package com.octotelematics.predictive_maintenance.Domain.UseCases;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.User;
import com.octotelematics.predictive_maintenance.Domain.Entities.UserKey;
import com.octotelematics.predictive_maintenance.Interface.Dto.CreateUserDto;

import java.util.List;

public class CreateUserUseCase {
    public static void execute(CreateUserDto dto, VehicleAggregateRepository repo) {
        List<com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate> list = repo.loadAll();
        UserKey key = UserKey.CreateNew(dto.getTaxId());
        User user = User.create(key, dto.getName(), dto.getSurname(), dto.getEmail());
        list.forEach(agg -> agg.updateUser(user));
        repo.saveAll(list, "Federico Iafolla");
    }
}