package com.example.weatherapp.repository

import com.example.weatherapp.domain.Weather

interface Repository {
    fun getWeatherFromRemoteSource():Weather
    fun getWeatherFromLocalSource():Weather

    fun getWeatherFromLocalSourceRus():List<Weather>
    fun getWeatherFromLocalSourceWorld():List<Weather>
}