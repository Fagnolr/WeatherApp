package com.example.weatherapp.di

import com.example.weatherapp.common.Constants
import com.example.weatherapp.data.remote.CountryApi
import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.data.repository.CountryRepositoryImpl
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.domain.repository.CountryRepository
import com.example.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.WEATHERAPI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCountryApi(): CountryApi {
        return Retrofit.Builder()
            .baseUrl(Constants.COUNTRYAPI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCountryRepository(api: CountryApi): CountryRepository {
        return CountryRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }
}