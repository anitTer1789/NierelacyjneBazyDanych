package com.cassandra.repository;

import org.springframework.data.repository.CrudRepository;

import com.cassandra.model.Weather;

import java.util.UUID;

public interface WeatherRepository extends CrudRepository<Weather, UUID> {
}
