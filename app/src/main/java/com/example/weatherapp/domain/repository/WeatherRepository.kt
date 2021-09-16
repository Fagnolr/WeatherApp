package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.remote.dto.WeatherDetailDto

interface WeatherRepository {
    suspend fun getCapitalWeather(cityName: String, apiKey: String) : WeatherDetailDto
}