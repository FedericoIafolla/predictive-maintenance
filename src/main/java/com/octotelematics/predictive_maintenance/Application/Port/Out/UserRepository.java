package com.octotelematics.predictive_maintenance.Application.Port.Out;

import com.octotelematics.predictive_maintenance.Domain.Entities.User;
import java.util.UUID;

public interface UserRepository {
    User findById(UUID id);
}