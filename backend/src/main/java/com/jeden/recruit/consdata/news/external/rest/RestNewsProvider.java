package com.jeden.recruit.consdata.news.external.rest;

import java.net.URI;
import java.util.Optional;

import javax.naming.ConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.jeden.recruit.consdata.config.ConfigurationProps;
import com.jeden.recruit.consdata.exception.RestExceptionHandler;
import com.jeden.recruit.consdata.helpers.PropertyKey;
import com.jeden.recruit.consdata.helpers.RestURLBuilder;
import com.jeden.recruit.consdata.news.external.NewsProvider;
import com.jeden.recruit.consdata.news.external.rest.to.NewsResponse;

public class RestNewsProvider implements NewsProvider {
	
	@Autowired
	private ConfigurationProps configuration;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	

	@Override
	public NewsResponse getAllForCountry(String countryCode) throws ConfigurationException {
		
		RestTemplate restTemplate = restTemplateBuilder
			.errorHandler( new RestExceptionHandler())
			.build();
		NewsResponse response = restTemplate.getForObject(prepareUri(), NewsResponse.class);
		return response;
	}

	private URI prepareUri() throws ConfigurationException {
		Optional<String> externalApiURL = 
				configuration.getProperty(PropertyKey.EXTERNAL_API_PATH);
		Optional<String> apiKey = 
				configuration.getProperty(PropertyKey.API_KEY);
		
		checkPropertiesExistance(externalApiURL, apiKey);
		
		return RestURLBuilder.createRestURL(externalApiURL.get(), apiKey.get()).buildURL();
	}

	private void checkPropertiesExistance(Optional<String> externalApiURL, Optional<String> apiKey)
			throws ConfigurationException {
		
		if(!externalApiURL.isPresent() || !apiKey.isPresent() ) {
			throw new ConfigurationException(String.format("No mandatory %s or %s properties defined. "
					+ "Please check your configuration file ", 
					PropertyKey.EXTERNAL_API_PATH.getPropertyKey(),
					PropertyKey.API_KEY.getPropertyKey()));
		}
	}

}
