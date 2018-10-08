package com.jeden.recruit.consdata.news.external;

import java.util.Map;

import javax.naming.ConfigurationException;

import com.jeden.recruit.consdata.news.external.rest.dto.NewsResponse;

import lombok.NonNull;

public interface NewsProvider {
	
	/**
	 * Returns news response for a given country.
	 * 
	 * @param countryCode - shortcode of the country. Example: 'pl'.
	 * @return news object containing articles.
	 * @throws ConfigurationException if application configuration does not contain mandatory settings.
	 */
	NewsResponse getAllForCountry(@NonNull String countryCode) throws ConfigurationException;
	
	/**
	 * Returns news response object basing on the parameters in the map.
	 * 
	 * @param urlParameters key-value pairs that will be set in the URL as key=value 
	 * @return news object containing articles.
	 * @throws ConfigurationException if application configuration does not contain mandatory settings.
	 */
	NewsResponse getAllForParams(Map<String, String> urlParameters) throws ConfigurationException;

}
