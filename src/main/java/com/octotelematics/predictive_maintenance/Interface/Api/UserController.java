package com.octotelematics.predictive_maintenance.Interface.Api;

import com.octotelematics.predictive_maintenance.Application.VehicleAggregateRepository;
import com.octotelematics.predictive_maintenance.Domain.UseCases.CreateUserUseCase;
import com.octotelematics.predictive_maintenance.Domain.UseCases.DeleteUserUseCase;
import com.octotelematics.predictive_maintenance.Interface.Dto.CreateUserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final VehicleAggregateRepository repo;
    public UserController(VehicleAggregateRepository repo) {
        this.repo = repo;
    }
    @PostMapping
    public void createUser(@RequestBody CreateUserDto dto){
        CreateUserUseCase.execute(dto, repo);
    }
    @DeleteMapping("/{taxId}")
    public void deleteUser(@PathVariable String taxId) {
        DeleteUserUseCase.execute(taxId, repo);
    }

}
