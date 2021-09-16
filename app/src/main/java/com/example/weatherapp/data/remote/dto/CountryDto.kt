package com.example.weatherapp.data.remote.dto

import com.example.weatherapp.domain.model.Country

data class CountryDto(
    val alpha2Code: String,
    val alpha3Code: String,
    val altSpellings: List<String>,
    val area: Double,
    val borders: List<String>,
    val callingCodes: List<String>,
    val capital: String,
    val cioc: String,
    val currencies: List<Currency>,
    val demonym: String,
    val flag: String,
    val gini: Double,
    val languages: List<Language>,
    val latlng: List<Double>,
    val name: String,
    val nativeName: String,
    val numericCode: String,
    val population: Int,
    val region: String,
    val regionalBlocs: List<RegionalBloc>,
    val subregion: String,
    val timezones: List<String>,
    val topLevelDomain: List<String>,
    val translations: Translations
)

fun CountryDto.toCountry() : Country {
    return Country(
        name = name,
        capital = capital,
        flag = flag
    )
}