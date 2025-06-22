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

    public VehicleKey getKey() {
        return key;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public User getUser() {
        return user;
    }

    public List<VehiclePart> getVehicleParts() {
        return vehicleParts;
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

    public void updateVehiclePart(VehiclePart newVehiclePart) {
        VehiclePart partToDelete = this.vehicleParts.stream()
                .filter(vp -> vp.getKey().equals(newVehiclePart.getKey()))
                .findFirst()
                .orElseThrow();
        removeVehiclePart(partToDelete);
        addVehiclePart(newVehiclePart);
    }

    public void updateExpiration(ExpirationKey expirationKey, Expiration newExpiration) {
        VehiclePart part = this.vehicleParts.stream()
                .filter(vp -> vp.getExpiration().getKey().getGianni().equals(expirationKey.getGianni()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("VehiclePart not found for expiration update"));

        part.updateExpiration(newExpiration);
    }
}
