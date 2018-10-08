package com.jeden.recruit.consdata.news.external.soap;

import java.util.Map;

import javax.naming.ConfigurationException;

import com.jeden.recruit.consdata.exception.NotImplementedException;
import com.jeden.recruit.consdata.news.external.NewsProvider;
import com.jeden.recruit.consdata.news.external.rest.dto.NewsResponse;

public class SoapNewsProvider implements NewsProvider {

	@Override
	public NewsResponse getAllForCountry(String countryCode) {
		throw new NotImplementedException();
	}

	@Override
	public NewsResponse getAllForParams(Map<String, String> urlParameters) throws ConfigurationException {
		throw new NotImplementedException();
	}

}
