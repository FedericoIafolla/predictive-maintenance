package com.octotelematics.predictive_maintenance.Application;

// UserDto.java
public record UserDto(
        UserKeyDto key,
        String name,
        String surname,
        String mail) {}
