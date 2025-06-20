package com.octotelematics.predictive_maintenance.Domain.Entities;

import java.util.List;

public class VehicleAggregate {
    private VehicleKey key;
    private String model;
    private String brand;
    private User user;
    private List<VehiclePart> vehicleParts;

    private VehicleAggregate(VehicleKey key, String model, String brand, User user, List<VehiclePart> vehicleParts) {
        this.key = key;
        this.model = model;
        this.brand = brand;
        this.user = user;
        this.vehicleParts = vehicleParts;
    }

    public static VehicleAggregate of(VehicleKey key, String model, String brand, User user, List<VehiclePart> vehicleParts) {
        return new VehicleAggregate(key, model, brand, user, vehicleParts);
    }

    public void updateUser(User newUser) {
        this.user = newUser;
    }

    public void addVehiclePart(VehiclePart vehiclePart) {
        this.vehicleParts.add(vehiclePart);
    }

    public void removeVehiclePart(VehiclePart vehiclePart) {
        this.vehicleParts.remove(vehiclePart);
    }

    public void updateVehiclePart(VehiclePart newVehiclePart) { // provare a cambiare con la key di vehicle part entrambi update
        VehiclePart partToDelete = this.vehicleParts.stream().filter(vp->vp.key==newVehiclePart.key).findFirst().orElseThrow();
        removeVehiclePart(partToDelete);
        addVehiclePart(newVehiclePart);
    }

    public void updateExpiration(VehiclePart NewPartExpiration, Expiration newExpiration) {
        VehiclePart partToDelete = this.vehicleParts.stream().filter(vp->vp.key==NewPartExpiration.key).findFirst().orElseThrow();
        partToDelete.updateExpiration(newExpiration);
    }
}

