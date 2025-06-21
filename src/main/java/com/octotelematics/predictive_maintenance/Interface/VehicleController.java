package com.octotelematics.predictive_maintenance.Interface;

import com.octotelematics.predictive_maintenance.Application.Dto.CreateVehicleRequest;
import com.octotelematics.predictive_maintenance.Application.Dto.DeleteVehicleResponse;
import com.octotelematics.predictive_maintenance.Application.Dto.VehicleDto;
import com.octotelematics.predictive_maintenance.Application.Service.DeleteVehicleService;
import com.octotelematics.predictive_maintenance.Application.Service.RegisterVehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/vehicles", produces = "application/json", consumes = "application/json")
public class VehicleController {
    private final RegisterVehicleService registerVehicleService;
    private final DeleteVehicleService deleteVehicleService;

    public VehicleController(
            RegisterVehicleService registerVehicleService,
            DeleteVehicleService deleteVehicleService
    ) {
        this.registerVehicleService = registerVehicleService;
        this.deleteVehicleService = deleteVehicleService;
    }

    @PostMapping
    public VehicleDto registerVehicle(@RequestBody CreateVehicleRequest request) {
        return registerVehicleService.execute(request);
    }

    @DeleteMapping("/{id}")
    public DeleteVehicleResponse deleteVehicle(@PathVariable UUID id) {
        return deleteVehicleService.execute(id);
    }
}