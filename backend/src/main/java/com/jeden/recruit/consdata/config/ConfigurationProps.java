package com.jeden.recruit.consdata.config;

import java.util.Map;
import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jeden.recruit.consdata.cons.PropertyKey;

@Configuration
@ConfigurationProperties(prefix = "news")
public class ConfigurationProps {
	
	private Map<String, String> properties; 
	
	public Optional<String> getProperty(PropertyKey property) {
		return Optional.of(properties.get(property.getPropertyKey()));
	};
	
	public Map<String, String> getProperties() {
		return properties;
	}
	
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

}
