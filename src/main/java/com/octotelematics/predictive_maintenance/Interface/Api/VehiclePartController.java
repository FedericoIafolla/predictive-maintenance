package com.octotelematics.predictive_maintenance.Interface.Api;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.UseCases.AddVehiclePartUseCase;
import com.octotelematics.predictive_maintenance.Interface.Dto.AddPartDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles/parts")
public class VehiclePartController {
    private final VehicleAggregateRepository repo;
    public VehiclePartController(VehicleAggregateRepository repo) { this.repo = repo; }
    @PostMapping
    public void addPart(@RequestBody AddPartDto dto) {
        AddVehiclePartUseCase.execute(dto, repo);
    }
}