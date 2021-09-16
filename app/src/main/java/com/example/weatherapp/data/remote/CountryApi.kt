package com.example.weatherapp.data.remote

import com.example.weatherapp.data.remote.dto.CountryDto
import retrofit2.http.GET

interface CountryApi {
    @GET("/rest/v2/all")
    suspend fun getCountryList(): List<CountryDto>
}