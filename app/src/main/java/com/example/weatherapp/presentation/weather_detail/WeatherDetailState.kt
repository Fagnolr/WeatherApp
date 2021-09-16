package com.example.weatherapp.presentation.weather_detail

import com.example.weatherapp.domain.model.WeatherDetail

data class WeatherDetailState (
    var isLoading: Boolean = false,
    var weatherDetail: WeatherDetail?=  null,
    var error: String = ""
)