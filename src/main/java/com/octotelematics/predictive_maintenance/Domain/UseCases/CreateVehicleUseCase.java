package com.octotelematics.predictive_maintenance.Domain.UseCases;


import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.*;
import com.octotelematics.predictive_maintenance.Interface.Dto.PartDto;
import com.octotelematics.predictive_maintenance.Interface.Dto.VehicleDto;

import java.util.List;
import java.util.ArrayList;

public class CreateVehicleUseCase {
    public static void execute(VehicleDto dto, VehicleAggregateRepository repo) {
//        step 1
//        creare veicolo/aggregato
        List<VehiclePart> parts = new ArrayList<>();
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
            parts.add(partToAdd);
        }

    VehicleAggregate aggregate = VehicleAggregate.of(
            VehicleKey.createNew(
                    dto.getChassisNumber(),
                    dto.getPlate()
            ),
            dto.getModel(),
            dto.getBrand(),
            User.create(
                    UserKey.createNew(
                            dto.getOwner().getTaxId()
                    ),
                    dto.getOwner().getName(),
                    dto.getOwner().getSurname(),
                    dto.getOwner().getMail()
            ),
            parts
    );
//        step 2
//        salvo il veicolo (da paolo)
        repo.saveAll(List.of(aggregate), "Federico");
    }
}
