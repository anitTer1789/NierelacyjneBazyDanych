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
        return "redirect:/weatherstats/list";
    }

    @RequestMapping(value="/weatherstats/list", method = RequestMethod.GET)
    public String listentrys() {
        return gson.toJson(weatherService.listAll());
    }

    @RequestMapping(value = "/weatherstats/{id}", method = RequestMethod.GET)
    public String getWeatherStats(@PathVariable String id) {
        return gson.toJson(weatherService.getStats(UUID.fromString(id)));
    }

    @RequestMapping(value = "/weatherstats", method = RequestMethod.POST)
    Weather createWeatherStat(@RequestBody Weather weather) {
        return weatherService.saveNewStat(weather);
    }

    @RequestMapping(value = "/weatherstats", method = RequestMethod.PUT)
    Weather updateWeatherStat(@RequestBody Weather weather) {
        return weatherService.saveNewStat(weather);
    }

    @RequestMapping(value = "/weatherstats/{id}", method = RequestMethod.DELETE)
    void deleteWeatherStat(@PathVariable String id) {
        weatherService.deleteStat(UUID.fromString(id));
    }
}

