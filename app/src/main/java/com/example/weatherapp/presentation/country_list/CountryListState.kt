package com.example.weatherapp.presentation.country_list

import com.example.weatherapp.domain.model.Country

data class CountryListState (
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val error: String = ""
)