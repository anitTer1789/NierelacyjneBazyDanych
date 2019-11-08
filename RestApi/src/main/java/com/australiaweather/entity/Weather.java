package com.australiaweather.entity;

import com.datastax.driver.core.DataType;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.AccessLevel;
import lombok.NonNull;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor(access= AccessLevel.PUBLIC)
@Table
public class Weather {

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID ID;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private @NonNull Date Date;
    private @NonNull String Location;
    private @NonNull float MaxTemp;
    private @NonNull float MinTemp;
    private @NonNull float Rainfall;
    private @NonNull float Evaporation;
    private @NonNull float Sunshine;
    private @NotBlank String WindGustDir;
    private @NonNull int WindGustSpeed;
    private @NotBlank String WindDir9am;
    private @NotBlank String WindDir3pm;
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

    Weather(){this.ID = UUID.randomUUID(); }

}
