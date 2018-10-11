package com.jeden.recruit.consdata.config;

import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.jeden.recruit.consdata.cons.PropertyKey;
import com.jeden.recruit.consdata.exception.ConfigurationException;

@Configuration
@Component
@ConfigurationProperties(prefix = "news")
public class ConfigurationProps {
	
	private Map<String, String> properties; 
	
	@PostConstruct
	private void init() throws ConfigurationException {
		Optional<String> externalApiURL = 
				getProperty(PropertyKey.EXTERNAL_API_PATH);
		Optional<String> apiKey = 
				getProperty(PropertyKey.API_KEY)
					.ofNullable(PropertyKey.NEWS_PROVIDER_TYPE_REST.getPropertyKey());
		checkPropertiesExistance(externalApiURL, apiKey);
	}
	
	public Optional<String> getProperty(PropertyKey property) {
		return Optional.ofNullable(properties.getOrDefault(property.getPropertyKey(), ""));
	}
	
	public Map<String, String> getProperties() {
		return properties;
	}
	
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
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
