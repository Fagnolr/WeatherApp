package com.example.weatherapp.presentation.weather_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.common.Constants
import com.example.weatherapp.common.Resource
import com.example.weatherapp.domain.use_case.get_weather_detail.GetWeatherDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherDetailViewModel @Inject constructor(
    private val getWeatherDetailUseCase: GetWeatherDetailUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(WeatherDetailState())
    val state: State<WeatherDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COUNTRY_NAME)?.let { countryName ->
            getWeather(countryName)
        }
    }

    private fun getWeather(countryName: String) {
        getWeatherDetailUseCase(countryName).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = WeatherDetailState(weatherDetail = result.data)
                }
                is Resource.Error -> {
                    _state.value = WeatherDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = WeatherDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}