package com.octotelematics.predictive_maintenance.Interface.Api;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;
import com.octotelematics.predictive_maintenance.Domain.UseCases.CreateVehicleUseCase;
import com.octotelematics.predictive_maintenance.Domain.UseCases.GetAllVehicleUseCase;
import com.octotelematics.predictive_maintenance.Interface.Dto.CreateVehicleDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleAggregateRepository repo;
    public VehicleController(VehicleAggregateRepository repo) { this.repo = repo; }
    @PostMapping
    public void createVehicle(@RequestBody CreateVehicleDto dto) {
        CreateVehicleUseCase.execute(dto, repo);
    }
    @GetMapping
    public List<VehicleAggregate> getAll() {
        return GetAllVehicleUseCase.execute(repo);
    }

    @DeleteMapping("/{vehicleId}")
    public void deleteVehicle(@PathVariable UUID vehicleId) {
        DeleteVehicleUseCase.execute(vehicleId, repo);
    }

}