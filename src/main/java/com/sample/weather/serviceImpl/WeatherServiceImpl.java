package com.sample.weather.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.sample.weather.exception.WeatherServiceException;
import com.sample.weather.holder.WeatherResponse;
import com.sample.weather.service.WeatherService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    private ServiceInvoke serviceInvoke;
    
    @Value("${weather.appKey}")
    private  String appKey;
    
    @Value("${weather.url}")
    private  String url;
    

    @Cacheable(value="weatherByCity",key = "new org.springframework.cache.interceptor.SimpleKey(#city, #country)")
	public WeatherResponse getWeatherByCity(String city,String country)  throws WeatherServiceException{
    	log.info("Entered getWeatherByCity");
    	 
    	UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(url).path("")
				.query("q={keyword}&appid={appid}")
				.buildAndExpand(String.join(",", city, country), appKey);
    	 
    	log.info("getWeatherByCity url:: ", uriComponents.toUriString());
    	
    	 return serviceInvoke.get(uriComponents.toUriString(),WeatherResponse.class);
	}
    
    
	@Cacheable(value="weatherByOrdinates",key = "new org.springframework.cache.interceptor.SimpleKey(#latitude, #longitude)")
	public WeatherResponse getWeatherByOrdinates(String latitude, String longitude)  throws WeatherServiceException{
		log.info("Entered getWeatherByOrdinates");
		 
		UriComponents	uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(url).path("")
				.query("lat={lat}&lon={lon}&appid={appid}").buildAndExpand(latitude, longitude, appKey);
		 
		log.info("weatherByOrdinates url:: ", uriComponents.toUriString());
		
		 return serviceInvoke.get(uriComponents.toUriString(),WeatherResponse.class);	
		
	}	
	
	
}
