package com.example.weatherapp.data.repository

import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.data.remote.dto.WeatherDetailDto
import com.example.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getCapitalWeather(cityName: String, apiKey: String): WeatherDetailDto {
        return api.getCapitalWeather(cityName, apiKey)
    }
}