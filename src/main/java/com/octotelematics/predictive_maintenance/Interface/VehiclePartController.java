package com.octotelematics.predictive_maintenance.Interface;

import com.octotelematics.predictive_maintenance.Application.Dto.AddPartRequest;
import com.octotelematics.predictive_maintenance.Application.Dto.VehiclePartDto;
import com.octotelematics.predictive_maintenance.Application.Service.AddVehiclePartService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/vehicles/{vehicleId}/parts", produces = "application/json", consumes = "application/json")
public class VehiclePartController {
    private final AddVehiclePartService addVehiclePartService;

    public VehiclePartController(AddVehiclePartService addVehiclePartService) {
        this.addVehiclePartService = addVehiclePartService;
    }

    @PostMapping
    public VehiclePartDto addPart(@PathVariable UUID vehicleId, @RequestBody AddPartRequest request) {
        return addVehiclePartService.execute(request);
    }
}