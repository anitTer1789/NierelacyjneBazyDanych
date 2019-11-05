package com.model;

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

    private @NonNull Date Date;
    private @NonNull String Location;
    private @NonNull float MaxTemp;
    private @NonNull float MinTemp;
    private @NonNull float Rainfall;
    private @NonNull float Evaporation;
    private @NonNull float Sunshine;
    private @NonNull String WindGustDir;
    private @NonNull int WindGustSpeed;
    private @NonNull String WindDir9am;
    private @NonNull String WindDir3pm;
    private @NonNull int WindSpeed9am;
    private @NonNull int WindSpeed3pm;
    private @NonNull int Humidity9am;
    private @NonNull int Humidity3pm;
    private @NonNull float Pressure9am;
    private @NonNull float Pressure3pm;
    private @NonNull int Cloud9am;
    private @NonNull int Cloud3pm;
    private @NonNull float Temp9am;
    private @NonNull float Temp3pm;
    private @NonNull boolean RainToday;
    private @NonNull float RISK_MM;
    private @NonNull boolean RainTomorrow;
}
