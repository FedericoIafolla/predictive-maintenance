package com.octotelematics.predictive_maintenance.Interface.Dto;

import lombok.Data;

import java.util.List;

@Data
public class VehicleDto {
    private String chassisNumber;
    private String plate;
    private String model;
    private String brand;
    private UserDto owner;
    private List<PartDto> vehicleParts;

    public String getChassisNumber() {
        return chassisNumber;
    }

    public String getPlate() {
        return plate;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public UserDto getOwner() {
        return owner;
    }

    public List<PartDto> getVehicleParts() {
        return vehicleParts;
    }
}
