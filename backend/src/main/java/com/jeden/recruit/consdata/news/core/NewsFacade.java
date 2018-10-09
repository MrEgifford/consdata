package com.jeden.recruit.consdata.news.core;

import java.util.Map;

import com.jeden.recruit.consdata.news.dto.NewsDto;

public interface NewsFacade {
	
	/**
	 * Returns all news for a given country.
	 * 
	 * @param countryCode - two letters country code. Ex 'pl' or 'de'
	 * @return container object with articles for certain country.
	 */
	NewsDto findForCountry(String countryCode);
	
	
	/**
	 * General method returning news basing on the given parameters.
	 * Allowed parameters may be found under 
	 * <i>https://newsapi.org/docs/endpoints/top-headlines</i> 
	 * 
	 * @param requestParameters
	 * @return
	 */
	NewsDto findForParameters(Map<String, String> requestParameters);
	
	
	
	

}
