package com.australiaweather.controller;

import java.util.List;

import com.google.gson.Gson;
import com.australiaweather.services.WeatherServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.australiaweather.entity.Weather;

import javax.validation.Valid;
import java.util.UUID;


@RestController
public class WeatherController {
    private WeatherServiceInterface weatherService;
    private Gson gson = new Gson();

    @Autowired
    public void setEntryService(WeatherServiceInterface weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/")
    public String redirToList() {
        return "redirect:/weather/list";
    }

    @RequestMapping(value="/weather/list", method = RequestMethod.GET)
    public String listentrys() {
        return gson.toJson(weatherService.listAll());
    }

    @RequestMapping(value = "/weather/{id}", method = RequestMethod.GET)
    public String getWeatherStats(@PathVariable String id) {
        return gson.toJson(weatherService.getStats(UUID.fromString(id)));
    }

    @RequestMapping(value = "/weather", method = RequestMethod.POST)
    Weather createWeatherStat(@RequestBody Weather weather) {
        return weatherService.saveNewStat(weather);
    }

    @RequestMapping(value = "/weather", method = RequestMethod.PUT)
    Weather updateWeatherStat(@RequestBody Weather weather) {
        return weatherService.saveNewStat(weather);
    }

    @RequestMapping(value = "/weather/{id}", method = RequestMethod.DELETE)
    void deleteWeatherStat(@PathVariable("ID") UUID ID) {
        weatherService.deleteStat(ID);
    }
}

