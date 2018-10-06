package com.jeden.recruit.consdata.config.impl;

import java.util.Properties;

import com.jeden.recruit.consdata.config.Configuration;
import com.jeden.recruit.consdata.helpers.PropertyKey;

public class ConfigurationImpl implements Configuration {
	
	private Properties properties;
	
	public ConfigurationImpl() {
		properties = new Properties();
		properties.setProperty(PropertyKey.API_KEY.getPropertyKey(), "3ed8182bbb22493c882eff85abab0c8f");
	}

	@Override
	public String getProperty(PropertyKey property) {
		return properties.getProperty(property.getPropertyKey());
	}


}
