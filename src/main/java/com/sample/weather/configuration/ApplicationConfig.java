package com.sample.weather.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.sample.weather.exception.ServiceResponseErrorHandler;

@Configuration
public class ApplicationConfig {

	@Autowired
    private RestTemplateBuilder restTemplateBuilder;
	
	@Bean
    public RestTemplate restTemplate(){
        return restTemplateBuilder.build();
    }
	
	
}
