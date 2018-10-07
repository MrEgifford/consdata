package com.jeden.recruit.consdata.news.external.rest.to;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ArticleResponse {
	
	private SourceResponse source;
	
	private String author;
	
	private String title;
	
	private String description;
	
	private String url;
	
	private String urlToImage;
	
	private LocalDateTime publishedAt; 
	
	private String content;

}
