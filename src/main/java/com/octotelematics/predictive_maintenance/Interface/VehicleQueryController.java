package com.octotelematics.predictive_maintenance.Interface;

import com.octotelematics.predictive_maintenance.Application.Dto.VehicleDto;
import com.octotelematics.predictive_maintenance.Application.Service.GetVehicleService;
import com.octotelematics.predictive_maintenance.Application.Service.ListVehiclesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/vehicles", produces = "application/json")
public class VehicleQueryController {
    private final ListVehiclesService listVehiclesService;
    private final GetVehicleService getVehicleService;

    public VehicleQueryController(ListVehiclesService listVehiclesService, GetVehicleService getVehicleService) {
        this.listVehiclesService = listVehiclesService;
        this.getVehicleService = getVehicleService;
    }

    @GetMapping
    public List<VehicleDto> listVehicles() {
        return listVehiclesService.execute();
    }

    @GetMapping("/{id}")
    public VehicleDto getVehicle(@PathVariable UUID id) {
        return getVehicleService.execute(id);
    }
}