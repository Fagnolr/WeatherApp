package com.example.weatherapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.R
import com.example.weatherapp.presentation.country_list.CountryListScreen
import com.example.weatherapp.presentation.theme.WeatherAppTheme
import com.example.weatherapp.presentation.weather_detail.WeatherDetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CountryListScreen.route
                    ) {
                        composable(
                            route = Screen.CountryListScreen.route
                        ) {
                            CountryListScreen(navController)
                        }
                        composable(
                            route = Screen.WeatherDetailScreen.route + "/{capital_name}"
                        ) {
                            WeatherDetailScreen()
                        }
                    }
                }
            }
        }
    }
}