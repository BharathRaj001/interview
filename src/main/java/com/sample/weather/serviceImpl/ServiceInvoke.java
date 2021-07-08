package com.sample.weather.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.sample.weather.exception.WeatherServiceException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServiceInvoke {

	@Autowired
	RestTemplate restTemplate;
	
	public <T> T get(String uri, Class<T> responseType) {
		ResponseEntity<T> exchange=null;
		try {
			
		exchange =restTemplate.exchange(uri, HttpMethod.GET, null, responseType);
		log.info("rest call execution Completed with status:: ", exchange.getStatusCode().toString());
		}
		catch(HttpClientErrorException | HttpServerErrorException e){
			log.info("Exception occured with status:: ", e.getStatusCode().toString());
			ResponseEntity<String> responseEntity=new ResponseEntity<>(e.getResponseBodyAsString(),e.getStatusCode());
			throw new WeatherServiceException(String.valueOf(responseEntity.getStatusCode()),responseEntity.getBody());

		}
		
		
		return exchange.getBody();
	}
	
	
}
