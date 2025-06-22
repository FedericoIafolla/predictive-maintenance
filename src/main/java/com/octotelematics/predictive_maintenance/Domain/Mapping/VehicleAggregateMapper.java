package com.octotelematics.predictive_maintenance.Domain.Mapping;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateDto;
import com.octotelematics.predictive_maintenance.Application.VehiclePartDto;
import com.octotelematics.predictive_maintenance.Domain.Entities.*;
import com.octotelematics.predictive_maintenance.Interface.Dto.PartDto;

import java.util.ArrayList;
import java.util.List;

public class VehicleAggregateMapper {
    public static VehicleAggregate map(VehicleAggregateDto dto) {
        List<VehiclePart> parts = new ArrayList<>();
        for (VehiclePartDto part : dto.vehicleParts()) {
            VehiclePart partToAdd = VehiclePart.create(
                    VehicleKey.createNew(
                            part.vehicleKey().chassisNumber(), part.vehicleKey().plate()
                    ),
                    VehiclePartKey.createNew(
                            part.key().serialNumber()
                    ),
                    part.brand(),
                    part.model(),
                    Expiration.create(
                            ExpirationKey.createNew(
                                    part.expiration().key().gianni()
                            ),
                            part.expiration().warningLimitKm(),
                            part.expiration().maxLimitKm()
                    )
            );
            parts.add(partToAdd);
        }

        VehicleAggregate aggregate = VehicleAggregate.of(
                VehicleKey.createNew(
                        dto.key().chassisNumber(),
                        dto.key().plate()
                ),
                dto.model(),
                dto.brand(),
                User.create(
                        UserKey.createNew(
                                dto.user().key().taxId()
                        ),
                        dto.user().name(),
                        dto.user().surname(),
                        dto.user().mail()
                ),
                parts
        );
    return aggregate;
    }
}
