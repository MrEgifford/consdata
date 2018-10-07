package com.jeden.recruit.consdata.news.api;

import java.util.Collections;

import javax.naming.ConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeden.recruit.consdata.helpers.Country;
import com.jeden.recruit.consdata.news.core.NewsFacade;
import com.jeden.recruit.consdata.news.external.NewsProvider;
import com.jeden.recruit.consdata.news.to.ArticleDto;
import com.jeden.recruit.consdata.news.to.NewsDto;


@RestController
@RequestMapping("/api")
public class NewsController {
	
	@Autowired
	private NewsFacade newsFacade;
	
	@RequestMapping("/news")
	public NewsDto news() {
		NewsDto news = new NewsDto();
		news.setCountry(Country.PL);
		
		ArticleDto article = new ArticleDto();
		
		article.setAuthor("testAuthor");
		article.setDescription("test description 2");
		
		news.setArticles( Collections.singletonList( article));
		
		
		newsFacade.findForCountry(Country.PL.getShortCode());
		
		
		return news;
		
	}

}
