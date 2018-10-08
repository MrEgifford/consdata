package com.jeden.recruit.consdata.exception.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.jeden.recruit.consdata.exception.RestClientConnectionException;



public class RestExceptionHandler implements ResponseErrorHandler {
	
	Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		Series series = response.getStatusCode().series();
		return ( series == Series.CLIENT_ERROR 
		          || series == Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		String errorMsg = String.format("Can not execute rest operation (status code: %s ) due to: %s. \\n %s",
				response.getStatusCode(),
				response.getStatusText(),
				convertStreamToString(response.getBody()));
		
		logger.error(errorMsg);
		throw new RestClientConnectionException(errorMsg);
	}
	
	private String convertStreamToString(InputStream is) {
	    
		try(Scanner s = new Scanner(is).useDelimiter("\\A")){
	    	return  s.hasNext() ? s.next() : "";
	    }
	    
	}

}
