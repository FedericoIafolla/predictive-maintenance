package com.octotelematics.predictive_maintenance.Application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octotelematics.predictive_maintenance.Domain.Entities.VehicleAggregate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostgresVehicleAggregateRepository implements VehicleAggregateRepository {

    private final JdbcTemplate jdbc;
    private final ObjectMapper mapper;

    public PostgresVehicleAggregateRepository(JdbcTemplate jdbc, ObjectMapper mapper) {
        this.jdbc = jdbc;
        this.mapper = mapper;
    }

    @Override
    public Map<Integer, VehicleAggregateDto> loadAll() {
        final String sql = "SELECT id, json FROM \"Elis_tab\" WHERE \"user\" = ?";

        // ResultSetExtractor permette di costruire qualunque struttura di ritorno.
        return jdbc.query(sql, ps -> ps.setString(1, "Federico"), rs -> {
            Map<Integer, VehicleAggregateDto> map = new LinkedHashMap<>();   // mantiene l’ordine del DB
            while (rs.next()) {
                int id = rs.getInt("id");
                String json = rs.getString("json");
                VehicleAggregateDto va = null;
                try {
                    va = mapper.readValue(json, VehicleAggregateDto.class);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                map.put(id, va);
            }
            return map;
        });
    }

    @Override
    public void saveAll(VehicleAggregate aggregates, String username) {
        try {
            String json = mapper.writeValueAsString(aggregates);
            String sql = "INSERT INTO \"Elis_tab\"(json, \"user\") VALUES (?::jsonb, ?)";
            jdbc.update(sql, json, username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteAll(int id) {
        try {
            String sql = "DELETE FROM \"Elis_tab\" WHERE id = ? AND \"user\" = 'Federico'";
            jdbc.update(sql, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(VehicleAggregate aggregate, int id) {
        try {
            String json = mapper.writeValueAsString(aggregate);
            String sql = "UPDATE \"Elis_tab\" SET(json=?::jsonb) WHERE id = ? AND \"user\" = 'Federico'";
            jdbc.update(sql, json, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
