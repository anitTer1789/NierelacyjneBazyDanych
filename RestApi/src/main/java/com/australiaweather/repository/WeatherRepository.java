package com.australiaweather.repository;

import org.springframework.data.repository.CrudRepository;
import com.australiaweather.entity.Weather;
import java.util.UUID;


public interface WeatherRepository extends CrudRepository<Weather, UUID> {
}
