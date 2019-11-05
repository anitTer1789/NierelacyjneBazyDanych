package com.services;

import com.model.Weather;
import java.util.List;
import java.util.UUID;


public interface WeatherServiceInterface {

    List<Weather> listAll();
    Weather getStats(UUID ID);
    Weather saveNewStat(Weather newStat);
    void deleteStat(UUID ID);
}
