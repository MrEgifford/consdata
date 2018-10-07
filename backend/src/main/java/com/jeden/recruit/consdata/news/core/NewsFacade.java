package com.jeden.recruit.consdata.news.core;

import com.jeden.recruit.consdata.news.to.NewsDto;

public interface NewsFacade {
	
	NewsDto findForCountry(String countryCode);

}
