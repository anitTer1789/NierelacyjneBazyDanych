package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.model.Weather;

import java.util.UUID;

public interface WeatherRepository extends CrudRepository<Weather, UUID> {
}
