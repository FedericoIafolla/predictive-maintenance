package com.octotelematics.predictive_maintenance.Domain.UseCases;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateDto;
import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.*;
import com.octotelematics.predictive_maintenance.Domain.Mapping.VehicleAggregateMapper;
import com.octotelematics.predictive_maintenance.Interface.Dto.PartDto;
import com.octotelematics.predictive_maintenance.Interface.Dto.VehicleDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AddVehiclePartUseCase {
    public static void execute(VehicleDto dto, VehicleAggregateRepository repo) {
        // step 1: leggi lista aggregati
        Map<Integer, VehicleAggregateDto> aggregates = repo.loadAll();
        // step 2: ricerco in base all'id del veicolo
        Map.Entry<Integer, VehicleAggregateDto> entry = aggregates.entrySet()  // ⇦ stream sugli entry
                .stream()
                .filter(e ->
                        e.getValue().key().chassisNumber().equals(dto.getChassisNumber()) &&
                                e.getValue().key().plate().equals(dto.getPlate()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        int id = entry.getKey();                 // id del veicolo trovato
        VehicleAggregate aggregate = VehicleAggregateMapper.map(entry.getValue());  // oggetto VehicleAggregate
        // step 3: aggiungo la parte

        for (PartDto part : dto.getVehicleParts()) {
            VehiclePart partToAdd = VehiclePart.create(
                            VehicleKey.createNew(
                                        part.chassisNumber(), part.plate()
                            ),
                            VehiclePartKey.createNew(
                                part.partSerial()
                            ),
                            part.brand(),
                            part.model(),
                            Expiration.create(
                                    ExpirationKey.createNew(
                                            part.expiration().getType()
                                    ),
                                    part.expiration().getWarningLimitKm(),
                                    part.expiration().getMaxLimitKm()
                            )
            );
            aggregate.addVehiclePart(partToAdd);
        }
        // step 4: aggiorno l'aggregato
    repo.update(aggregate, id);
    }
}
