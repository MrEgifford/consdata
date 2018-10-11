package com.jeden.recruit.consdata.news.core;

import java.util.Map;

import com.jeden.recruit.consdata.news.dto.NewsDto;
/**
 * 
 * @author Egifford
 *
 */
public interface NewsFacade {
	
	
	/**
	 * General method returning news basing on the given parameters.
	 * Allowed parameters may be found under: 
	 * <i>https://newsapi.org/docs/endpoints/top-headlines</i> 
	 * 
	 * @return container object with articles for given parameters.
	 */
	NewsDto findForParameters(Map<String, String> requestParameters);
	
	
	
	

}
