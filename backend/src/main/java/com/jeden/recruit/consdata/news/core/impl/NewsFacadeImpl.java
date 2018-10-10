package com.jeden.recruit.consdata.news.core.impl;

import java.util.Map;


import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeden.recruit.consdata.cons.UrlParams;
import com.jeden.recruit.consdata.exception.ConfigurationException;
import com.jeden.recruit.consdata.news.core.NewsFacade;
import com.jeden.recruit.consdata.news.dto.NewsDto;
import com.jeden.recruit.consdata.news.external.NewsProvider;
import com.jeden.recruit.consdata.news.external.rest.dto.NewsResponse;

@Component
public class NewsFacadeImpl implements NewsFacade {
	
	@Autowired
	private NewsProvider newsProvider;
	
	@Autowired
	private DozerBeanMapper mapper;
	

	


	@Override
	public NewsDto findForParameters(Map<String, String> requestParameters)  {
		 NewsResponse allForParams = newsProvider.findAllForParams(requestParameters);
		 return mapToDto(allForParams, requestParameters);
	}


	private NewsDto mapToDto(NewsResponse newsResponse, Map<String, String> requestParameters) {
		NewsDto newsDto = mapper.map(newsResponse, NewsDto.class);
		newsDto.setCountry(requestParameters.get(UrlParams.COUNTRY_PARAM));
		newsDto.setCategory(requestParameters.get(UrlParams.CATEGORY_PARAM));
		
		return newsDto;
		
	}

}
