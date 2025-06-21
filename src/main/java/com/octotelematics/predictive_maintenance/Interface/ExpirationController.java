package com.octotelematics.predictive_maintenance.Interface;

import com.octotelematics.predictive_maintenance.Application.Dto.ExpirationDto;
import com.octotelematics.predictive_maintenance.Application.Dto.UpdateExpirationRequest;
import com.octotelematics.predictive_maintenance.Application.Service.UpdateExpirationService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/vehicles/{vehicleId}/parts/{partId}/expiration", produces = "application/json", consumes = "application/json")
public class ExpirationController {
    private final UpdateExpirationService updateExpirationService;

    public ExpirationController(UpdateExpirationService updateExpirationService) {
        this.updateExpirationService = updateExpirationService;
    }

    @PutMapping
    public ExpirationDto updateExpiration(
            @PathVariable UUID vehicleId,
            @PathVariable UUID partId,
            @RequestBody UpdateExpirationRequest request
    ) {
        return updateExpirationService.execute(request);
    }
}