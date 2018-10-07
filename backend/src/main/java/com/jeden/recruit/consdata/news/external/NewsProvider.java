package com.jeden.recruit.consdata.news.external;

import javax.naming.ConfigurationException;

import com.jeden.recruit.consdata.news.external.rest.to.NewsResponse;

public interface NewsProvider {
	
	public NewsResponse getAllForCountry(String countryCode) throws ConfigurationException;

}
