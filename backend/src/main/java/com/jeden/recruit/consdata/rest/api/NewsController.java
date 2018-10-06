package com.jeden.recruit.consdata.rest.api;

import java.util.Collections;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeden.recruit.consdata.helpers.Country;
import com.jeden.recruit.consdata.rest.to.Article;
import com.jeden.recruit.consdata.rest.to.News;

@RestController
@RequestMapping("/api")
public class NewsController {
	
	@RequestMapping("/news")
	public News news() {
		News news = new News();
		news.setCountry(Country.PL);
		
		Article article = new Article();
		
		article.setAuthor("testAuthor");
		article.setDescription("test description 2");
		
		news.setArticles( Collections.singletonList( article));
		
		return news;
		
	}

}
