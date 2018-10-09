package com.jeden.recruit.consdata.news.api;

import java.util.Collections;

import javax.naming.ConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeden.recruit.consdata.cons.Country;
import com.jeden.recruit.consdata.news.core.NewsFacade;
import com.jeden.recruit.consdata.news.dto.ArticleDto;
import com.jeden.recruit.consdata.news.dto.NewsDto;
import com.jeden.recruit.consdata.news.external.NewsProvider;


@RestController
@RequestMapping("/api")
public class NewsController {
	
	@Autowired
	private NewsFacade newsFacade;
	
	@RequestMapping("/news/{country}/{category}")
	public NewsDto news(@PathVariable String country, @PathVariable String category) {
		
		
		return newsFacade.findForCountry(country);
		
		
	}

}
