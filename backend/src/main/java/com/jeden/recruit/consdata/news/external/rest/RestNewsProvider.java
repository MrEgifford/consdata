package com.jeden.recruit.consdata.news.external.rest;

import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import javax.naming.ConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import com.jeden.recruit.consdata.config.ConfigurationProps;
import com.jeden.recruit.consdata.cons.PropertyKey;
import com.jeden.recruit.consdata.cons.UrlParams;
import com.jeden.recruit.consdata.exception.handler.RestExceptionHandler;
import com.jeden.recruit.consdata.helpers.RestURLBuilder;
import com.jeden.recruit.consdata.news.external.NewsProvider;
import com.jeden.recruit.consdata.news.external.rest.dto.NewsResponse;

public class RestNewsProvider implements NewsProvider {
	
	@Autowired
	private ConfigurationProps configuration;
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	

	@Override
	public NewsResponse getAllForCountry(String countryCode) throws ConfigurationException {
		return getAllForParams(Collections.singletonMap(
				UrlParams.COUNTRY_PARAM, countryCode));
	}
	
	@Override
	public NewsResponse getAllForParams(Map<String, String> urlParameters) throws ConfigurationException {
		RestTemplate restTemplate = restTemplateBuilder
				.errorHandler( new RestExceptionHandler())
				.build();
		return restTemplate.getForObject(
					prepareUri(urlParameters), 
					NewsResponse.class);
	}
	
	//-------------------- PRIVATE METHODS -------------------

	private URI prepareUri(Map<String, String> parameters) throws ConfigurationException {
		Optional<String> externalApiURL = 
				configuration.getProperty(PropertyKey.EXTERNAL_API_PATH);
		Optional<String> apiKey = 
				configuration.getProperty(PropertyKey.API_KEY);
		
		checkPropertiesExistance(externalApiURL, apiKey);
		
		return RestURLBuilder.createRestURL(externalApiURL.get(), apiKey.get())
				.withParams(parameters)
				.buildURL();
	}

	private void checkPropertiesExistance(Optional<String> externalApiURL, 
			Optional<String> apiKey)
			throws ConfigurationException {
		
		if(!externalApiURL.isPresent() || !apiKey.isPresent() ) {
			throw new ConfigurationException(
					String.format("No mandatory %s or %s properties defined. "
					+ "Please check your configuration file ", 
					PropertyKey.EXTERNAL_API_PATH.getPropertyKey(),
					PropertyKey.API_KEY.getPropertyKey()));
		}
	}

}
