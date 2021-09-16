package com.example.weatherapp.data.remote

import com.example.weatherapp.data.remote.dto.WeatherDetailDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @GET("/data/2.5/weather")
    suspend fun getCapitalWeather(@Query("q") cityName : String, @Query("appid") apiKey : String) : WeatherDetailDto
}