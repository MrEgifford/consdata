package com.jeden.recruit.consdata.news.external;

import java.util.Map;

import com.jeden.recruit.consdata.exception.ConfigurationException;
import com.jeden.recruit.consdata.news.external.rest.dto.NewsResponse;

public interface NewsProvider {
	
	
	/**
	 * Returns news response object basing on the parameters in the map.
	 * 
	 * @param urlParameters key-value pairs that will be set in the URL as key=value 
	 * @return news object containing articles.
	 * @throws ConfigurationException if application configuration does not contain mandatory settings.
	 */
	NewsResponse findAllForParams(Map<String, String> urlParameters);

}
