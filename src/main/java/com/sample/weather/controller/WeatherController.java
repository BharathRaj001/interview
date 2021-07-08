package com.sample.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.weather.holder.WeatherResponse;
import com.sample.weather.service.WeatherService;

import lombok.extern.slf4j.Slf4j;

@ComponentScan("com.sample.weather")
@RestController
@RequestMapping(value = "/weather")
@Slf4j
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	
	@GetMapping(value = "/byCity")
	public WeatherResponse getWeatherByCityId(@RequestParam(required = false, value = "city") String city,
			@RequestParam(required = false, value = "country") String country) {
		log.info("getWeatherByCityId request started "+"city:: "+city+" country:: "+ country);
		return weatherService.getWeatherByCity(city, country);
		    
	}

	@GetMapping(value = "/byOrdinates")
	public WeatherResponse getWeatherByOrdinates(@RequestParam(required = false, value = "lat") String latitude,
			@RequestParam(required = false, value = "lon") String longitude) {
		log.info("getWeatherByOrdinates request started "+"latitute:: "+latitude+" longitude:: "+ longitude);
		return weatherService.getWeatherByOrdinates(latitude, longitude);
	}

}
