package com.cassandra.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.google.gson.Gson;
import com.cassandra.services.WeatherServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cassandra.model.Weather;
import com.cassandra.repository.WeatherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;


@RestController
public class WeatherController {
    private WeatherServiceInterface weatherService;

    private Gson gson = new Gson();

    @Autowired
    public void setWeatherService(WeatherServiceInterface weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/weather", method = RequestMethod.POST)
    Weather create(@RequestBody Weather weather) {
        return weatherService.saveNewStat(weather);
    }

    @RequestMapping(value = "/weather/{ID}", method = RequestMethod.DELETE)
    void delete(@PathVariable("ID") UUID ID) {
        weatherService.deleteStat(ID);
    }

    @RequestMapping(value="/weather", method = RequestMethod.GET)
    List<Weather> findAll() {
        return weatherService.listAll();
    }

    @RequestMapping(value = "/weather/{ID}", method = RequestMethod.GET)
    Weather findById(@PathVariable("ID") UUID ID) {
        return weatherService.getStats(ID);
    }

    @RequestMapping(value = "/weather", method = RequestMethod.PUT)
    Weather update(@RequestBody Weather weather) {
        return weatherService.saveNewStat(weather);
    }
}

