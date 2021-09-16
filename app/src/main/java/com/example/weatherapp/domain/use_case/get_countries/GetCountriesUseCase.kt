package com.example.weatherapp.domain.use_case.get_countries

import com.example.weatherapp.common.Resource
import com.example.weatherapp.data.remote.dto.toCountry
import com.example.weatherapp.domain.model.Country
import com.example.weatherapp.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(): Flow<Resource<List<Country>>> = flow {
        try {
            emit(Resource.Loading<List<Country>>())
            val countries = repository.getCountryList().map { it.toCountry() }
            emit(Resource.Success<List<Country>>(countries))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Country>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Country>>("Couldn't reach server. Check your internet connection."))
        }
    }
}