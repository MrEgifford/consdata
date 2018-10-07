package com.jeden.recruit.consdata.news.external.soap;

import com.jeden.recruit.consdata.news.external.NewsProvider;
import com.jeden.recruit.consdata.news.external.rest.to.NewsResponse;

public class SoapNewsProvider implements NewsProvider {

	private static final String NOT_IMPLEMENTED = "NOT_IMPLEMENTED";

	@Override
	public NewsResponse getAllForCountry(String countryCode) {
		NewsResponse response = new NewsResponse();
		response.setStatus(NOT_IMPLEMENTED);
		return response;
	}

}
