package com.australiaweather.services;

import com.australiaweather.entity.Weather;
import com.australiaweather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class WeatherService implements WeatherServiceInterface {

    private WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }


    @Override
    public List<Weather> listAll() {
        List<Weather> stats = new ArrayList<>();
        weatherRepository.findAll().forEach(stats::add);
        return stats;
    }

    @Override
    public Weather getStats(UUID ID) {
        return weatherRepository.findById(ID).orElse(null);
    }

    @Override
    public Weather saveNewStat(Weather weather) {
        weatherRepository.save(weather);
        return weather;
    }

    @Override
    public void deleteStat(UUID ID) {
        weatherRepository.deleteById(ID);

    }
}
