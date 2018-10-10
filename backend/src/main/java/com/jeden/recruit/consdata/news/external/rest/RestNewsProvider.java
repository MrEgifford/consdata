package com.jeden.recruit.consdata.news.external.rest;

import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import com.jeden.recruit.consdata.config.ConfigurationProps;
import com.jeden.recruit.consdata.cons.PropertyKey;
import com.jeden.recruit.consdata.cons.UrlParams;
import com.jeden.recruit.consdata.exception.ConfigurationException;
import com.jeden.recruit.consdata.exception.handler.RestExceptionHandler;
import com.jeden.recruit.consdata.helpers.RestURLBuilder;
import com.jeden.recruit.consdata.news.external.NewsProvider;
import com.jeden.recruit.consdata.news.external.rest.dto.NewsResponse;
/**
 * External REST API gateway.
 * 
 * @author Egifford
 *
 */
public class RestNewsProvider implements NewsProvider {
	
	@Autowired
	private ConfigurationProps configuration;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	

	
	@Override
	public NewsResponse findAllForParams(Map<String, String> urlParameters) {
		RestTemplate restTemplate = restTemplateBuilder
				.errorHandler( new RestExceptionHandler())
				.build();
		
		return restTemplate.getForObject(
					prepareUri(urlParameters), 
					NewsResponse.class);
	}
	
	//-------------------- PRIVATE METHODS -------------------

	private URI prepareUri(Map<String, String> parameters) {
		Optional<String> externalApiURL = 
				configuration.getProperty(PropertyKey.EXTERNAL_API_PATH);
		Optional<String> apiKey = 
				configuration.getProperty(PropertyKey.API_KEY);
		
		
		return RestURLBuilder.createRestURL(externalApiURL.get(), apiKey.get())
				.withParams(parameters)
				.buildURL();
	}

	

}
