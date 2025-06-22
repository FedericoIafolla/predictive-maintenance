package com.octotelematics.predictive_maintenance.Application;

public record UserDto(
        UserKeyDto key,
        String name,
        String surname,
        String mail) {}
