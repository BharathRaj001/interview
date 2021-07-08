package com.sample.weather.exception;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.ResponseErrorHandler;

public class ServiceResponseErrorHandler implements ResponseErrorHandler {

    private List<HttpMessageConverter<?>> messageConverters;

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        
        return (response.getStatusCode().is4xxClientError() ||
                response.getStatusCode().is5xxServerError());
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        
        @SuppressWarnings({ "unchecked", "rawtypes" })
        HttpMessageConverterExtractor<Error> errorMessageExtractor = 
                new HttpMessageConverterExtractor(Error.class, messageConverters);
        
        Error errorObject = errorMessageExtractor.extractData(response);
        
       throw new ResponseEntityErrorException(
               ResponseEntity.status(response.getRawStatusCode())
                                .headers(response.getHeaders())
                                .body(errorObject)
               );
      
    }

    public void setMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
        this.messageConverters = messageConverters;
    }
}