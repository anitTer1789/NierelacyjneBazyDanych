package com.australiaweather.entity;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter @Setter
@Table
public class Weather {

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID ID;

    public Weather() {
        ID = UUID.randomUUID();
    }

    private Date Date;
    private String Location;
    private float MaxTemp;
    private float MinTemp;
    private float Rainfall;
    private float Evaporation;
    private float Sunshine;
    private String WindGustDir;
    private int WindGustSpeed;
    private String WindDir9am;
    private String WindDir3pm;
    private int WindSpeed9am;
    private int WindSpeed3pm;
    private int Humidity9am;
    private int Humidity3pm;
    private float Pressure9am;
    private float Pressure3pm;
    private int Cloud9am;
    private int Cloud3pm;
    private float Temp9am;
    private float Temp3pm;
    private boolean RainToday;
    private float RISK_MM;
    private boolean RainTomorrow;
}
