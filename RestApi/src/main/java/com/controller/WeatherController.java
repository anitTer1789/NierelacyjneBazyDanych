package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.google.gson.Gson;
import com.services.WeatherServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.model.Weather;
import com.repository.WeatherRepository;

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

    @RequestMapping("/")
    public String redirToList() {
        return "redirect:/weather/list";
    }

    @RequestMapping(name = "/weather/list")
    public String listentrys() {
        return gson.toJson(weatherService.listAll());
    }

    @RequestMapping("/weather/show/{id}")
    public String getStats(@PathVariable String id) {
        return gson.toJson(weatherService.getStats(UUID.fromString(id)));
    }


    @RequestMapping(
            value = "/weather",
            method = {RequestMethod.POST, RequestMethod.PUT}
    )
    public void saveNewStat(@Valid @RequestBody Weather newStat) {
        weatherService.saveNewStat(newStat);
    }

    @RequestMapping("/weather/delete/{id}")
    public String delete(@PathVariable String id) {
        weatherService.deleteStat(UUID.fromString(id));
        return "redirect:/weather/list";
    }
}

