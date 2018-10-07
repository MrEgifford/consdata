package com.jeden.recruit.consdata.news.core.impl;

import javax.naming.ConfigurationException;
import org.dozer.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeden.recruit.consdata.news.core.NewsFacade;
import com.jeden.recruit.consdata.news.external.NewsProvider;
import com.jeden.recruit.consdata.news.to.NewsDto;

@Component
public class NewsFacadeImpl implements NewsFacade {
	
	@Autowired
	private NewsProvider newsProvider;
	
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public NewsDto findForCountry(String countryCode) {
		
		try {
			 newsProvider.getAllForCountry(countryCode);
			 
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new NewsDto();
	}

}
