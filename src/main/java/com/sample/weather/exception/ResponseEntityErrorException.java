package com.sample.weather.exception;

import org.springframework.http.ResponseEntity;

public class ResponseEntityErrorException extends RuntimeException  {
    
    private ResponseEntity<Error> serviceErrorResponseResponse;

    public ResponseEntityErrorException(ResponseEntity<Error> serviceErrorResponseResponse) {
        this.serviceErrorResponseResponse = serviceErrorResponseResponse;
    }
    
    public ResponseEntity<Error> getServiceErrorResponseResponse() {
        return serviceErrorResponseResponse;
    }
}