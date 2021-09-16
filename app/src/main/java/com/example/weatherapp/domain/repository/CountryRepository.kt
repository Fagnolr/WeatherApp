package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.remote.dto.CountryDto

interface CountryRepository {
    suspend fun getCountryList(): List<CountryDto>
}