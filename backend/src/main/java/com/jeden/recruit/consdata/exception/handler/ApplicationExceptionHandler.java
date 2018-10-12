package com.jeden.recruit.consdata.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jeden.recruit.consdata.exception.ConfigurationException;
/**
 * Exception handler for handling the exceptions thrown by the application.
 * 
 * @author Egifford
 *
 */
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { RuntimeException.class })
	protected ResponseEntity<Object> handleConflict( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "Wystąpił błąd aplikacji: " + ex.getMessage();
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), 
				HttpStatus.CONFLICT, request);
	}
	
	@ExceptionHandler(value = { ConfigurationException.class,  })
	protected ResponseEntity<Object> handleConflict(ConfigurationException exc,  WebRequest request) {
		
		String bodyOfResponse = "Wystąpił błąd w konfiguracji aplikacji: " + exc.getMessage();
		return handleExceptionInternal(exc, bodyOfResponse, new HttpHeaders(), 
				HttpStatus.CONFLICT, request);
	}

}
