package com.example.weatherapp.repository

import com.example.weatherapp.domain.Weather
import com.example.weatherapp.domain.getRussianCities
import com.example.weatherapp.domain.getWorldCities

class RepositoryImpl:Repository{
    override fun getWeatherFromRemoteSource(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocalSource(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocalStorageRus(): List<Weather> {
       return getRussianCities()
    }

    override fun getWeatherFromLocalStorageWorld(): List<Weather> {
       return getWorldCities()
    }
}