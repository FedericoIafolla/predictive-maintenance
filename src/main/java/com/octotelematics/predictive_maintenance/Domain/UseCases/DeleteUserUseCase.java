package com.octotelematics.predictive_maintenance.Domain.UseCases;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;

import java.util.List;

public class DeleteUserUseCase {
    public static void execute(String taxId, VehicleAggregateRepository repo) {
        List<VehicleAggregate> all = repo.loadAll();
        all.forEach(agg -> {
            if (agg.getUser() != null && agg.getUser().getTaxId().equals(taxId)) {
                agg.updateUser(null);
            }
        });
        repo.saveAll(all, "Federico Iafolla");
    }
}
