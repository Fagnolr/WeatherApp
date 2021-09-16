package com.example.weatherapp.domain.use_case.get_weather_detail

import com.example.weatherapp.common.Constants
import com.example.weatherapp.common.Resource
import com.example.weatherapp.data.remote.dto.toWeatherDetail
import com.example.weatherapp.domain.model.WeatherDetail
import com.example.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherDetailUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(cityName: String) : Flow<Resource<WeatherDetail>> = flow {
        try {
            emit(Resource.Loading<WeatherDetail>())
            val weatherDetail = repository.getCapitalWeather(cityName, Constants.WEATHERAPIKEY).toWeatherDetail()
            emit(Resource.Success<WeatherDetail>(weatherDetail))
        } catch(e: HttpException) {
            emit(Resource.Error<WeatherDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<WeatherDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}