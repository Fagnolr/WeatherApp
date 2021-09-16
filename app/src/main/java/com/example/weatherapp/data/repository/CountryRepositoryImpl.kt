package com.example.weatherapp.data.repository

import com.example.weatherapp.data.remote.CountryApi
import com.example.weatherapp.data.remote.dto.CountryDto
import com.example.weatherapp.domain.repository.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val api : CountryApi
) : CountryRepository {
    override suspend fun getCountryList(): List<CountryDto> {
        return api.getCountryList()
    }

}