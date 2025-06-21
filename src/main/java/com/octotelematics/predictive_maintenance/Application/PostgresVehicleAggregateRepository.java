package com.octotelematics.predictive_maintenance.Application;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class PostgresVehicleAggregateRepository {
    private final JdbcTemplate jdbc;
    private final ObjectMapper mapper;

    public PostgresVehicleAggregateRepository(JdbcTemplate jdbc, ObjectMapper mapper) {
        this.jdbc = jdbc;
        this.mapper = mapper;
    }

    @Override
    public List<VehicleAggregate> loadAll() {
        String sql = "SELECT data FROM operations ORDER BY id DESC LIMIT 1";
        List<String> jsonList = jdbc.query(sql, (rs, rowNum) -> rs.getString("data"));
        if (jsonList.isEmpty()) {
            return Collections.emptyList();
        }
        try {
            return mapper.readValue(jsonList.get(0), new TypeReference<List<VehicleAggregate>>() {});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll(List<VehicleAggregate> aggregates, String username) {
        try {
            String json = mapper.writeValueAsString(aggregates);
            String sql = "INSERT INTO operations(data, username) VALUES (?::jsonb, ?)";
            jdbc.update(sql, json, username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

