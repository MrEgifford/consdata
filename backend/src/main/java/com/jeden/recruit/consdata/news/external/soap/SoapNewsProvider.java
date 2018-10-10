package com.jeden.recruit.consdata.news.external.soap;

import java.util.Map;

import com.jeden.recruit.consdata.exception.NotImplementedException;
import com.jeden.recruit.consdata.news.external.NewsProvider;
import com.jeden.recruit.consdata.news.external.rest.dto.NewsResponse;

public class SoapNewsProvider implements NewsProvider {


	@Override
	public NewsResponse findAllForParams(Map<String, String> urlParameters) {
		throw new NotImplementedException();
	}

}
