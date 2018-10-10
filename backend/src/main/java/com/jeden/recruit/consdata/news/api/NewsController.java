package com.jeden.recruit.consdata.news.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeden.recruit.consdata.cons.UrlParams;
import com.jeden.recruit.consdata.exception.ConfigurationException;
import com.jeden.recruit.consdata.news.core.NewsFacade;
import com.jeden.recruit.consdata.news.dto.NewsDto;


@RestController
@RequestMapping("/api")
public class NewsController {
	
	@Autowired
	private NewsFacade newsFacade;
	
	
	@RequestMapping("/news/{country}/{category}/")
	public NewsDto news(@PathVariable String country, 
						@PathVariable String category, 
						@RequestParam Optional<String> keyword)
								throws ConfigurationException {
		
		Map<String, String> preparedParamMap = prepareParamMap(country, category, keyword.orElse(""));
		return newsFacade.findForParameters(preparedParamMap);
	}

	private Map<String, String> prepareParamMap(String country, String category, String keyword) {
		Map<String, String> parametersMap = new HashMap<>();
		parametersMap.put(UrlParams.COUNTRY_PARAM, country);
		parametersMap.put(UrlParams.CATEGORY_PARAM, category);
		parametersMap.put(UrlParams.KEYWORD_PARAM, keyword);
		
		return parametersMap;
	}

}
