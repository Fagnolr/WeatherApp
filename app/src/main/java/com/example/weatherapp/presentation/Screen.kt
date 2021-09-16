package com.example.weatherapp.presentation

sealed class Screen(val route: String) {
    object CountryListScreen: Screen("country_list_screen")
    object WeatherDetailScreen: Screen("weather_detail_screen")
}
