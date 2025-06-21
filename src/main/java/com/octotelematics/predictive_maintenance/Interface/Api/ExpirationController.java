package com.octotelematics.predictive_maintenance.Interface.Api;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.UseCases.UpdateExpirationUseCase;
import com.octotelematics.predictive_maintenance.Interface.Dto.UpdateExpirationDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles/expiration")
public class ExpirationController {
    private final VehicleAggregateRepository repo;
    public ExpirationController(VehicleAggregateRepository repo) { this.repo = repo; }
    @PutMapping
    public void updateExpiration(@RequestBody UpdateExpirationDto dto) {
        UpdateExpirationUseCase.execute(dto, repo);
    }
}