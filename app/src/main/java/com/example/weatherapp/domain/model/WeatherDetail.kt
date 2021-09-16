package com.example.weatherapp.domain.model

import com.example.weatherapp.data.remote.dto.Main

data class WeatherDetail(
    val cityName : String,
    val weather : String,
    val weatherData : Main
)
