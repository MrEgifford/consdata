package com.jeden.recruit.consdata.news.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ArticleDto {
	
	private String author;
	
	private String title;
	
	private String description;
	
	private LocalDateTime date;
	
	private String sourceName;
	
	private String articleUrl;
	
	private String imageUrl;
	

}
