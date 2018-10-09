package com.jeden.recruit.consdata.news.core.impl;

import java.util.Map;

import javax.naming.ConfigurationException;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	public NewsDto findForCountry(String countryCode) {
		
		try {
			
			NewsResponse newsResponse = newsProvider.getAllForCountry(countryCode);
			NewsDto newsDto = mapper.map(newsResponse, NewsDto.class);
			newsDto.setCountry(countryCode);
			return newsDto;
			 
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new NewsDto();
	}


	@Override
	public NewsDto findForParameters(Map<String, String> requestParameters) {
		// TODO Auto-generated method stub
		return null;
	}

}
