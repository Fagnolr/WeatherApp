package com.example.weatherapp.data.remote.dto

import com.example.weatherapp.domain.model.WeatherDetail

data class WeatherDetailDto(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

fun WeatherDetailDto.toWeatherDetail() : WeatherDetail {
    return WeatherDetail(
        cityName = name,
        weather = weather[0].description,
        weatherData = main
    )
}