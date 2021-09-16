package com.example.weatherapp.presentation.weather_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import java.text.DecimalFormat
import kotlin.math.roundToLong

@Composable
fun WeatherDetailScreen(
    viewModel: WeatherDetailViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.weatherDetail?.let { weather ->
            BoxWithConstraints(modifier = Modifier.align(Alignment.Center)
                .padding(7.5.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.DarkGray), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(weather.cityName, color = Color.White)
                    Text(weather.weather, color = Color.White)
                    Text(DecimalFormat("#.#").format(weather.weatherData.temp - 273.15)
                            + "°C", color = Color.White)
                    Text("Humidity : " + weather.weatherData.humidity.toString() + "%", color = Color.White)
                    Text("Min and Max °C : " +
                            DecimalFormat("#.#").format(weather.weatherData.temp_min - 273.15)
                            + "°C" + "-" + DecimalFormat("#.#").format(weather.weatherData.temp_max - 273.15) + "°C"
                        , color = Color.White)

                }
            }
        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}