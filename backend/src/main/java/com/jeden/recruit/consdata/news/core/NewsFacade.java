package com.jeden.recruit.consdata.news.core;

import com.jeden.recruit.consdata.news.dto.NewsDto;

public interface NewsFacade {
	
	NewsDto findForCountry(String countryCode);

}
