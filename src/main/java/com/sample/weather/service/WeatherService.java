package com.sample.weather.service;

import com.sample.weather.exception.WeatherServiceException;
import com.sample.weather.holder.WeatherResponse;

public interface WeatherService {

	WeatherResponse getWeatherByCity(String city,String country)  throws WeatherServiceException;

	WeatherResponse getWeatherByOrdinates(String latitude, String longitude)  throws WeatherServiceException;

	

}
